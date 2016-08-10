package comparators;
import java.util.Comparator;

import entities.Card;

public class CardComparatorByValue implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		return (Card.FACE_NAMES.indexOf(o1.face) - Card.FACE_NAMES.indexOf(o2.face));
	}
}
