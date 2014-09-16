package dyna.game;

import java.util.Random;

import dyna.fields.Brick;
import dyna.fields.Grass;
import dyna.fields.GrayBrick;
import dyna.fields.Ground;
import dyna.fields.Player;
import dyna.fields.RedBrick;

public class GameTable {

	private static final int SIZE = 11;
	private static final int PLAYER_NUMBER = 1;
	private static final int numOfRedBrick = (int) (SIZE * SIZE * 0.20);
	private static Ground[][] gameTable;
	private static Random rnd;

	public GameTable() {
		rnd = new Random();
		init();

	}

	private void init() {

		gameTable = new Ground[SIZE][SIZE];
		/* add grass */
		setGrass();
		/* add players */
		setPlayers();
		/* add non-breakable bricks */
		setNonBreakableBricks();
		/* add breakable brick */
		setBreakableBricks();

	}

	private void setGrass() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				gameTable[i][j] = new Grass(i,j,this);
			}
		}
	}

	private void setPlayers() {
		for (int i = 0; i < PLAYER_NUMBER; ++i) {
			if (i == 0) {
				gameTable[0][0] = new Player("Blue", 0, 0, 0,this);
			} else if (i == 1) {
				gameTable[SIZE - 1][0] = new Player("Red", 0, SIZE - 1, 0,this);
			} else if (i == 2) {
				gameTable[0][SIZE - 1] = new Player("Green", 0, 0, SIZE - 1,this);
			} else if (i == 3) {
				gameTable[SIZE - 1][SIZE - 1] = new Player("Black", 0,
						SIZE - 1, SIZE - 1,this);
			}
		}
	}

	private void setNonBreakableBricks() {
		for (int i = 1; i < SIZE; i += 2) {
			for (int j = 1; j < SIZE; j += 2) {
				gameTable[i][j] = new GrayBrick(i,j,this);
			}
		}

	}

	private void setBreakableBricks() {
		for (int i = 0; i < numOfRedBrick; i++) {
			int x;
			int y;
			do {
				x = rnd.nextInt(SIZE);
				y = rnd.nextInt(SIZE);
			} while (canPlaceBrick(x, y));
			gameTable[x][y] = new RedBrick(x,y,this);
		}
	}

	private boolean canPlaceBrick(int x, int y) {
		if (((x == 1 || x == SIZE - 2) && (y == 0 || y == SIZE - 1))
				|| ((x == 0 || x == SIZE - 1) && (y == 0 || y == 1
						|| y == SIZE - 1 || y == SIZE - 2))) {
			return false;
		}
		if (gameTable[x][y] instanceof Brick) {
			return false;
		}
		return true;
	}

	public Ground[][] getGameTable() {
		return gameTable;
	}

	/* when a player move */
	public void move(int fromX, int fromY, int toX, int toY) {

		gameTable[toX][toY] = gameTable[fromX][fromY];
		gameTable[fromX][fromY] = new Grass(fromX,fromY,this);

	}

	/* when a destroyable object explode */
	public void explode(int x, int y) {
		gameTable[x][y] = new Grass(x,y,this);

	}

}
