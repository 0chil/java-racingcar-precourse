package racingcar.dto;

public class NameDTO {

	/**
	 * 학습용 주석
	 * Dto를 사용한 이유
	 * 1. 이름 검증만 하는 클래스를 만들어 관심사를 분리하고 싶다.
	 * 2. 그렇다고 도메인을 View에서 사용하면 Layer 분리가 무용지물이 된다.
	 * 3. 검증은 빨리 할수록 후에 검증을 위한 로직이 적어지므로 좋다.
	 * (후에는 검증이 필요없다는 뜻은 아니다!)
	 * 4. 입/출력에 대한 검증을 입출력 한참 후에 하는 건 로직이 섞일 가능성이 높다.
	 * 5. 검증이 추가로 필요한 경우 도메인(Entity)에서의 검증이 추가로 있으면 되겠다.
	 */

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String EXCEPTION_NAME_LENGTH =
		"이름의 길이는 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하 입니다";

	private final String string;

	public NameDTO(String string) {
		validateLength(string);
		this.string = string;
	}

	private void validateLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(EXCEPTION_NAME_LENGTH);
		}
	}

	public String getName() {
		return string;
	}
}
