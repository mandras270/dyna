package dyna.fields;

import dyna.game.GameTable;

public class RedBrick extends Brick {

	public RedBrick(int x, int y, GameTable gt) {
		super(x, y, gt);
	}
	
	@Override
	public boolean destroyable() {
		return true;
	}
}
