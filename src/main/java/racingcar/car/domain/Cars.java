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
			.map(Car::toDTO)
			.collect(Collectors.toList());
	}

	public List<CarDTO> getCars() {
		return cars.stream()
			.map(Car::toDTO)
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining(System.lineSeparator()));
	}
}
