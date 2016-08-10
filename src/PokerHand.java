import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import entities.Card;

public class PokerHand extends Hand {
	static {
	}

	private boolean isRoyalFlush() {
		Card card = this.cards.get(0);
		return isStraightFlush() && this.cards.contains(new Card("K", card.suit));
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

	private boolean isStraight(int valid) {
		List<Card> tempCards = new ArrayList<>();
		tempCards.addAll(this.cards);
		boolean flag = true;
		int count = 0;
		Collections.sort(tempCards, new CardComparatorByValue());
		System.out.println(tempCards);
		for (int i = 0; i < tempCards.size() - 1; i++) {
			int cardFace1 = Card.FACES.indexOf(tempCards.get(i).face);
			int cardFace2 = Card.FACES.indexOf(tempCards.get(i + 1).face);
			int difference = Math.abs(cardFace1 - cardFace2);
			if (difference == 1) {
				count++;
			} else if (cardFace2 == Card.FACES.indexOf("A") && tempCards.get(0).face.equals("2")) {
				tempCards.remove(i + 1);
				System.out.println("------------");
				return new PokerHand(tempCards).isStraight(3);
			} else {
				tempCards.remove(i);
				PokerHand tempHand = new PokerHand(tempCards);
				return tempHand.isStraight(valid);
			}
		}
		System.out.println(count + "\t" + valid);
		return count == valid;
	}

	public boolean isStraight() {
		boolean result = isStraight(4);
		return result;
	}

	private boolean isFlush() {
		int count = (int) cards.stream().filter(p -> p.suit.equals(cards.get(0).suit)).count();
		return count == 5;
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
