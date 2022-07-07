package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

	private static final String CAR_NAME_DELIMITER = ",";
	private static final int DISCARD_TRAILING_BLANK = -1;

	private static final char NUMERIC_MIN = '0';
	private static final char NUMERIC_MAX = '9';
	private static final String EXCEPTION_TRIAL_COUNT = "시도 횟수는 숫자여야 합니다";

	private InputView() {
	}

	public static List<String> readCarNames() {
		System.out.println(PROMPT_CAR_NAME);
		String input = Console.readLine();
		return parseCarName(input);
	}

	private static List<String> parseCarName(String input) {
		String[] carNames = input.split(CAR_NAME_DELIMITER, DISCARD_TRAILING_BLANK);
		return Arrays.asList(carNames);
	}

	public static int readTrialCount() {
		System.out.println(PROMPT_TRIAL_COUNT);
		String input = Console.readLine();
		validateNumeric(input);
		return Integer.parseInt(input);
	}

	private static void validateNumeric(String input) {
		for (char c : input.toCharArray()) {
			if (c < NUMERIC_MIN || c > NUMERIC_MAX) {
				throw new IllegalArgumentException(EXCEPTION_TRIAL_COUNT);
			}
		}
	}
}
