package project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static Deck deck;
    private ArrayList<Card> hand;
    private static int wins;

    public Player() throws FileNotFoundException {
        hand = new ArrayList<Card>();
        deck = new Deck();
        wins = 0;
    }

    public int valueOfHand(){
        int total = 0;
        for(Card card: this.getHand()) {
            String face = card.getFace();
            if(Character.isDigit(face.charAt(0))) {
                total += Integer.parseInt(face);
            }else if(face.compareToIgnoreCase("A") == 0) {
                int high = total + 11, low = total + 1;
                if(total+high > 21){
                    total += low;
                } else {
                    total += high;
                }
            } else{
                total += 10;
            }
        }
            return total;
    }
    public void clearHand() throws FileNotFoundException {
        hand.clear();
        deck.reset();
    }

    public boolean stand(int otherPlayerValue){
        if (this.valueOfHand() > otherPlayerValue || this.valueOfHand() >= 19){
            return true;
        } else if(this.valueOfHand() > 16){
            Random random = new Random();
            return random.nextInt(100)>=15;
        }
        return false;
    }

    public boolean busted(){
        return this.valueOfHand() > 21;
    }

    public void hit(){
        hand.add(deck.dealCard());
    }

    public int win(){
        wins++;
        return wins;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
