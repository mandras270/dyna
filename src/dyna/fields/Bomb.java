package dyna.fields;

import dyna.game.GameTable;

public class Bomb extends Ground {

	private final int EXPLODE_RANGE = 4;
	private Player owner;
	public Bomb(int x, int y, GameTable gt, Player owner) {
		super(x, y, gt);
		this.owner = owner;
	}

	public void explode() {
		explodeDown();
		explodeUp();
		explodeLeft();
		explodeRight();
		owner.increaseBombNum();
	}

	private void explodeLeft() {
		Ground[][] table = gt.getGameTable();
		for (int i = 0; i > -EXPLODE_RANGE; i--) {
			Ground g = table[x][y + i];
			if (g.destroyable()) {
				table[x][y + i] = new Fire(x, y + i, gt);
				if (g instanceof Player) {
					((Player) g).die();
				}
			} else {
				break;
			}
		}
	}

	private void explodeRight() {
		Ground[][] table = gt.getGameTable();
		for (int i = 0; i < EXPLODE_RANGE; i++) {
			Ground g = table[x][y + i];
			if (g.destroyable()) {
				table[x][y + i] = new Fire(x, y + i, gt);
				if (g instanceof Player) {
					((Player) g).die();
				}
			} else {
				break;
			}
		}
	}

	private void explodeUp() {
		Ground[][] table = gt.getGameTable();
		for (int i = 0; i > -EXPLODE_RANGE; i--) {
			Ground g = table[x + i][y];
			if (g.destroyable()) {
				table[x + i][y] = new Fire(x + i, y, gt);
				if (g instanceof Player) {
					((Player) g).die();
				}
			} else {
				break;
			}
		}
	}
	
	private void explodeDown() {
		Ground[][] table = gt.getGameTable();
		for (int i = 0; i < EXPLODE_RANGE; i++) {
			Ground g = table[x + i][y];
			if (g.destroyable()) {
				table[x + i][y] = new Fire(x + i, y, gt);
				if (g instanceof Player) {
					((Player) g).die();
				}
			} else {
				break;
			}
		}
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
