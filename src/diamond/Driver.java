package diamond;

import java.util.ArrayList;
import java.util.List;

import diamond.player.DuplicateComputerPlayer;
import diamond.player.HumanPlayer;
import diamond.player.Player;

public class Driver {

	public static void main(String args[]) {
		List<Player> players = new ArrayList<>();
		try {
			players.add(new HumanPlayer("A"));
			players.add(new DuplicateComputerPlayer("B"));
			DiamondGame game = new DiamondGame(players.size(), players);
			System.out.println("Winner : " + game.play());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
