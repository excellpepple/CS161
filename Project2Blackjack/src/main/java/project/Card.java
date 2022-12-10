package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Card extends ImageView{
    public static String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
    public static int HEIGHT = 130;
    private String face = "";


    public Card(String face) throws FileNotFoundException {
        this.face = new String(face);
        InputStream stream = null;
        stream = new FileInputStream("src/main/resources/cards/" + face.toUpperCase() + ".png");
        setImage(new Image(stream));
        this.setFitHeight(HEIGHT);
        this.setPreserveRatio(true);
    }
    public Card(Card c) throws FileNotFoundException {
        this.face = c.face;
        InputStream stream = null;
        stream = new FileInputStream("src/main/resources/cards/" + face.toUpperCase() + ".png");
        setImage(new Image(stream));
        this.setFitHeight(HEIGHT);
        this.setPreserveRatio(true);
    }

    public String getFace(){
        return this.face;
    }

    public int valueOf(){
        if(Character.isDigit(getFace().toCharArray()[0])){
            return Integer.parseInt(getFace());
        } else if (getFace().compareToIgnoreCase("A") == 0){
            return 11;
        } else{
            return 10;
        }
    }
}
