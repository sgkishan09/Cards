package pack;

import java.util.ArrayList;

import entities.Card;

public class PackWithJoker extends Pack {
	public PackWithJoker() {
		this(2);
	}

	public PackWithJoker(int n) {
		cards = new ArrayList<>();
		for (String suit : Card.SUITS)
			for (String face : Card.FACES)
				cards.add(new Card(face, suit));
		while (n-- > 0)
			this.cards.add(Card.JOKER);
	}

}
