package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Cards> cards;

    public Deck(){
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for(String suit: suits){
            for(String value: values) {
                Cards card = new Cards(suit, value);
                cards.add(card);
            }
        }
    }

    public Cards dealFrom(){
        //deal the top cards
        if (!cards.isEmpty()){
            return cards.removeFirst();
        }else{
            return null;
        }
    }

    public int getSize(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
