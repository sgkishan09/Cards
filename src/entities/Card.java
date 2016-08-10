package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Card implements Comparable {
	public static List<String> FACES;
	public static List<String> SUITS;
	static {
		FACES = new ArrayList<>();
		for (int i = 2; i <= 10; i++)
			FACES.add(Integer.toString(i));
		FACES.addAll(Arrays.asList("JQKA".split("")));
		String[] suits = { "SPADE", "HEART", "CLUB", "DIAMOND" };
		SUITS = Arrays.asList(suits);
	}
	public String face, suit;

	public Card() {
		face = "";
		suit = "";
	}

	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	public String toString() {
		return "[" + face + " " + suit + " " + "]\n";
	}

	public int hashCode() {
		int card = (SUITS.indexOf(suit) * FACES.size()) + FACES.indexOf(face);
		return card;
	}

	public boolean equals(Object arg) {
		Card card = (Card) arg;
		return card.face.equals(face) && card.suit.equals(suit);
	}

	@Override
	public int compareTo(Object arg0) {
		Card c2 = (Card) arg0;
		if (this.hashCode() > c2.hashCode())
			return 1;
		return -1;
	}
}
