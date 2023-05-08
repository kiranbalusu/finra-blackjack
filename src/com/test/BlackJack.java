package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	
	private static final int MAX_PLAYERS = 3;
    static final int BLACKJACK = 21;

    private ArrayList<Player> players;
    static Deck deck;
    private Dealer dealer;

    public BlackJack() {
        players = new ArrayList<>();
        deck = new Deck();
        dealer = new Dealer();

        // Create players
        for (int i = 0; i < MAX_PLAYERS; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
    }

    public void start() {
        // Shuffle deck
        deck.shuffle();

        // Deal initial cards
        dealCards();

        // Play game
        for (Player player : players) {
            playTurn(player);
        }

        // Dealer's turn
        dealer.playTurn();

        // Determine winner
        determineWinner();
    }

    private void dealCards() {
        for (Player player : players) {
            player.addCard(deck.draw());
            player.addCard(deck.draw());
        }

        dealer.addCard(deck.draw());
        dealer.addCard(deck.draw());
    }

    private void playTurn(Player player) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(player.getName() + ", your turn (current score: " + player.getScore() + ")");
            System.out.println("Your cards: " + player.getHand());

            System.out.println("1. Hit");
            System.out.println("2. Stand");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // Player hits
                player.addCard(deck.draw());

                if (player.getScore() > BLACKJACK) {
                    // Player busts
                    break;
                }
            } else if (choice == 2) {
                // Player stands
                break;
            }
        }
    }

    private void determineWinner() {
        for (Player player : players) {
            if (player.getScore() <= BLACKJACK && (dealer.getScore() > BLACKJACK || player.getScore() > dealer.getScore())) {
                System.out.println("Scoring of " + player.getName() + " has " + player.getScore() + " Dealer has " + dealer.getScore() + " " +  player.getName() + " wins.");
            } else if(player.getScore() > BLACKJACK){
            	System.out.println("Scoring of " + player.getName() + " busted Dealer wins");
            }
            else {
                System.out.println("Scoring of " + player.getName() + " has " + player.getScore() + " Dealer has " + dealer.getScore() + " Dealer wins.");
            }
        }
    }

}
