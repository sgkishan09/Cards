import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import entities.Card;

public class PokerHand extends Hand {
	static {
	}

	private boolean isRoyalFlush() {
		Card card = this.cards.get(0);
		return isStraightFlush() && this.cards.contains(new Card("A", card.suit));
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isNOfAKind(int n) {
		HashMap<String, Integer> count = new HashMap<>();
		for (Card card : cards) {
			if (count.containsKey(card.face))
				count.put(card.face, count.get(card.face) + 1);
			else
				count.put(card.face, 1);
		}
		for (Integer frequency : count.values())
			if (frequency == n)
				return true;
		return false;
	}

	private boolean isStraight() {
		List<Card> tempCards = this.cards;
		Collections.sort(tempCards);
		for (int i = 0; i < tempCards.size() - 1; i++)
			if (Math.abs(tempCards.get(i).hashCode() - tempCards.get(i + 1).hashCode()) != 1)
				return false;
		return true;
	}
<<<<<<< HEAD
	private boolean isFlush() {
		int count = (int) cards.stream().filter(p -> p.suit.equals(cards.get(0).suit)).count();
		return count == 5;

=======

	private boolean isFlush() {
		int count = (int) cards.stream().filter(p -> p.suit.equals(cards.get(0).suit)).count();
		return count == 5;
>>>>>>> 8284c7f328e0048bb38238b8634b279ab8293857
	}

	private boolean isFullHouse() {
		return isNOfAKind(3) && isNOfAKind(2);
	}

	private boolean isFourOfAKind() {
		return isNOfAKind(4);
	}

	private boolean isTwoPair() {
		int pair = 0;
		HashMap<String, Integer> count = new HashMap<>();
		for (Card card : cards) {
			if (count.containsKey(card.face))
				count.put(card.face, count.get(card.face) + 1);
			else
				count.put(card.face, 1);
		}
		for (Integer frequency : count.values())
			if (frequency == 2)
				pair++;
		return pair == 2;

	}

	private boolean isOnePair() {
		return isNOfAKind(2);
	}

	public PokerHand(List<Card> cards) {
		super(cards);
	}

	public PokerHand(int size) {
		super(size);
	}

	public String assess(Hand table) {
		PokerHand temp = new PokerHand(table.cards);
		temp.cards.addAll(this.cards);
		return temp.getScore();
	}

	public String toString() {
		return this.cards.toString();
	}

	public String getScore() {
		String out = "";
		if (isRoyalFlush())
			out = "Royal Flush";
		else if (isStraightFlush())
			out = "Straight Flush";
		else if (isFourOfAKind())
			out = "Four of a Kind";
		else if (isFullHouse())
			out = "Full House";
		else if (isFlush())
			out = "Flush";
		else if (isStraight())
			out = "Straight";
		else if (isTwoPair())
			out = "Two Pair";
		else if (isOnePair())
			out = "One Pair";
		else
			out = "High Card";
		return out;
	}
}
