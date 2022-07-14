package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomMoveStrategy;
import racingcar.dto.CarDTO;
import racingcar.dto.NameDTO;
import racingcar.dto.TrialCountDTO;
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
		outputView.printResultMessage();
		for (int i = 0; i < trialCount; i++) {
			cars.race();
			List<CarDTO> carDTOs = cars.getCars();
			outputView.printCars(carDTOs);
		}
		List<CarDTO> winners = cars.findWinners();
		outputView.printWinners(winners);
	}

	private Cars getCars() {
		try {
			List<NameDTO> nameDTOs = inputView.readCarNames();
			List<Car> cars = nameDTOs.stream()
				.map(NameDTO::getName)
				.map(Car::new)
				.collect(Collectors.toList());
			return new Cars(cars, new RandomMoveStrategy());
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return getCars();
		}
	}

	private int readTrialCount() {
		try {
			TrialCountDTO trialCountDTO = inputView.readTrialCount();
			return trialCountDTO.getTrialCount();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return readTrialCount();
		}
	}
}
