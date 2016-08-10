import java.util.Comparator;

import entities.Card;

public class CardComparatorByValue implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if (Card.FACES.indexOf(o1.face) > Card.FACES.indexOf(o2.face))
			return 1;
		return -1;
	}

}
