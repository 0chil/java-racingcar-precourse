package racingcar.dto;

public class NameDTO {

	private static final int LENGTH_MIN = 1;
	private static final int LENGTH_MAX = 5;
	private static final String LENGTH_EXCEPTION_MESSAGE =
		"이름의 길이는 " + LENGTH_MIN + "자 이상 " + LENGTH_MAX + "자 이하 입니다";

	private final String name;

	public NameDTO(String name) {
		validateLength(name);
		this.name = name;
	}

	private void validateLength(String name) {
		if (name.length() < LENGTH_MIN || name.length() > LENGTH_MAX) {
			throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}
}
