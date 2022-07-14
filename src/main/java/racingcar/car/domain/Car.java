package racingcar.car.domain;

public class Car implements Comparable<Car> {

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		position += 1;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	/**
	 * 학습용 주석
	 * toString()은 출력 로직을 심는 용도보다는 디버깅 용도로 사용하는 것이 좋겠다.
	 * 1. 출력 로직을 심게 되면 아무리 잘 하려고 해도 클래스가 출력과 연관된다.
	 * 2. 그렇게 되면 출력 변경을 위해서 해당 클래스를 바꾸어야 한다.
	 * -> Layer 분리 실패
	 * *
	 * 의문사항
	 * 그렇다면 디버깅 용도로서의 toString()에서 앞, 중간, 뒤의 String들은 상수화 해야 할까?
	 * 안 하는게 더 잘 보이기도 하는 것 같다.
	 * 그렇다면 다시 String.format()을 도입?
	 */

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
