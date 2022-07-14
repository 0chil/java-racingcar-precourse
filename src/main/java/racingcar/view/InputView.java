package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.NameDTO;
import racingcar.dto.TrialCountDTO;

public class InputView {

	// TODO@0chil: 상수명 수정
	private static final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

	private static final String CAR_NAME_DELIMITER = ",";
	private static final int DISCARD_TRAILING_BLANK = -1;

	private static final String REGEX_NUMERIC = "^\\d*$";
	private static final String EXCEPTION_TRIAL_COUNT = "시도 횟수는 숫자여야 합니다";

	public List<NameDTO> readCarNames() {
		System.out.println(PROMPT_CAR_NAME);
		String input = Console.readLine();
		List<String> names = parseCarNames(input);
		return names.stream()
			.map(NameDTO::new)
			.collect(Collectors.toList());
	}

	private List<String> parseCarNames(String input) {
		String[] carNames = input.split(CAR_NAME_DELIMITER, DISCARD_TRAILING_BLANK);
		return Arrays.asList(carNames);
	}

	public TrialCountDTO readTrialCount() {
		System.out.println(PROMPT_TRIAL_COUNT);
		String input = Console.readLine();
		validateNumeric(input);
		int trialCount = Integer.parseInt(input);
		return new TrialCountDTO(trialCount);
	}

	private void validateNumeric(String input) {
		if (!input.matches(REGEX_NUMERIC)) {
			throw new IllegalArgumentException(EXCEPTION_TRIAL_COUNT);
		}
	}
}
