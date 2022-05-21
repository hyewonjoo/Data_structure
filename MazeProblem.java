package MazaProblem;

public final class MazeProblem {

	// 미로 배열
	private final int[][] mazeArray = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1},};

	// 방문 체크 배열
	private final boolean[][] mazeVisitArray =
			{{false, false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false, false},
					{false, false, false, false, false, false, false, false}};

	private boolean isFinished = false;
	private static final int DEST_X = 7; // 도착 X
	private static final int DEST_Y = 3; // 도착 Y
	private static final int START_X = 0; // 시작 X
	private static final int START_Y = 1; // 시작 Y
	private static final int WALL = 1; // 벽

	public void escape() {
		move(START_X, START_Y);
	}

	private void visit(int x, int y) {
		mazeVisitArray[y][x] = true;
		System.out.printf("(%d,%d) ", x, y);
	}

	private void move(int x, int y) {
		if (isFinished) {
			/**
			 * 길을 찾았으면 더 이상 탐색을 하지 않는다.
			 */
			return;
		} else if (DEST_X == x && DEST_Y == y) {
			// 도착!
			visit(x, y);
			// 미로 찾기 종료 flag
			isFinished = true;
			return;
		} else if (0 > x || 0 > y || x > mazeArray[y].length - 1 || y > mazeArray.length - 1) {
			// 미로를 넘어갈 수 없다.
			return;
		} else if (WALL == mazeArray[y][x]) {
			// 벽을 넘어설 수 없다.
			return;
		} else if (mazeVisitArray[y][x]) {
			// 방문 했던 곳을 다시 이동하지 않는다.
			return;
		}

		// 방문
		visit(x, y);

		move(x + 1, y); // 오른쪽
		move(x, y + 1); // 아래
		move(x - 1, y); // 왼쪽
		move(x, y - 1); // 위
	}


}
