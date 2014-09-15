package dyna.game;

import dyna.fields.Grass;
import dyna.fields.GrayBrick;
import dyna.fields.Ground;
import dyna.fields.Player;

public class GameTable {

	private static final int SIZE = 11;
	private static final int PLAYER_NUMBER = 1;

	Ground[][] gameTable;

	private void init() {

		gameTable = new Ground[SIZE][SIZE];

		/* add grass */
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				gameTable[i][j] = new Grass();
			}
		}

		/* add players */
		for (int i = 0; i < PLAYER_NUMBER; ++i) {
			if (i == 0) {
				gameTable[0][0] = new Player();
			} else if (i == 1) {
				gameTable[SIZE - 1][0] = new Player();
			} else if (i == 2) {
				gameTable[0][SIZE - 1] = new Player();
			} else if (i == 3) {
				gameTable[SIZE - 1][SIZE - 1] = new Player();
			}
		}

		/* add non-breakable bricks */
		for (int i = 1; i < SIZE; i += 2) {
			for (int j = 1; j < SIZE; j += 2) {
				gameTable[i][j] = new GrayBrick();
			}
		}

	}

}
