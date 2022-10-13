package com.card;


import java.util.Scanner;

public final class BlackJack {

public static void main(String[] args) {


    System.out.println("Welcome to the BlackJack game !");


    Game playingGame = new Game();
    playingGame.createGame();
    playingGame.melanger_jeu_cartes();


    Game playerGame = new Game();
    Game dealerGame = new Game();

    double playerSold = 200.00;

    Scanner input = new Scanner(System.in);


    while (playerSold > 0) {

System.out.println("you have " + playerSold + " how much u wanna bet?");
double playerBet=input.nextDouble();
if(playerBet>playerSold){
    System.out.println("You cannot bet more than your sold !");
     break;

}
boolean  endRound=false;

playerGame.Tirer(playingGame);
playerGame.Tirer(playingGame);

dealerGame.Tirer(playingGame);
dealerGame.Tirer(playingGame);

while(true){
    //Player
    System.out.println("Your hand :");
    System.out.println(playerGame.toString());
    System.out.println("Your Hand value is :" + playerGame.cardsValue());

    //Dealer
    System.out.println("Dealer hand is " + dealerGame.getCard(0).toString() + " and [Masked]");

    //Player actions
    System.out.println("Would you like to hit :(1) or to stand :(2) ?");

    int playerResponse= input.nextInt();
    if(playerResponse == 1){
        playerGame.Tirer(playingGame);
        System.out.println("You draw" + playerGame.getCard(playerGame.deckSize()-1).toString());
        if(playerGame.cardsValue() >21){
            System.out.println("Bust. the value is :" + playerGame.cardsValue());
            playerSold -= playerBet;
        endRound=true;
        break;
        }
    }
    if(playerResponse == 2){
break;
    }
}
//revealing cards
        System.out.println("dealer cards " + dealerGame.toString());
//comparing
        if((dealerGame.cardsValue() > playerGame.cardsValue()) && endRound == false) {
            System.out.println("You lost the dealer won!");
            playerSold -= playerBet;
            endRound = true;
        }
// dealer draw 16,stand at 17
        while(dealerGame.cardsValue() < 17 && endRound== false){
            dealerGame.Tirer(playingGame);
            System.out.println("dealer  draw : " + dealerGame.getCard(dealerGame.deckSize()-1).toString());
        }
// dealer hand's value
System.out.println(" dealer hand is valued :" + dealerGame.cardsValue());
        if((dealerGame.cardsValue() > 21) && endRound==false){
            System.out.println("dealer bust! you win.");
            playerSold += playerBet;
            endRound=true;
        }
// Push
if((playerGame.cardsValue()== dealerGame.cardsValue()) && endRound==false ){
    System.out.println("it's a push");
    endRound=true;
}
if((playerGame.cardsValue() > dealerGame.cardsValue()) && endRound ==false){
    System.out.println("You won the hand");
    playerSold += playerBet;
    endRound =true;
}
playerGame.moveCardsBackToDeck(playingGame);
dealerGame.moveCardsBackToDeck(playingGame);
System.out.println("end of hand.");

    }
System.out.println("Game Over! Out of money.");
        }

            }

