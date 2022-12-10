package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;

/**
 * Name: Excellent Willie-Pepple
 * Username: willei01
 */

public class Controller {
    @FXML
    private TextField BasePriceTxT;

    @FXML
    private Button CalculateBtn;

    @FXML
    private TextField DownPaymentTxT;

    @FXML
    private RadioButton Month24;

    @FXML
    private RadioButton Month36;

    @FXML
    private RadioButton Month48;

    @FXML
    private RadioButton Month60;

    @FXML
    private Label MonthlyPaymentLbL;

    @FXML
    private CheckBox RearCameraBtn;

    @FXML
    private Button ResetBtn;

    @FXML
    private TextField SalesTaxTxT;

    @FXML
    private CheckBox SunRoofBtn;

    @FXML
    private Label TotalLoanAmountLbL;

    @FXML
    private Label TotalPaymentLbL;

    @FXML
    private CheckBox TouchScreenBtn;

    public void initialize(){
        ToggleGroup loanGroup = new ToggleGroup();

        Month24.setToggleGroup(loanGroup);
        Month36.setToggleGroup(loanGroup);
        Month48.setToggleGroup(loanGroup);
        Month60.setToggleGroup(loanGroup);

        Month24.setSelected(false);
        Month36.setSelected(false);
        Month48.setSelected(false);
        Month60.setSelected(false);

        SunRoofBtn.setSelected(false);
        TouchScreenBtn.setSelected(false);
        RearCameraBtn.setSelected(false);

        TotalLoanAmountLbL.setText("0.0");
        MonthlyPaymentLbL.setText("0.0");
        TotalPaymentLbL.setText("0.0");

        BasePriceTxT.setText("0.0");
        DownPaymentTxT.setText("0.0");
        SalesTaxTxT.setText("0.0");

    }

    @FXML
    void Calculate(ActionEvent event) {
        DecimalFormat df = new DecimalFormat("#.##");
        double basePrice = Double.parseDouble(BasePriceTxT.getText());
        double downPayment = Double.parseDouble(DownPaymentTxT.getText());
        double taxRate = Double.parseDouble(SalesTaxTxT.getText())/100;
//        System.out.println(taxRate);
        double annualInterestRate = 0.0;
        int months = 0;
        if (Month24.isSelected()){
            months = 24;
            annualInterestRate = 0.07;
        }
        if (Month36.isSelected()){
            months = 36;
            annualInterestRate = 0.06;
        }
        if (Month48.isSelected()){
            months = 48;
            annualInterestRate = 0.055;
        }
        if(Month60.isSelected()){
            months = 60;
            annualInterestRate = 0.5;
        }
        int optionCosts = 0;
        if (SunRoofBtn.isSelected()){
            optionCosts += 1510;
        }
        if (TouchScreenBtn.isSelected()){
            optionCosts += 470;
        }
        if (RearCameraBtn.isSelected()){
            optionCosts += 340;
        }

        double subtotal =  basePrice + optionCosts;
        double tax = subtotal * taxRate;
        double totalLoan = subtotal + tax - downPayment;
        TotalLoanAmountLbL.setText(df.format(totalLoan));
        double monthlyInterest = annualInterestRate/12;
        double monthScale = Math.pow(1+ monthlyInterest, months);
        double monthlyPayment = subtotal * ((monthlyInterest * monthScale)/ (monthScale - 1));
        MonthlyPaymentLbL.setText(df.format(monthlyPayment));
        double totalPayment = monthlyPayment * months;
        TotalPaymentLbL.setText(df.format(totalPayment));

    }

    @FXML
    void Reset(ActionEvent event) {
        initialize();
    }
}
