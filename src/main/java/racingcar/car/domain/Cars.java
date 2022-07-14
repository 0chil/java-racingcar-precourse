package racingcar.car.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.strategy.MoveStrategy;

public class Cars {

	private static final String NO_CARS_EXCEPTION_MESSAGE = "차가 없습니다";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void race(MoveStrategy moveStrategy) {
		for (Car car : cars)
			car.move(moveStrategy);
	}

	private Car findMaxCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException(NO_CARS_EXCEPTION_MESSAGE));
	}

	public List<CarDTO> findWinners() {
		Car maxCar = findMaxCar();
		return cars.stream()
			.filter(maxCar::hasSamePositionWith)
			.map(CarDTO::from)
			.collect(Collectors.toList());
	}

	/**
	 학습용 주석
	 사용이유: 자동차를 꺼냄으로서 변경 가능하게 되는 현상을 막고자 함(상태만 꺼내고 싶음)
	 의문점: DTO가 이 레이어에 들어와있어도 되나?
	 장점: 자동차의 상태만 담아 꺼낼 수 있다.(Car 객체의 상태와 분리된다)
	 단점: 코드가 복잡해지고 DTO에 대한 의존성이 생긴다.
	 */
	public List<CarDTO> getCars() {
		return cars.stream()
			.map(CarDTO::from)
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining(System.lineSeparator()));
	}
}
