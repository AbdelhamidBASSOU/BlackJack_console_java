package com.card;

public class Card {

     private  Type Type;
     private Value Value;


     public Card(Type Type, Value Value){

         this.Value=Value;
         this.Type=Type;
     }
//to change the value and type of the cards into a string
     public String toString(){
         return this.Type.toString() + '-' + this.Value.toString();
     }
//to determinate the score of cards in the player hand
    public Value getValue() {
        return this.Value;
    }

//   public void setValue(com.card.Value value) {
//        Value = value;
//    }
//
//    public com.card.Type getType() {
//        return Type;
//    }
//
//    public void setType(com.card.Type type) {
//        Type = type;
//    }
}
