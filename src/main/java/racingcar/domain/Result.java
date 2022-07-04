package racingcar.domain;

public class Result {

	private static final String RESULT_FORMAT = "최종 우승자 : %s";
	private final Cars cars;

	public Result(Cars cars) {
		this.cars = cars;
	}

	public static Result of(Cars cars) {
		return new Result(cars);
	}

	private String getWinnersToString() {
		StringBuilder builder = new StringBuilder();
		for (Car winner : cars.findWinners())
			builder.append(winner);
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format(RESULT_FORMAT, getWinnersToString());
	}
}
