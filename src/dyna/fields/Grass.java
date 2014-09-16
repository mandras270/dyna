package dyna.fields;

import dyna.game.GameTable;

public class Grass extends Ground {

	public Grass(int x, int y, GameTable gt) {
		super(x, y, gt);
	}

	@Override
	public boolean penetrable() {
		return true;
	}

}
