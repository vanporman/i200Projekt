package trainingTimer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Excercise3 {
	private GridPane gridHr3 = new GridPane();
	private Scene sceneHr3 = new Scene(gridHr3, 235, 300);
	Stage avaLaud;
	
	public Excercise3(Stage avaLaud){
		avaLaud.setScene(sceneHr3);
		startHr3(avaLaud);
	}
	
	private void startHr3(Stage avaLaud){
		gridHr3.setPadding(new Insets(10, 5, 10, 5));
		sceneHr3.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
//		gridHr3.setGridLinesVisible(true);
		
		Label pealkiri = new Label("SIDE PLANK");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Label setCountdownHr2 = new Label("SET COUNTDOWN");
		setCountdownHr2.getStyleClass().add("label-set-countdown-title");
		GridPane.setHalignment(setCountdownHr2, HPos.CENTER);
		GridPane.setConstraints(setCountdownHr2, 1, 2, 2, 1);
		
		TextField countdownFormatHr2 = new TextField();
		countdownFormatHr2.setPromptText("00");
		countdownFormatHr2.setPrefWidth(85);
		GridPane.setConstraints(countdownFormatHr2, 3, 2, 1, 1);
		
		Label stopperFormat = new Label("00:00:00");
		stopperFormat.setId("stoppwatch-style");
		GridPane.setHalignment(stopperFormat, HPos.CENTER);
		GridPane.setConstraints(stopperFormat, 1, 3, 3, 1);
		
		Button startBtn = new Button("START");
		startBtn.setPrefWidth(75);
		GridPane.setConstraints(startBtn, 1, 4);
		Button stopBtn = new Button("STOP");
		stopBtn.setPrefWidth(85);
		GridPane.setConstraints(stopBtn, 2, 4);
		Button resetBtn = new Button("RESET");
		resetBtn.setPrefWidth(75);
		GridPane.setConstraints(resetBtn, 3, 4);

		Button backButtonHr3 = new Button("...tagasi");
		backButtonHr3.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr3, 1, 5, 3, 1);
		
		gridHr3.getChildren().addAll(pealkiri, setCountdownHr2, countdownFormatHr2, stopperFormat, startBtn, stopBtn, resetBtn, backButtonHr3);
		
		backButtonHr3.setOnAction(event ->{
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
	}
}
