package racingcar.dto;

public class TrialCountDTO {

	private static final int TRIAL_COUNT_MIN = 1;
	private static final String EXCEPTION_TRIAL_COUNT =
		"시도 횟수는 " + TRIAL_COUNT_MIN + " 이상이어야 합니다";

	private final int trialCount;

	public TrialCountDTO(int trialCount) {
		validateTrialCount(trialCount);
		this.trialCount = trialCount;
	}

	private void validateTrialCount(int trialCount) {
		if (trialCount < TRIAL_COUNT_MIN) {
			throw new IllegalArgumentException(EXCEPTION_TRIAL_COUNT);
		}
	}

	public int getTrialCount() {
		return trialCount;
	}
}
