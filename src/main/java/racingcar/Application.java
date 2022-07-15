package racingcar;

import racingcar.car.strategy.RandomMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		GameControl gameControl = new GameControl(new InputView(), new OutputView(), new RandomMovableStrategy());
		gameControl.start();
	}
}
