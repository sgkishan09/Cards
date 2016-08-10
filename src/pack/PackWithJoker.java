package pack;

import java.util.ArrayList;

import entities.Card;

public class PackWithJoker extends Pack {
	public PackWithJoker() {
		this(2);
	}

	public PackWithJoker(int size) {
		cards = new ArrayList<>();
		for (String suit : Card.SUITS)
			for (String face : Card.FACES)
				cards.add(new Card(face, suit));
		while (size-- > 0)
			this.cards.add(Pack.JOKER);
	}

}
