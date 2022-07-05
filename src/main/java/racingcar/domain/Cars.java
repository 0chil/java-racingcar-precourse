package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private static final String EXCEPTION_NO_CARS = "차가 없습니다";
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public void race() {
		carList.forEach(Car::move);
	}

	private Car findMaxCar() {
		return carList.stream().max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NO_CARS));
	}

	public Cars findWinners() {
		Car maxCar = findMaxCar();
		List<Car> winners = carList.stream()
			.filter(maxCar::isPositionSame)
			.collect(Collectors.toList());
		return new Cars(winners);
	}

	public List<String> getNames() {
		return carList.stream().map(Car::getName).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return carList.stream()
			.map(Car::toString)
			.map(s -> s + System.lineSeparator())
			.collect(Collectors.joining());
	}
}
