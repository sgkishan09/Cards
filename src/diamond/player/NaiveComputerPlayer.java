package diamond.player;

import java.util.Collections;
import java.util.List;

import entities.Card;

public class NaiveComputerPlayer extends Player {

	public NaiveComputerPlayer(String name) {
		super();
		setName(name);
	}

	@Override
	public Card bid(Card cardOnTop) {
		Collections.shuffle(this.cards);
		Card card = this.cards.get(0);
		this.removeCard(card);
		return card;
	}

	@Override
	public void feedbackOfCurrentBid(Double score, Card diamond, List<Card> c) {
		this.score += score;
	}
}
