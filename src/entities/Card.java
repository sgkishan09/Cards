package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Card {
	public static List<String> FACE_NAMES;
	public static List<String> SUIT_NAMES;
	static {
		FACE_NAMES = new ArrayList<>();
		for (int i = 2; i <= 10; i++)
			FACE_NAMES.add(Integer.toString(i));
		FACE_NAMES.addAll(Arrays.asList("JQKA".split("")));
		String[] suits = { "SPADE", "HEART", "CLUB", "DIAMOND" };
		SUIT_NAMES = Arrays.asList(suits);
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
		return "[" + face + " " + suit + " " + "]";
	}

	public int hashCode() {
		int card = (SUIT_NAMES.indexOf(suit) * FACE_NAMES.size()) + FACE_NAMES.indexOf(face);
		return card;
	}

	public boolean equals(Object arg) {
		Card card = (Card) arg;
		return card.face.equals(face) && card.suit.equals(suit);
	}

}
