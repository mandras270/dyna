package dyna.fields;

import dyna.game.GameTable;

public class Fire extends Ground {

	public Fire(int x, int y, GameTable gt) {
		super(x, y, gt);
		
	}
	/* the fire is extinguished replace with grass*/ 
	public void extinguish(){
		Ground[][] table = gt.getGameTable();
		table[x][y] = new Grass(x, x, gt);
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
