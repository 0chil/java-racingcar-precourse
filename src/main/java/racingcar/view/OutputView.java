package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.domain.CarDTO;

public class OutputView {

	private static final String RESULT_START_MESSAGE = "실행 결과";
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String WINNER_PREFIX = "최종 우승자 : ";
	private static final String CAR_INFIX = " : ";
	private static final String NAME_DELIMITER = ", ";
	private static final String PROGRESS_INDICATOR = "-";

	public void printResultStart() {
		System.out.println(RESULT_START_MESSAGE);
	}

	public void printCars(List<CarDTO> carDTOs) {
		for (CarDTO carDTO : carDTOs)
			printCar(carDTO);
		System.out.print(System.lineSeparator());
	}

	private void printCar(CarDTO carDTO) {
		String name = carDTO.getName();
		String progress = getProgress(carDTO.getPosition());
		System.out.println(name + CAR_INFIX + progress);
	}

	private String getProgress(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(PROGRESS_INDICATOR);
		}
		return stringBuilder.toString();
	}

	public void printWinners(List<CarDTO> winners) {
		String winnerNames = joinCarNames(winners);
		System.out.println(WINNER_PREFIX + winnerNames);
	}

	private String joinCarNames(List<CarDTO> carDTOs) {
		return carDTOs.stream()
			.map(CarDTO::getName)
			.collect(Collectors.joining(NAME_DELIMITER));
	}

	public void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
