package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.strategy.MoveStrategy;
import racingcar.car.strategy.RandomMoveStrategy;
import racingcar.car.domain.CarDTO;
import racingcar.dto.NameDTO;
import racingcar.dto.TrialCountDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControl {

	private final InputView inputView;
	private final OutputView outputView;
	private final MoveStrategy moveStrategy;

	public GameControl(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.moveStrategy = moveStrategy;
	}

	public void start() {
		Cars cars = getCars();
		int trialCount = readTrialCount();
		race(cars, trialCount);
	}

	private void race(Cars cars, int trialCount) {
		outputView.printResultMessage();
		for (int i = 0; i < trialCount; i++) {
			cars.race(moveStrategy);
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
			return new Cars(cars);
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
