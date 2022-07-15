package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.NameDTO;
import racingcar.dto.TrialCountDTO;

public class InputView {

	private static final String CAR_NAME_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_NAME_DELIMITER = ",";
	private static final int TRAILING_BLANK_DISCARDING_OPTION = -1;

	private static final String TRIAL_COUNT_PROMPT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String TRIAL_COUNT_NUMERIC_EXCEPTION_MESSAGE = "시도 횟수는 숫자여야 합니다";
	private static final String NUMERIC_REGEX = "^\\d*$";

	public List<NameDTO> readCarNames() {
		System.out.println(CAR_NAME_PROMPT_MESSAGE);
		String input = Console.readLine();
		List<String> names = parseCarNames(input);
		return names.stream()
			.map(NameDTO::new)
			.collect(Collectors.toList());
	}

	private List<String> parseCarNames(String input) {
		String[] carNames = input.split(CAR_NAME_DELIMITER, TRAILING_BLANK_DISCARDING_OPTION);
		return Arrays.asList(carNames);
	}

	public TrialCountDTO readTrialCount() {
		System.out.println(TRIAL_COUNT_PROMPT_MESSAGE);
		String input = Console.readLine();
		validateNumeric(input);
		int trialCount = Integer.parseInt(input);
		return new TrialCountDTO(trialCount);
	}

	private void validateNumeric(String input) {
		if (!input.matches(NUMERIC_REGEX)) {
			throw new IllegalArgumentException(TRIAL_COUNT_NUMERIC_EXCEPTION_MESSAGE);
		}
	}
}
