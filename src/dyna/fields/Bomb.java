package dyna.fields;

import dyna.game.GameTable;

public class Bomb extends Ground {

	private final int EXPLODE_RANGE = 4;
	private Player owner;

	public Bomb(int x, int y, GameTable gt, Player owner) {
		super(x, y, gt);
		this.owner = owner;
	}

	/* explode the bomb in every direction */
	public void explode() {
		explodeDown();
		explodeUp();
		explodeLeft();
		explodeRight();
		owner.increaseBombNum();
	}

	/* create fire or explode a new bomb or kill a player */
	private boolean explosionMoving(int i, int j) {
		Ground[][] table = gt.getGameTable();
		if (i >= table.length || y >= table.length || x < 0 || y < 0) {

			Ground g = table[x + i][y + j];
			if (g.destroyable()) {
				table[x + i][y + j] = new Fire(x + i, y + j, gt);
				if (g instanceof Player) {
					((Player) g).die();
				} else if (g instanceof Bomb) {
					((Bomb) g).explode();
				} else if (g instanceof Grass) {
					return false;
				}
				return true;
			}
		}
		return false;

	}

	private void explodeLeft() {

		for (int i = 0; i > -EXPLODE_RANGE; i--) {
			if (explosionMoving(0, i)) {
				break;
			}
		}
	}

	private void explodeRight() {

		for (int i = 0; i < EXPLODE_RANGE; i++) {
			if (explosionMoving(0, i)) {
				break;
			}
		}
	}

	private void explodeUp() {

		for (int i = 0; i > -EXPLODE_RANGE; i--) {
			if (explosionMoving(0, i)) {
				break;
			}
		}
	}

	private void explodeDown() {

		for (int i = 0; i < EXPLODE_RANGE; i++) {
			if (explosionMoving(0, i)) {
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
