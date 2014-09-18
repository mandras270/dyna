package dyna.fields;

import dyna.game.GameTable;

public class Brick extends Ground{

	public Brick(int x, int y, GameTable gt) {
		super(x, y, gt);
	}

	@Override
	public boolean penetrable() {
		return false;
	}

	@Override
	public boolean destroyable() {
		return false;
	}

}
