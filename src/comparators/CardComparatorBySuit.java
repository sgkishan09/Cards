package comparators;
import java.util.Comparator;

import entities.Card;

public class CardComparatorBySuit implements Comparator<Card> {

	@Override
	public int compare(Card c1, Card c2) {
		if (c1.hashCode() > c2.hashCode())
			return 1;
		return -1;
	}

}
