package project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private Random rand;
    public Deck() throws FileNotFoundException {
        cards = new ArrayList<Card>();
        rand = new Random();
        reset();
    }
    public Card dealCard(){
        Card c = cards.get(rand.nextInt(cards.size()-1));
        cards.remove(c);
        return c;
    }

    public void reset() throws FileNotFoundException {
        cards.clear();
        for (String face: Card.FACES){
            cards.add(new Card(face));
        }
    }
}
