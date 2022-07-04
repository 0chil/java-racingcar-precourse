package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {

	private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

	public static String readCarName() {
		System.out.println(PROMPT_CAR_NAME);
		String input = Console.readLine();
		return input;
	}

	public static Integer readTrialCount() {
		System.out.println(PROMPT_TRIAL_COUNT);
		String input = Console.readLine();
		return Integer.parseInt(input);
	}
}
