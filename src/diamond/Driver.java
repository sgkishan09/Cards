package diamond;

import java.util.Scanner;

public class Driver {	
	
	public static void main(String args[]){
		
		Game game			= new Game();
		HumanPlayer human 	= new HumanPlayer();
		ComputerPlayer comp	= new ComputerPlayer();
		
		game.addPlayer(human);
		game.addPlayer(comp);		
		game.run();
			
		}
	}
}
