package com.test;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        // Create cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10,10};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

}
