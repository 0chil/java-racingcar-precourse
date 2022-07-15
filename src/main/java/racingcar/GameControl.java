package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.domain.Car;
import racingcar.car.domain.CarDTO;
import racingcar.car.domain.Cars;
import racingcar.car.strategy.MovableStrategy;
import racingcar.dto.NameDTO;
import racingcar.dto.TrialCountDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControl {

	private final InputView inputView;
	private final OutputView outputView;
	private final MovableStrategy movableStrategy;

	public GameControl(InputView inputView, OutputView outputView, MovableStrategy movableStrategy) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.movableStrategy = movableStrategy;
	}

	public void start() {
		Cars cars = getCars();
		int trialCount = readTrialCount();
		race(cars, trialCount);
		List<CarDTO> winners = cars.findWinners();
		outputView.printWinners(winners);
	}

	private void race(Cars cars, int trialCount) {
		outputView.printResultStart();
		for (int i = 0; i < trialCount; i++) {
			cars.race(movableStrategy);
			List<CarDTO> carDTOs = cars.toDTOs();
			outputView.printCars(carDTOs);
		}
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
