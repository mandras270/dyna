package dyna.fields;

import dyna.game.GameTable;

public class Brick extends Ground implements Impenetrable {

	public Brick(int x, int y, GameTable gt) {
		super(x, y, gt);
	}

	@Override
	public boolean penetrable() {
		return false;
	}

}
