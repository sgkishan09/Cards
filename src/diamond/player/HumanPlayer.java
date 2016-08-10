package diamond.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Card;

public class HumanPlayer extends Player {
	public HumanPlayer() {
		super();
		setName("Player");
	}

	public HumanPlayer(String name) {
		super();
		setName(name);
		
	}

	@Override
	public Card bid(Card cardOnTop) {
		String suit, face;
		Card toBid;
		System.out.println("Card on Top" + cardOnTop);
		Scanner in = new Scanner(System.in);
		System.out.println(this + "\t" + cards);
		System.out.println("Enter Card:");
		face = in.nextLine().toUpperCase();
		suit = this.cards.get(0).suit;
		toBid = new Card(face, suit);
		this.removeCard(toBid);
		return toBid;
	}

	@Override
	public void feedbackOfCurrentBid(Double score, Card diamond, List<Card> c) {
		this.score += score;
	}

}
