package diamond.player;

import entities.*;
import java.util.*;

public class HumanPlayer extends Player{
	private ArrayList<Card> cards;
	private int points;

	public Card bid() {
		String suit, face;
		Card toBid;
		Scanner in = new Scanner(System.in);
		System.out.println("-----List of cards available-----");
		System.out.println(cards);
		System.out.println("Choose card to bid:");
		System.out.println("Suit:");
		suit = in.nextLine();
		System.out.println("Face:");
		face = in.nextLine();
		toBid = new Card(face, suit);
		this.removeCard(toBid);
		return toBid;
	}

	private void removeCard(Card c) {
		cards.remove(c);
	}

	public void feedbackOfCurrentBid(Double score, Card diamond, Collection c){
		System.out.println("Score: "+ score + "\nDiamond Card: "+ diamond +"\nCards Played: "+ c);
	}

}
