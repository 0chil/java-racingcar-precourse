package racingcar.car.domain;

public class CarDTO {

	private final String name;
	private final int position;
	/*
	학습용 주석
	DTO에서 반환하는 String, position은 immutable 할까?
	0.0. String 자체는 immutable 한가?
	String -> Reference Type
	String s = new String();
	변수 s에 재할당없이 가리키는 객체를 변경할 수 있는지 여부를 묻는 것이다.
	String에 변경을 일으키는 method가 없다.
	그러므로 immutable 하다.

	0.1. 그렇다면 int는 어떤가?
	int -> Primitive Type
	int i = 1;
	변수 i에 재할당 없이 1 자체를 수정할 수 있나? X
	그러므로 immutable 하다.

	1. 객체 내부 관점
	String -> String 자체가 immutable 하므로, final 을 통해 재할당을 막은 name은 immutable 할 것이다.
	int -> position = 1; 과 같은 문장은 재할당을 일으키므로 final로 막힌다.
	따라서 객체 내부에서 불변.

	2. 객체에서 꺼낸 값의 관점
	String -> Reference Type, int -> Primitive Type.
	1. 참조 타입
	참조 타입은 메모리 주소를 참조한다.
	즉, `carDTO.getName()`와 원래의 `String name`은 여전히 같은 주소를 가리키고 있다.
	String 자체가 immutable 하므로, 재할당 없이 해당 주소의 값을 변경할 수 없다.
	2. 원시 타입
	원시 타입은 그 자체로

	 */

	public CarDTO(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
