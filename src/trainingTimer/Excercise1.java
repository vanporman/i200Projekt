package trainingTimer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Excercise1{
	
	private GridPane gridHr1 = new GridPane();
	private Scene sceneHr1 = new Scene(gridHr1, 235, 300);
	Stage avaLaud;
	
	public Excercise1(Stage avaLaud){
		avaLaud.setScene(sceneHr1);
		startHr1(avaLaud);
	}
	
	private void startHr1(Stage avaLaud){
		gridHr1.setPadding(new Insets(10, 5, 10, 5));
		sceneHr1.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
		
		Label pealkiri = new Label("WALL SIT");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 2, 1);
		
		Label setCountdownHr2 = new Label("SET COUNTDOWN");
		setCountdownHr2.getStyleClass().add("label-excercise-title");
		GridPane.setHalignment(setCountdownHr2, HPos.CENTER);
		GridPane.setConstraints(setCountdownHr2, 1, 2, 1, 2);
		
		TextField countdownFormatHr2 = new TextField();
		countdownFormatHr2.setPromptText("00");
		countdownFormatHr2.setPrefWidth(85);
		GridPane.setConstraints(countdownFormatHr2, 2, 2, 1, 2);

		Button backButtonHr1 = new Button("...tagasi");
		backButtonHr1.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr1, 1, 6, 2, 1);
		
		gridHr1.getChildren().addAll(pealkiri, setCountdownHr2, countdownFormatHr2, backButtonHr1);
		
		backButtonHr1.setOnAction(event ->{
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
		
	}
}
