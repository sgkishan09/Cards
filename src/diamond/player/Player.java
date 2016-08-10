package diamond.player;

import java.util.ArrayList;
import java.util.List;

import entities.Card;

public abstract class Player {
	String name;
	public List<Card> cards;
	Double score;
	int myPosition;
	int total;

	public void setGameParams(int position, int total) {
		this.myPosition = position;
		this.total = total;
	}

	Player() {
		name = "";
		cards = new ArrayList<>();
		score = 0.0;
	}

	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	public Double getScore() {
		return this.score;
	}

	public void removeCard(Card c) {
		cards.remove(c);
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name + " " + String.format("%.2f", this.score);
	}

	abstract public Card bid(Card cardOnTop);

	abstract public void feedbackOfCurrentBid(Double score, Card card, List<Card> c);

}
