package diamond.player;

import java.util.List;

import entities.Card;

public abstract class Player {
	String name;
	String suit;
	public List<Card> cards;
	private Double score;

	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	public Double getScore() {
		return this.score;
	}

	public void removeCard(Card c) {
		cards.remove(c);
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	abstract public Card bid(Card cardOnTop);

	abstract public void feedbackOfCurrentBid(Double score, Card card, List<Card> c);

}
