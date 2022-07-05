package racingcar.domain;

import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

	private static final int MOVE_WHEN_BIGGER_THAN = 4;
	private static final String FORMAT_CAR = "%s : %s";
	private static final String PROGRESS_STRING = "-";
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean isMovable() {
		int pickNumber = Randoms.pickNumberInRange(0, 9);
		return pickNumber >= MOVE_WHEN_BIGGER_THAN;
	}

	public void move() {
		if (isMovable())
			position += 1;
	}

	private String getProgress() {
		return String.join("", Collections.nCopies(position, PROGRESS_STRING));
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format(FORMAT_CAR, name, getProgress());
	}

	@Override
	public int compareTo(Car o) {
		return this.position - o.position;
	}

	public boolean isPositionSame(Car o) {
		return this.position == o.position;
	}
}
