package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

	private static final String NO_CARS_EXCEPTION_MESSAGE = "차가 없습니다";
	private static final int TRIAL_COUNT_MIN = 1;
	private static final String EXCEPTION_TRIAL_COUNT =
		"시도 횟수는 " + TRIAL_COUNT_MIN + " 이상이어야 합니다";

	private final List<Car> cars;

	private Cars(List<Car> carList) {
		this.cars = carList;
	}

	public static Cars ofNames(List<String> names) {
		List<Car> carList = names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(carList);
	}

	private String race() {
		cars.forEach(Car::move);
		return this.toString();
	}

	public String race(int trialCount) {
		validateTrialCount(trialCount);
		return IntStream.range(0, trialCount)
			.mapToObj(i -> race())
			.collect(Collectors.joining(System.lineSeparator()));
	}

	private void validateTrialCount(int trialCount) {
		if (trialCount < TRIAL_COUNT_MIN) {
			throw new IllegalArgumentException(EXCEPTION_TRIAL_COUNT);
		}
	}

	private Car findMaxCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException(NO_CARS_EXCEPTION_MESSAGE));
	}

	public Cars findWinners() {
		Car maxCar = findMaxCar();
		List<Car> winners = cars.stream()
			.filter(maxCar::hasSamePositionWith)
			.collect(Collectors.toList());
		return new Cars(winners);
	}

	public List<String> getNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.map(s -> s + System.lineSeparator())
			.collect(Collectors.joining());
	}
}
