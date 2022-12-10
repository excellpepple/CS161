package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.FileNotFoundException;

public class Controller {
    private Player player;
    private Player dealer;

    @FXML
    private Label balanceLBL;

    @FXML
    private Label dWinCount;

    @FXML
    private Label dealersValueLBL;

    @FXML
    private HBox deelersCardBox;

    @FXML
    private Label gameStats;

    @FXML
    private Button hitBtn;

    @FXML
    private ImageView logo;

    @FXML
    private Label pWinCount;

    @FXML
    private Button playBtn;

    @FXML
    private HBox playersCardBox;

    @FXML
    private Label playersValueLBL;

    @FXML
    private Button standBtn;


    @FXML
    void initialize(){
        hitBtn.setVisible(false);
        standBtn.setVisible(false);
        playBtn.setVisible(true);
        try {
            player = new Player();
            dealer = new Player();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void hit(ActionEvent event) {
        player.hit();
        try {
            updateHand(player, playersCardBox, playersValueLBL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (player.busted()){
            endGame("dealer", true);
        }
    }

    @FXML
    void startGame(ActionEvent event) {
        playersCardBox.getChildren().clear();
        deelersCardBox.getChildren().clear();
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        playBtn.setVisible(false);
        try {
            player.clearHand();
            dealer.clearHand();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        playersValueLBL.setText("0");
        dealersValueLBL.setText("0");
        dealer.hit();
        try {
            updateHand(dealer, deelersCardBox, dealersValueLBL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void stand(ActionEvent event) {
        while (!dealer.stand(player.valueOfHand())){
            dealer.hit();
            try {
                updateHand(dealer, deelersCardBox,dealersValueLBL);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (dealer.busted()){
                endGame("player", true);
            }else if (!dealer.busted()){
                if(dealer.valueOfHand() > player.valueOfHand()){
                    endGame("dealer", false);
                } else if(dealer.valueOfHand() < player.valueOfHand()){
                    endGame("player", false);
                }else{
                    endGame("tie", false);
                }
            }
        }
    }

    private void updateHand(Player p, HBox handBox, Label HandValue) throws FileNotFoundException {
        for(Card hand: p.getHand()){
            handBox.getChildren().add(new Card(hand));
        }
        HandValue.setText(String.valueOf(p.valueOfHand()));
    }

    public void endGame(String p, boolean bust){
        hitBtn.setVisible(false);
        standBtn.setVisible(false);
        playBtn.setVisible(true);
        if ("player".compareToIgnoreCase(p) == 0) {
            gameStats.setText("Player Wins!");
            playersValueLBL.setText(String.valueOf(player.win()));
            if(bust){
                dealersValueLBL.setText(String.valueOf(dealer.valueOfHand()) + "" +
                        "Bust!");
            }
        } else if ("dealer".compareToIgnoreCase(p) == 0){
            gameStats.setText("Dealer Wins!");
            dealersValueLBL.setText(String.valueOf(dealer.win()));
            if(bust){
                playersValueLBL.setText(String.valueOf(player.valueOfHand()) + " Bust!");
            }
        } else{
            gameStats.setText("Tie! no one wins!");
        }

    }
}
