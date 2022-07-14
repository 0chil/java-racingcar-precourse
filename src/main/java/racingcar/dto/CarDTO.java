package racingcar.dto;

import racingcar.domain.Car;

public class CarDTO {

	private final String name;
	private final int position;

	private CarDTO(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static CarDTO from(Car car) {
		return new CarDTO(car.getName(), car.getPosition());
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
