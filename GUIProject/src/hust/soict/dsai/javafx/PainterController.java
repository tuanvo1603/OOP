package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import javafx.fxml.FXML;

public class PainterController {
	public class PleaseProvideControllerClassName {

	    @FXML
	    private Pane drawingAreaPane;

	    @FXML
	    void clearButtonPressed(ActionEvent event) {
	    	drawingAreaPane.getChildren().clear();
	    }

	    @FXML
	    void drawingAreaMouseDragged(MouseEvent event) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(), 4.000);
	    	drawingAreaPane.getChildren().add(newCircle);
	    }

	}

}
