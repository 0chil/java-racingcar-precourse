package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.UserView;

public class GameControl {

	public void start() {
		List<String> carNames = UserView.readCarNames();
		List<Car> carList = carNames.stream().map(Car::new).collect(Collectors.toList());
		Cars cars = new Cars(carList);
		int trialCount = UserView.readTrialCount();
		race(cars, trialCount);

	}

	private void race(Cars cars, int trialCount) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < trialCount; i++) {
			cars.race();
			result.append(cars);
			result.append(System.lineSeparator());
		}
		result.deleteCharAt(result.length() - 1);
		UserView.printResult(result.toString());
		UserView.printWinner(Winners.of(cars).toString());
	}
}
