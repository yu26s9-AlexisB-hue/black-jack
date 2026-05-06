package com.pluralsight;

public class Cards {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Cards(String suit, String value){
        this.suit = suit;
        this.value = value;
    }


    public String getSuit(){
        // only return the suit if the card is face up
        if(isFaceUp()){
            return suit;
        } else {
            return " ";
        }
    }

    public String getValue(){
        if (isFaceUp()){
            return value;
        }else{
            return "#";
        }
    }

    public boolean isFaceUp(){
        return isFaceUp;
    }

    public int getPointValue(){
        //only return the value if the card is face up
        if(isFaceUp()){
            return switch (this.value){
                case "A" -> 11;
                case "J", "Q", "K" -> 10;
                default -> Integer.parseInt(this.value);
            };
        }else{
            return 0;
        }
    }

    public boolean flip(){
        return (isFaceUp = !isFaceUp);
    }
}
