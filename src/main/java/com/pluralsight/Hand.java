package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Cards> cards = new ArrayList<>();

    public void dealInto(Cards card){
        cards.add(card);
    }

    public int getSize(){
        return cards.size();
    }

    public int getValue(){
        int value = 0;

        for(Cards card: cards){
            if(card.isFaceUp()){
                value += card.getPointValue();
            }else{
                card.flip(); //turn the card over to see the value
                value += card.getPointValue();
                card.flip(); // hide the card again
            }
        }
        return value;
    }
}
