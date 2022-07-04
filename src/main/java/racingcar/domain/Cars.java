package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	private Car findMaxCar() {
		return cars.stream().max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException("없는 차가 있습니다"));
	}

	public List<Car> findWinners() {
		Car maxCar = findMaxCar();
		return cars.stream().filter(maxCar::isPositionSame)
			.collect(Collectors.toList());
	}
}
