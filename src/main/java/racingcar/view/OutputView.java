package racingcar.view;

public class OutputView {


	private static final String MESSAGE_RESULT = "실행 결과";
	private static final String ERROR_PREFIX = "[ERROR] ";

	public void printResult(String result) {
		System.out.println(MESSAGE_RESULT);
		System.out.println(result);
	}

	public void printWinner(String winner) {
		System.out.println(winner);
	}

	public void printError(String message) {
		System.err.println(ERROR_PREFIX + message);
	}
}
