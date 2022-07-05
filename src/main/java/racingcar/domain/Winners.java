package racingcar.domain;

public class Winners {

	private static final String FORMAT_WINNER = "최종 우승자 : %s";
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
		return String.format(FORMAT_WINNER, getWinnersToString());
	}
}
