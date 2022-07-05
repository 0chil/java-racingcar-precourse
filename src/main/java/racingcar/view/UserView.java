package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserView {

	private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
	private static final String MESSAGE_RESULT = "실행 결과";
	private static final String CAR_NAME_DELIMITER = ",";

	public static List<String> readCarNames() {
		System.out.println(PROMPT_CAR_NAME);
		String input = Console.readLine();
		return parseCarName(input);
	}

	private static List<String> parseCarName(String input) {
		String[] carNames = input.split(CAR_NAME_DELIMITER, -1);
		return Arrays.asList(carNames);
	}

	public static int readTrialCount() {
		System.out.println(PROMPT_TRIAL_COUNT);
		String input = Console.readLine();
		return Integer.parseInt(input);
	}

	public static void printResult(String result){
		System.out.println(MESSAGE_RESULT);
		System.out.println(result);
	}

	public static void printWinner(String winner){
		System.out.println(winner);
	}
}
