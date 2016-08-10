package diamond.player;

import java.util.List;

import entities.Card;

public class DuplicateComputerPlayer extends Player {
	public DuplicateComputerPlayer(String name) {
		super();
		setName(name);
	}

	@Override
	public Card bid(Card cardOnTop) {
		String suit = this.cards.get(0).suit;
		Card bid = new Card(cardOnTop.face, suit);
		this.removeCard(bid);
		return bid;
	}

	@Override
	public void feedbackOfCurrentBid(Double score, Card card, List<Card> c) {
		this.score += score;
	}

}
