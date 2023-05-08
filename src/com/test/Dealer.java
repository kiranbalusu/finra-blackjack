package com.test;

public class Dealer extends Participant {
	public Dealer() {
		super("Dealer");
		}

		public void playTurn() {
		    while (getScore() < 17) {
		        addCard(BlackJack.deck.draw());
		    }
		}

}
