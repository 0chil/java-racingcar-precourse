package racingcar;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControl {

	public void start() {
		Cars cars = getCars();
		int trialCount = readTrialCount();
		race(cars, trialCount);
	}

	private void race(Cars cars, int trialCount) {
		String result = cars.race(trialCount);
		OutputView.printResult(result);
		OutputView.printWinner(Winners.of(cars).toString());
	}

	private Cars getCars() {
		try {
			List<String> carNames = InputView.readCarNames();
			return Cars.ofNames(carNames);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getCars();
		}
	}

	private int readTrialCount() {
		try {
			return InputView.readTrialCount();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return readTrialCount();
		}
	}
}
