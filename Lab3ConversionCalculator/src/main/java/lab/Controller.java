package lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 * Name: Excellent Willie-Pepple
 * Username: willeio1
 */

public class Controller {
    private DecimalFormat df = new DecimalFormat("#.##");
    @FXML
    private Button clalculate;

    @FXML
    private Button clear;

    @FXML
    private TextField cmT;

    @FXML
    private Label errorL;

    @FXML
    private Button exit;

    @FXML
    private TextField inT;

    @FXML
    private TextField mT;

    @FXML
    private TextField yT;

    @FXML
    void calculateBtn(ActionEvent event) {
        System.out.println("Calculate btn pressed");
        try {
            if (canConvert()){
                if (!inT.getText().isEmpty()){
                    inConvert();
                } else if(!cmT.getText().isEmpty()) {
                    cmConvert();
                } else if (!yT.getText().isEmpty()){
                    yConvert();
                } else if (!mT.getText().isEmpty()) {
                    mConvert();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clearBtn(ActionEvent event) {
        TextField[] inputFields = new TextField[]{inT, cmT, mT, yT};
        for (TextField field : inputFields) {
            field.setText("");
        }
        errorL.setText("");
    }

    @FXML
    void exitBtn(ActionEvent event) {
        System.exit(0);
    }

    public boolean canConvert(){
        TextField[] inputFields = new TextField[]{inT, cmT, mT, yT};

        int filledFields = 0;
        for (TextField field : inputFields) {
            if (!field.getText().isEmpty()) {
                filledFields++;
            }
        }
        if (filledFields == 1){
            return true;
        } else if (filledFields > 1){
            errorL.setText("Invalid number of filled fields: you must enter exactly one field.");
            return false;
        } else{
            errorL.setText("Fields not filled");
            return false;
        }

    }

    public void cmConvert(){
        double cm = Double.parseDouble(cmT.getText());
        inT.setText(""+ df.format(cm2in(cm)));
        mT.setText(""+ df.format(cm2m(cm)));
        yT.setText(""+ df.format(cm2y(cm)));
    }

    public void inConvert(){
        double  inches = Double.parseDouble(inT.getText());
        cmT.setText(""+ df.format(in2cm(inches)));
        yT.setText(""+ df.format(in2y(inches)));
        mT.setText(""+ df.format(in2m(inches)));
    }

    public void yConvert(){
        double yards = Double.parseDouble(yT.getText());
        mT.setText(""+ df.format(y2m(yards)));
        inT.setText(""+ df.format(y2in(yards)));
        cmT.setText(""+ df.format(y2cm(yards)));
    }

    public void mConvert(){
        double meters = Double.parseDouble(mT.getText());
        inT.setText(""+ df.format(m2in( meters)));
        yT.setText(""+ df.format(m2y( meters)));
        cmT.setText(""+ df.format(m2cm( meters)));
    }

    public double cm2in(double cm ){
        return cm * 0.393701;
    }

    public double cm2m(double cm){
        return cm * 0.0100000054;

    }
    public double cm2y(double cm){

        return cm * 0.0109361;
    }

    public double in2cm(double inches){

        return inches * 2.53999233936;
    }

    public double in2y(double inches){

        return inches * 0.0277778;
    }

    public double in2m(double inches){

        return inches * 0.02540002032;
    }

    public double y2m(double yards){

        return yards * 0.91440073152;
    }

    public double y2in(double yards){

        return yards * 36.0000288;
    }

    public double y2cm(double yards){

        return yards * 91.440073152;
    }

    public double m2y(double meters){

        return meters * 1.09361417323;
    }

    public double m2in(double meters){

        return meters * 39.370110236279998617;
    }
    public double m2cm(double meters){

        return meters * 100.00008;
    }

}
