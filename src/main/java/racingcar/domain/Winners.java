package racingcar.domain;

public class Winners {

	private static final String WINNER_PREFIX = "최종 우승자 : ";
	private static final String DELIMITER = ", ";
	private final Cars cars;

	private Winners(Cars cars) {
		this.cars = cars;
	}

	public static Winners of(Cars cars) {
		return new Winners(cars);
	}

	private String getWinnersToString() {
		return String.join(DELIMITER, cars.findWinners().getNames());
	}

	@Override
	public String toString() {
		return WINNER_PREFIX + getWinnersToString();
	}
}
