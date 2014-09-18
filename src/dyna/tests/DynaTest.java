package dyna.tests;

import org.junit.Test;

import dyna.fields.Grass;
import dyna.fields.GrayBrick;
import dyna.fields.Ground;
import dyna.fields.Player;
import dyna.fields.RedBrick;
import dyna.game.GameTable;

public class DynaTest {

	GameTable gt = new GameTable();

	@Test
	public void testGroundsBrickGenerate() {
		Ground[][] table = gt.getGameTable();
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++)
				if (table[i][j] instanceof Grass) {
					System.out.print(" g");
				} else if (table[i][j] instanceof RedBrick) {
					System.out.print(" r");
				} else if (table[i][j] instanceof GrayBrick) {
					System.out.print(" h");
					count++;
				} else if (table[i][j] instanceof Player) {
					System.out.print(" p");
				}

			System.out.println();
			
		}
		System.out.println(count++);
	}
}