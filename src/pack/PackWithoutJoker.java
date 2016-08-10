package pack;
import java.util.ArrayList;

import entities.Card;

public class PackWithoutJoker extends Pack {
	public PackWithoutJoker() {
		cards = new ArrayList<>();
		for (String suit : Card.SUIT_NAMES)
			for (String face : Card.FACE_NAMES)
				cards.add(new Card(face, suit));

	}

}
