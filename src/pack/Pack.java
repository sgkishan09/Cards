package pack;

import java.util.List;

import entities.Card;

public abstract class Pack {
	public List<Card> cards;
	public final static Card JOKER = new Card("Joker", "JOKER");
}
