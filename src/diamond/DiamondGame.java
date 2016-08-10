package diamond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import comparators.CardComparatorByValue;
import diamond.player.Player;
import entities.Card;
import entities.Deck;
import pack.PackWithoutJoker;

public class DiamondGame {
	List<Player> players;
	int size;
	boolean over;
	Deck deck;
	List<Card> cards;

	public DiamondGame(int size, List<Player> players) throws Exception {
		this.size = size;
		this.players = players;
		deck = new Deck(1, PackWithoutJoker.class);
		cards = deck.pickSuit("DIAMOND");
		System.out.println(cards);
		Collections.shuffle(cards);
		for (Player player : players) {
			player.addCards(deck.pickNextCardsInSuit());
			System.out.println(player);
		}
	}

	public Card nextCardOnTop() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}

	private Card maxBid(List<Card> bids) {
		List<Card> sortBids = new ArrayList<>();
		sortBids.addAll(bids);
		Collections.sort(sortBids, new CardComparatorByValue());
		Card maxBid = sortBids.get(sortBids.size() - 1);
		return maxBid;
	}

	public void nextTurn() {
		List<Card> bids = new ArrayList<Card>();
		Card cardOnTop = this.cards.get(0);
		this.cards.remove(cardOnTop);
		for (Player player : players)
			bids.add(player.bid(cardOnTop));
		System.out.println(cardOnTop + "\t" + bids);
		Card winningBid = maxBid(bids);
		int count = (int) bids.stream().filter(p -> p.getFaceValue().equals(winningBid.getFaceValue())).count();
		double winScore = (cardOnTop.getFaceValue()) / count;
		for (int i = 0; i < bids.size(); i++) {
			if (winningBid.getFaceValue().equals(bids.get(i).getFaceValue()))
				players.get(i).feedbackOfCurrentBid(winScore, cardOnTop, bids);
			else
				players.get(i).feedbackOfCurrentBid(0.0, cardOnTop, bids);
		}
		System.out.println(players);
	}

	public Double getMaxScore() {
		double maxScore = Double.MIN_VALUE;
		for (Player player : players) {
			if (maxScore < player.getScore())
				maxScore = player.getScore();
		}
		return maxScore;
	}

	public List<Player> winner() {
		return players.stream().filter(p -> p.getScore().equals(getMaxScore())).collect(Collectors.toList());
	}

	public List<Player> play() {
		while (!cards.isEmpty()) {
			nextTurn();
		}
		return winner();
	}
}
