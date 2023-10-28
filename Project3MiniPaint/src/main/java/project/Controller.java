package project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Excellent Willie-Pepple, willei01
 */

public class Controller {

	@FXML
	private CheckBox filledChk;

	@FXML
	private Slider redSlider;
	@FXML
	private Slider greenSlider;
	@FXML
	private Slider blueSlider;

	@FXML
	private Rectangle circleMode;
	@FXML
	private Rectangle lineMode;
	@FXML
	private Rectangle rectMode;
	@FXML
	private Rectangle textMode;

	@FXML
	private Line menuLine;
	@FXML
	private Rectangle menuRectangle;
	@FXML
	private Circle menuCircle;
	@FXML
	private Text menuText;

	@FXML private Pane pane;

	private Color selectedColor;
	private Node selectedNode;
	private String insertMode;

	@FXML
	void initialize() {
		redSlider.valueProperty().addListener(e -> colorChange());
		greenSlider.valueProperty().addListener(e -> colorChange());
		blueSlider.valueProperty().addListener(e -> colorChange());
		
	}
	//Set insertMode and select the preview shape
	@FXML
	void circleMode(MouseEvent event) {
		insertMode = "circle";
		menuText.getStyleClass().remove("mode-selected");
		menuRectangle.getStyleClass().remove("mode-selected");
		menuLine.getStyleClass().remove("mode-selected");
		menuCircle.getStyleClass().add("mode-selected");
	}

	@FXML
	void lineMode(MouseEvent event) {
		insertMode = "line";
		menuText.getStyleClass().remove("mode-selected");
		menuRectangle.getStyleClass().remove("mode-selected");
		menuCircle.getStyleClass().remove("mode-selected");
		menuLine.getStyleClass().add("mode-selected");
	}

	@FXML
	void rectMode(MouseEvent event) {
		insertMode = "rect";
		menuText.getStyleClass().remove("mode-selected");
		menuCircle.getStyleClass().remove("mode-selected");
		menuLine.getStyleClass().remove("mode-selected");
		menuRectangle.getStyleClass().add("mode-selected");
	}

	@FXML
	void textMode(MouseEvent event) {
		insertMode = "txt";
		menuRectangle.getStyleClass().remove("mode-selected");
		menuCircle.getStyleClass().remove("mode-selected");
		menuLine.getStyleClass().remove("mode-selected");
		menuText.getStyleClass().add("mode-selected");
	}

	//Detects all key events
	@FXML
	void globalKeyEvents(KeyEvent e) {
		if(e.getCode() == KeyCode.ESCAPE){
			System.out.println("Deselect objects");
			insertMode = "";
			//highlights what shape you are working with in the menu
			menuText.getStyleClass().remove("mode-selected");
			menuRectangle.getStyleClass().remove("mode-selected");
			menuCircle.getStyleClass().remove("mode-selected");
			menuLine.getStyleClass().remove("mode-selected");
			deselect();
		}
		if (e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.DELETE){
			if (selectedNode instanceof Text){
				String s = ((Text) selectedNode).getText();
				if (s.length() > 0){
					s = s.substring(0, s.length() - 1);
					((Text) selectedNode).setText(s);

				} else {
					pane.getChildren().remove(selectedNode);
					deselect();
				}

			}

		} else {
			if (selectedNode instanceof Text){
				String s = ((Text) selectedNode).getText() + e.getText();
				((Text) selectedNode).setText(s);
			}

		}
	}

	@FXML
	//Mouse press create the shape
	void createShape(MouseEvent e) {

		if ("txt".equals(insertMode)) {

			Text txt = new Text(e.getX(), e.getY(), "Text");
			txt.setStroke(selectedColor);
			txt.setFill((filledChk.isSelected())? selectedColor: Color.WHITE);
			select(txt);
			selectedNode.setOnMouseClicked(event -> {
				select(txt);
			});
			selectedNode.setOnMouseDragged(event -> moveShape(event.getX(), event.getY()));

			pane.getChildren().add(selectedNode);

//
		}else if ("line".equals(insertMode)){
			Line line = new Line();
			line.setStartX(e.getX());
			line.setStartY(e.getY());
			line.setStroke(selectedColor);
			select(line);
			selectedNode.setOnMouseClicked(event -> select(line));
			selectedNode.setOnMouseDragged(event -> moveShape(event.getX(), event.getY()));
			pane.getChildren().add(line);

		} else if ("circle".equals(insertMode)){
			Ellipse ellipse = new Ellipse(e.getX(), e.getY() );
//			ellipse.setCenterX(e.getX());
//			ellipse.setCenterY(e.getY());
			ellipse.setRadiusX(50);
			ellipse.setRadiusY(100);
			ellipse.setFill(selectedColor);
			pane.getChildren().add(ellipse);
		}

	}

	@FXML
	//Mouse drag to size the shape that was just created
	void resizeShape(MouseEvent e) {
		if ("txt".equals(insertMode)){
			double fontSize = (((Text) selectedNode).getX() - ((Text) selectedNode).getY()) + (e.getX() - e.getY());
			((Text) selectedNode).setFont(new Font(fontSize));

		} /*else if ("circle".equals(insertMode)){
			double radiusX = (((Ellipse) selectedNode).getCenterX() - ((Ellipse) selectedNode).getCenterY()) + e.getX();
			double radiusY = (((Ellipse) selectedNode).getCenterX() - ((Ellipse) selectedNode).getCenterY()) + e.getY();
			((Ellipse) selectedNode).setRadiusX(radiusX);
			((Ellipse) selectedNode).setRadiusY(radiusY);
		}*/
		App.scene.setCursor(Cursor.CROSSHAIR);
	}

	@FXML
	public void mouseRelease(MouseEvent e) {
		App.scene.setCursor(Cursor.DEFAULT);
//		deselect();
	}

	@FXML
	//Mouse drag to move the shape
	void moveShape(double x, double y) {
		App.scene.setCursor(Cursor.CLOSED_HAND);
		if (selectedNode instanceof Text){
			((Text) selectedNode).setX(x);
			((Text) selectedNode).setY(y);

		}
	}


	
	//Adjust tool ribbon shape colors and set color for creating shapes
	void colorChange() {
		selectedColor = Color.rgb((int) redSlider.getValue(), (int)  blueSlider.getValue(), (int) greenSlider.getValue());
		menuCircle.setFill(selectedColor);
		menuLine.setStroke(selectedColor);
		menuRectangle.setFill(selectedColor);
		menuText.setFill(selectedColor);
	}

	void select(Node n) {
		deselect();
		selectedNode = n;
		addBorder(n);
	}

	void addBorder(Node n) {
		try {
			n.getStyleClass().add("selected");
		} catch (Exception e) {
			//Ignore when no node is selected
		}
	}

	void deselect() {
		removeBorder(selectedNode);
		selectedNode = null;
	}

	void removeBorder(Node n) {
		try {
			n.getStyleClass().remove("selected");
		} catch (NullPointerException e) {
			//Ignore when no node is selected
		}
	}
}



























