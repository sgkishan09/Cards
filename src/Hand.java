import java.util.ArrayList;
import java.util.List;

import entities.Card;

public abstract class Hand {
	List<Card> cards;

	public Hand() {
		cards = null;
	}

	public Hand(List<Card> cards) {
		this.cards = cards;
	}

	public Hand(int size) {
		cards = new ArrayList<>(size);
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public Card dropCard(Card card) {
		cards.remove(card);
		return card;
	}

}
