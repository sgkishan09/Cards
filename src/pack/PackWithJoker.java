package pack;
import java.util.ArrayList;

import entities.Card;

public class PackWithJoker extends Pack {
	public PackWithJoker() {
		cards = new ArrayList<>();
		for (String suit : Card.SUITS)
			for (String face : Card.FACES)
				cards.add(new Card(face, suit));
		cards.add(Card.JOKER);
		cards.add(Card.JOKER);

	}

}
