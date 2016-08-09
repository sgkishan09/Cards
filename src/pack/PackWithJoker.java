package pack;
<<<<<<< HEAD

=======
>>>>>>> 8284c7f328e0048bb38238b8634b279ab8293857
import java.util.ArrayList;

import entities.Card;

public class PackWithJoker extends Pack {
	public PackWithJoker() {
<<<<<<< HEAD
		this(2);
	}

	public PackWithJoker(int n) {
=======
>>>>>>> 8284c7f328e0048bb38238b8634b279ab8293857
		cards = new ArrayList<>();
		for (String suit : Card.SUITS)
			for (String face : Card.FACES)
				cards.add(new Card(face, suit));
<<<<<<< HEAD
		while (n-- > 0)
			this.cards.add(Card.JOKER);
=======
		cards.add(Card.JOKER);
		cards.add(Card.JOKER);

>>>>>>> 8284c7f328e0048bb38238b8634b279ab8293857
	}

}
