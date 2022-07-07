package racingcar;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControl {

	private final InputView inputView;
	private final OutputView outputView;

	public GameControl(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void start() {
		Cars cars = getCars();
		int trialCount = readTrialCount();
		race(cars, trialCount);
	}

	private void race(Cars cars, int trialCount) {
		String result = cars.race(trialCount);
		outputView.printResult(result);
		outputView.printWinner(Winners.of(cars).toString());
	}

	private Cars getCars() {
		try {
			List<String> carNames = inputView.readCarNames();
			return Cars.ofNames(carNames);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return getCars();
		}
	}

	private int readTrialCount() {
		try {
			return inputView.readTrialCount();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return readTrialCount();
		}
	}
}
