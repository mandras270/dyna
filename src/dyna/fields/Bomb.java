package dyna.fields;

import dyna.game.GameTable;

public class Bomb extends Ground {

	public Bomb(int x, int y, GameTable gt) {
		super(x, y, gt);
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
