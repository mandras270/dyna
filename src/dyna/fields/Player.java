package dyna.fields;

import dyna.game.GameTable;

public class Player extends Ground {

	private String name;
	private int score;

	public Player(String name, int score, int x, int y, GameTable gt) {
		super(x, y, gt);
		this.name = name;
		this.score = score;

	}

	public void moveDown() {
		int toX = x - 1;
		int toY = y;
		if (canMoveThere(toX, toY)) {
			gt.move(x, y, toX, toY);
		}
	}

	public void moveUp() {
		int toX = x + 1;
		int toY = y;
		if (canMoveThere(toX, toY)) {
			gt.move(x, y, toX, toY);
		}
	}

	public void moveLeft() {
		int toX = x;
		int toY = y - 1;
		if (canMoveThere(toX, toY)) {
			gt.move(x, y, toX, toY);
		}
	}

	public void moveRight() {
		int toX = x;
		int toY = y + 1;
		if (canMoveThere(toX, toY)) {
			gt.move(x, y, toX, toY);
		}
	}

	private boolean canMoveThere(int toX, int toY) {
		Ground[][] gameTable = gt.getGameTable();
		if (!gameTable[toX][toY].penetrable() || toX >= gameTable.length
				|| toY >= gameTable.length || toX < 0 || toY < 0) {
			return false;
		}
		return true;

	}

	@Override
	public boolean penetrable() {
		return false;
	}

}
