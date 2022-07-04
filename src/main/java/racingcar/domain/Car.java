package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private static final int MOVE_CRITERIA = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean isMovable() {
		int pickNumber = Randoms.pickNumberInRange(0, 9);
		return pickNumber >= MOVE_CRITERIA;
	}

	public void move() {
		if (isMovable())
			position += 1;
	}
}
