package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		GameControl gameControl = new GameControl(new InputView(), new OutputView());
		gameControl.start();
	}
}
