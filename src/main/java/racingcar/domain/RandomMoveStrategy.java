package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MOVABLE_THRESHOLD = 4;

	@Override
	public boolean isMovable() {
		int pickNumber = Randoms.pickNumberInRange(0, 9);
		return pickNumber >= MOVABLE_THRESHOLD;
	}
}
