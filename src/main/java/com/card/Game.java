package com.card;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Card> Cards;

    public Game(){
    this.Cards=new ArrayList<Card>();
    }

    public void createGame(){
        for(Type cardType : Type.values()){
            for(Value cardValue : Value.values()){
                this.Cards.add(new Card(cardType,cardValue));
            }
        }
   }

   public void shuffleCards(){

    ArrayList<Card> tmpGame = new ArrayList<Card>();
       Random random = new Random();
       int randomCardIndex=0;
       int originalSize= this.Cards.size();
       for(int i=0;i<originalSize;i++){
           //random.nextInt((max - min)+1)+min;
           randomCardIndex = random.nextInt((this.Cards.size()-1-0)+1)+0;
           tmpGame.add(this.Cards.get(randomCardIndex));

           this.Cards.remove(randomCardIndex);
       }
       this.Cards=tmpGame;
   }


    public String toString(){
          String cardList="";
    //      int i=1;
          for(Card aCard : this.Cards){
              cardList += "\n" + aCard.toString();
             // i++;
            }
            return cardList;
         }

         public void removeCard(int i){
            this.Cards.remove(i);
         }

         public Card getCard(int i){
        return this.Cards.get(i);
         }

         public void addCard(Card addCard){
        this.Cards.add(addCard);
         }


         public void Tirer(Game CF){
        this.Cards.add(CF.getCard(0));
        CF.removeCard(0);
         }

         public int cardsValue(){
                int totalValue =0;
                int aces=0;
                for (Card aCard : this.Cards){
            switch(aCard.getValue()){
            case TWO: totalValue +=2;break;
            case THREE:totalValue +=3;break;
            case FOUR:totalValue +=4;break;
            case FIVE:totalValue +=5;break;
            case SIX:totalValue +=6;break;
            case SEVEN:totalValue +=7;break;
            case EIGHT:totalValue +=8;break;
            case NINE:totalValue +=9;break;
            case TEN:totalValue += 10;break;
            case JACK:totalValue += 10;break;
            case QUEEN:totalValue +=10;break;
            case KING:totalValue +=10;break;
            case ACE:totalValue += 1;break;
            }
        }

        for(int i=0;i<aces;i++){
            if(totalValue > 10){
                totalValue += 1;
            }else{
                totalValue +=11;
            }
        }
        return totalValue;
     }

     public int deckSize(){
        return this.Cards.size();
     }

     public void moveCardsBackToDeck(Game move){
        int DeckSize = this.Cards.size();

        for(int i=0;i<DeckSize;i++){
        move.addCard(this.getCard(i));
        }
        for(int i=0;i<DeckSize;i++){
            this.removeCard(0);
        }
     }
}
