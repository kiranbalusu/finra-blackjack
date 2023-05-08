package com.test;

import java.util.ArrayList;

public abstract class Participant {
	
	private final String name;
	private ArrayList<Card> hand;
	
	public Participant(String name) {
	    this.name = name;
	    hand = new ArrayList<>();
	}

	public String getName() {
	    return name;
	}

	public ArrayList<Card> getHand() {
	    return hand;
	}

	public void addCard(Card card) {
	    hand.add(card);
	}

	public int getScore() {
	    int score = 0;
	    int numAces = 0;

	    for (Card card : hand) {
	        score += card.getValue();

	        if (card.getRank().equals("Ace")) {
	            numAces++;
	        }
	    }

	    // Adjust for aces
	    while (score > BlackJack.BLACKJACK && numAces > 0) {
	        score -= 10;
	        numAces--;
	    }

	    return score;
	}

	@Override
	public String toString() {
	    return name;
	}


}
