package dyna.fields;

import dyna.game.GameTable;

public class Player extends Ground {

	private static final int MAX_BOMB = 3;

	private String name;
	private int score;
	private boolean isAlive;
	private int bombLeft;

	public Player(String name, int score, int x, int y, GameTable gt) {
		super(x, y, gt);
		this.name = name;
		this.score = score;
		this.isAlive = false;
		bombLeft = MAX_BOMB;

	}

	public void setBomb() {
		if (bombLeft > 0) {
			new Bomb(x, y, gt, this);
			bombLeft--;
		}
	}

	public void increaseBombNum() {
		bombLeft++;
	}

	public void die() {
		isAlive = false;
	}

	public void resurrect(){
		isAlive = true;
	}
	public boolean isAlive() {
		return isAlive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
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

	@Override
	public boolean destroyable() {
		return true;
	}

}
