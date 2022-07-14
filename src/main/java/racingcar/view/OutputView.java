package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.domain.CarDTO;

public class OutputView {

	private static final String MESSAGE_RESULT = "실행 결과";
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String WINNER_PREFIX = "최종 우승자 : ";
	private static final String CAR_INFIX = " : ";
	private static final String NAME_DELIMITER = ", ";
	private static final String PROGRESS_INDICATOR = "-";


	public void printResultMessage() {
		System.out.println(MESSAGE_RESULT);
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
		String winnerNames = getWinnerNames(winners);
		System.out.println(WINNER_PREFIX + winnerNames);
	}

	private String getWinnerNames(List<CarDTO> winners) {
		return winners.stream()
			.map(CarDTO::getName)
			.collect(Collectors.joining(NAME_DELIMITER));
	}

	public void printError(String message) {
		System.err.println(ERROR_PREFIX + message);
	}
}
