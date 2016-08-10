package diamond.player;

import java.util.List;
import java.util.Scanner;

import entities.Card;

public class HumanPlayer extends Player {
	@Override
	public Card bid(Card cardOnTop) {
		String suit, face;
		Card toBid;
		System.out.println("Card on Top" + cardOnTop);
		Scanner in = new Scanner(System.in);
		System.out.println("-----List of cards available-----");
		System.out.println(cards);
		System.out.println("Choose card to bid:");
		System.out.println("Suit:");
		suit = in.nextLine().toUpperCase();
		System.out.println("Face:");
		face = in.nextLine().toUpperCase();
		toBid = new Card(face, suit);
		this.removeCard(toBid);
		return toBid;
	}

	@Override
	public void feedbackOfCurrentBid(Double score, Card diamond, List<Card> c) {
		System.out.println("Score: " + score + "\nDiamond Card: " + diamond + "\nCards Played: " + c);
	}

}
