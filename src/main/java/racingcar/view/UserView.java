package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserView {

	private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
	private static final String MESSAGE_RESULT = "실행 결과";
	private static final String EXCEPTION_NAME_LENGTH_FORMAT = "이름의 길이는 %d자 이상 %d자 이하 입니다";
	private static final String EXCEPTION_TRIAL_COUNT = "잘못된 시도 횟수입니다";
	private static final String CAR_NAME_DELIMITER = ",";
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final char TRIAL_COUNT_CHAR_MIN = '1';
	private static final char TRIAL_COUNT_CHAR_MAX = '9';
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static List<String> readCarNames() {
		System.out.println(PROMPT_CAR_NAME);
		String input = Console.readLine();
		List<String> carNames = parseCarName(input);
		carNames.forEach(UserView::validateCarNameLength);
		return carNames;
	}

	private static List<String> parseCarName(String input) {
		String[] carNames = input.split(CAR_NAME_DELIMITER, -1);
		return Arrays.asList(carNames);
	}

	private static void validateCarNameLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
			throw new IllegalArgumentException(
				String.format(EXCEPTION_NAME_LENGTH_FORMAT, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
	}

	public static int readTrialCount() {
		System.out.println(PROMPT_TRIAL_COUNT);
		String input = Console.readLine();
		validateTrialCount(input);
		return Integer.parseInt(input);
	}

	public static void validateTrialCount(String input) {
		for (char c : input.toCharArray()) {
			if (c < TRIAL_COUNT_CHAR_MIN || c > TRIAL_COUNT_CHAR_MAX) {
				throw new IllegalArgumentException(EXCEPTION_TRIAL_COUNT);
			}
		}
	}

	public static void printResult(String result) {
		System.out.println(MESSAGE_RESULT);
		System.out.println(result);
	}

	public static void printWinner(String winner) {
		System.out.println(winner);
	}

	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
