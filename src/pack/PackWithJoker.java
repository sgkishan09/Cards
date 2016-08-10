package pack;

import java.util.ArrayList;

import entities.Card;

public class PackWithJoker extends Pack {
	public final static Card JOKER = new Card("Joker", "JOKER");

	public PackWithJoker() {
		this(2);
	}

	public PackWithJoker(int size) {
		cards = new ArrayList<>();
		for (String suit : Card.SUIT_NAMES)
			for (String face : Card.FACE_NAMES)
				cards.add(new Card(face, suit));
		while (size-- > 0)
			this.cards.add(PackWithJoker.JOKER);
	}

}
