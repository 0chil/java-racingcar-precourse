package racingcar.car.domain;

import racingcar.car.strategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private static final int MOVE_AMOUNT = 1;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position += MOVE_AMOUNT;
		}
	}

	public CarDTO toDTO() {
		return new CarDTO(name, position);
	}

	@Override
	public String toString() {
		return "Car(name=" + name + ", position=" + position + ")";
	}

	@Override
	public int compareTo(Car another) {
		return this.position - another.position;
	}

	public boolean hasSamePositionWith(Car another) {
		return this.position == another.position;
	}
}
