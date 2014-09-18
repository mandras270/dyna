package dyna.fields;

import dyna.game.GameTable;

public class GrayBrick extends Brick{

	public GrayBrick(int x, int y, GameTable gt) {
		super(x, y, gt);
	}

	@Override
	public boolean destroyable() {
		return false;
	}
}
