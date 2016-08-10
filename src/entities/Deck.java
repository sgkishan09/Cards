package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparators.CardComparatorBySuit;
import pack.Pack;
import pack.PackWithoutJoker;

public class Deck {
	public List<Card> cards;

	public Deck() {
		Pack pack = new PackWithoutJoker();
		cards.addAll(pack.cards);
	}

	public Deck(int count, Class packType) throws Exception {
		cards = new ArrayList<>();
		this.addPackToDeck(count, packType);
		this.shuffle();
	}

	public void addPackToDeck(int count, Class<? extends Pack> packType) throws Exception {
		for (int i = 0; i < count; i++) {
			Pack packInstance = (Pack) packType.getConstructor(null).newInstance();
			cards.addAll(packInstance.cards);
		}

	}

	public void shuffle() {
		int times = (int) (Math.random() * 10) + 1;
		while (times-- > 0)
			Collections.shuffle(cards);
	}

	public void remove(Card card) {
		cards.remove(card);
	}

	public boolean isEmpty() {
		return this.cards.isEmpty();
	}

	public void sort() {
		Collections.sort(this.cards, new CardComparatorBySuit());
	}

	public String toString() {
		return this.cards.toString();
	}

	public List<Card> pick(int n) {
		List<Card> cards = new ArrayList<Card>();
		while (n-- > 0)
			cards.add(draw());
		return cards;
	}

	public Card draw() {
		Card card = null;
		if (!isEmpty()) {
			card = cards.get(0);
			cards.remove(0);
		}
		return card;
	}

}
