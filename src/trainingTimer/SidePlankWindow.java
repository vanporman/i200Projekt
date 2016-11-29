package trainingTimer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SidePlankWindow {
	
//	public static int aegStardini;
	private GridPane gridHr3 = new GridPane();
	private Scene sceneHr3 = new Scene(gridHr3, 235, 300);
	Stage avaLaud;
	
	public SidePlankWindow(Stage avaLaud){
		avaLaud.setScene(sceneHr3);
		startHr3(avaLaud);
	}
	
	private void startHr3(Stage avaLaud){
		gridHr3.setPadding(new Insets(10, 5, 10, 5));
		gridHr3.setHgap(5);
		gridHr3.setVgap(5);
		sceneHr3.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
//		gridHr3.setGridLinesVisible(true);
		
		Label pealkiri = new Label("SIDE PLANK");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Label setCountdownHr3 = new Label("SET COUNTDOWN");
		setCountdownHr3.getStyleClass().add("label-set-countdown-title");
		GridPane.setHalignment(setCountdownHr3, HPos.CENTER);
		GridPane.setConstraints(setCountdownHr3, 1, 2, 2, 1);
		
		TextField countdownFormatHr3 = new TextField();
		countdownFormatHr3.getStyleClass().add("input-field");
		countdownFormatHr3.setPromptText("00");
		countdownFormatHr3.setPrefWidth(85);
		GridPane.setConstraints(countdownFormatHr3, 3, 2, 1, 1);
		
		Label stopperFormat = new Label("00:00:00");
		stopperFormat.setId("stoppwatch-style");
		GridPane.setHalignment(stopperFormat, HPos.CENTER);
		GridPane.setConstraints(stopperFormat, 1, 3, 3, 1);
		
		Button startBtn = new Button("START");
		startBtn.getStyleClass().add("button-start");
		startBtn.setPrefWidth(75);
		GridPane.setConstraints(startBtn, 1, 4);
		Button stopBtn = new Button("STOP");
		stopBtn.getStyleClass().add("button-stop");
		stopBtn.setPrefWidth(85);
		GridPane.setConstraints(stopBtn, 2, 4);
		Button resetBtn = new Button("RESET");
		resetBtn.getStyleClass().add("button-start");
		resetBtn.setPrefWidth(75);
		GridPane.setConstraints(resetBtn, 3, 4);

		Button backButtonHr3 = new Button("TAGASI");
		backButtonHr3.getStyleClass().add("button-back");
		backButtonHr3.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr3, 1, 5, 3, 1);
		
		gridHr3.getChildren().addAll(pealkiri, setCountdownHr3, countdownFormatHr3, stopperFormat, startBtn, stopBtn, resetBtn, backButtonHr3);
		
		startBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 0;
			System.out.println("Kasutaja sisestas: " + Integer.parseInt(countdownFormatHr3.getText()));
			Countdown.aegStardini = Integer.parseInt(countdownFormatHr3.getText());
			System.out.println("START");
			Countdown countdownToStart = new Countdown();
			countdownToStart.alustaAllalugemist();
		});
		
		stopBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 1;
			
			Countdown stop2 = new Countdown();
			stop2.alustaAllalugemist();
			Stopper stop = new Stopper();
			stop.startStopper();
			System.out.println("STOPP KLIKK AVAVAATES");
		});
		
		resetBtn.setOnAction(event ->{
			System.out.println("RESET KLIKK WALL SIT VAATES");
		});
		
		backButtonHr3.setOnAction(event ->{
			StartPage.harjutuseValik = 0;
//			System.out.println("harjutseValik: " + StartPage.harjutuseValik);
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
	}
}
