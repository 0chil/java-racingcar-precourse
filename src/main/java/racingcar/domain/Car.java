package racingcar.domain;

import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

	private static final int MOVE_WHEN_BIGGER_THAN = 4;
	private static final String CAR_INFIX = " : ";
	private static final String PROGRESS_STRING = "-";

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String EXCEPTION_NAME_LENGTH =
		"이름의 길이는 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하 입니다";

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
		validateNameLength();
	}

	private void validateNameLength() {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				EXCEPTION_NAME_LENGTH);
		}
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
		return name + CAR_INFIX + getProgress();
	}

	@Override
	public int compareTo(Car o) {
		return this.position - o.position;
	}

	public boolean isPositionSame(Car o) {
		return this.position == o.position;
	}
}
