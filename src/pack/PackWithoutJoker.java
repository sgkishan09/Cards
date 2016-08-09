package pack;
import java.util.ArrayList;

import entities.Card;

public class PackWithoutJoker extends Pack {
	public PackWithoutJoker() {
		cards = new ArrayList<>();
		for (String suit : Card.SUITS)
			for (String face : Card.FACES)
				cards.add(new Card(face, suit));

	}

}
