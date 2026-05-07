package com.pluralsight;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(){
        Scanner scanner = new Scanner(System.in);

        displayGameTitle();

        System.out.println("How many players? ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        String[] playerNames = new String[numberOfPlayers];

        // for each player prompt for name.
        for(int i = 0; i < playerNames.length; i++){
            System.out.println("What is the name of the player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            playerNames[i] = name;
        }

        Deck deck = new Deck();
        deck.shuffle();

        Hand[] hands = new Hand[numberOfPlayers];

        for(int i = 0; i < playerNames.length; i ++){
            hands[i] = new Hand();

            Cards c1 = deck.dealFrom();
            Cards c2 = deck.dealFrom();

            hands[i].dealInto(c1);
            hands[i].dealInto(c2);

            System.out.println(playerNames[i]);

            c1.flip();
            System.out.println(c1.getSuit());
            System.out.println(c1.getValue());
            c1.flip();

            c2.flip();
            System.out.println(c2.getSuit());
            System.out.println(c2.getValue());
            c2.flip();
        }

        int winningScore = 0;
        String winner = "";

        for (int i = 0; i < playerNames.length; i++){

            int currentScore = hands[i].getValue();

            System.out.printf("%s has %d points in their hand. \n", playerNames[i], hands[i].getValue());

            //update winner if the player has a higher score
            if(currentScore > winningScore && currentScore <= 21){
                winningScore = currentScore;
                winner = playerNames[i];
            }

        }

        System.out.println("The winner is " + winner + " with " + winningScore + " points!");


    }
    private static void displayGameTitle(){
        System.out.println("--Black Jack--");
    }

}
