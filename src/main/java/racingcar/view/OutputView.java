package racingcar.view;

public class OutputView {


	private static final String MESSAGE_RESULT = "실행 결과";
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static void printResult(String result) {
		System.out.println(MESSAGE_RESULT);
		System.out.println(result);
	}

	public static void printWinner(String winner) {
		System.out.println(winner);
	}

	public static void printError(String message) {
		System.err.println(ERROR_PREFIX + message);
	}
}
