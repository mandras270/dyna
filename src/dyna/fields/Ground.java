package dyna.fields;

import dyna.game.GameTable;

public abstract class Ground {
	protected int x;
	protected int y;
	protected GameTable gt;
	public Ground(int x, int y, GameTable gt){
		this.x = x;
		this.y = y;
		this.gt = gt;
	}
	
	
	public abstract boolean penetrable();
}
