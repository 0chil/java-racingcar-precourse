package racingcar.car.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.strategy.MoveStrategy;

public class Cars {

	private static final String NO_CARS_EXCEPTION_MESSAGE = "차가 없습니다";

	private final List<Car> cars;

	/**
	 * 학습용 주석
	 * 전략은 어디서 Composite 해야할까?
	 * 자동차의 움직임은 자동차 스스로가 결정해야 한다고 생각한다.
	 * 자동차들을 관리하는 클래스인 Cars에서 결정하게 되면 만들기가 편하다.
	 * 그러나 누군가는 고정된 전략으로, 누군가는 랜덤 전략으로 움직이게 할 수 없다.
	 * 즉, 자동차의 개성이 사라진다. 그래도 움직일 수는 있어 혼자서 사용은 여전히 가능하다.
	 * *
	 * MoveStrategy interface를 만들었다.
	 * 1. 조합을 통해 Car class에 내장시킨다면?
	 * 장점: 움직임 전략을 지정해서 Car를 만들 수 있다.(개성)
	 * 단점: Car를 만들때 움직임 전략을 포함시켜야 하므로 객체 생성이 귀찮다.
	 * -> (Cars를 거쳐 Car로 전달되어야 하는데, 전략 리스트를 넣기는 무리다)
	 * *
	 * 2. 조합을 통해 Cars class에 내장시킨다면?
	 * 장점: 만들기가 편하다! 전략은 딱 하나만 넣어주면 된다.
	 * 전략이 변경 될 경우 전략을 넣은 곳에서만 수정해주면 된다.
	 * 단점: 자동차의 개성이 사라진다.
	 * *
	 * 그런데, 단점이 장점이 될 수도 있다. 이 프로그램의 경우 모두가 같은 전략으로 움직이고 있다.
	 * 그래서 Car에 내장하는 것은 굳이 필요 없는데 프로그램을 복잡하게 만들 가능성이 높아 보인다.
	 * *
	 * 정말 필요하다면, 그 때 수정을 통해 그렇게 디자인을 변경하는 편이 좋아 보인다.
	 * 변경을 쉽게(영향을 덜 받게) 만들되, 미래를 점치려고 하지 말자. 어차피 예측할 수 없다.
	 * *
	 * 그런데, 다음처럼 하면 일급 컬렉션이 아니게 되는 건가?
	 */
	private final MoveStrategy moveStrategy;

	public Cars(List<Car> cars, MoveStrategy moveStrategy) {
		this.cars = cars;
		this.moveStrategy = moveStrategy;
	}

	public void race() {
		for (Car car : cars)
			race(car);
	}

	private void race(Car car) {
		if (moveStrategy.isMovable())
			car.move();
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
	 * 학습용 주석
	 * 사용이유: 자동차를 꺼냄으로서 변경 가능하게 되는 현상을 막고자 함(상태만 꺼내고 싶음)
	 * 의문점: DTO가 이 레이어에 들어와있어도 되나?
	 * 장점: 자동차의 상태만 담아 꺼낼 수 있다.(Car 객체의 상태와 분리된다)
	 * 단점: 코드가 복잡해지고 DTO에 대한 의존성이 생긴다.
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
