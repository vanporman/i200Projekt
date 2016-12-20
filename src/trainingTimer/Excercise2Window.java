package trainingTimer;

import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Excercise2Window {
	
	private GridPane gridHr2 = new GridPane();
	private Scene sceneHr2 = new Scene(gridHr2, 235, 300);
	Stage avaLaud;
//	private static int aegStardini;
	
	static Integer hour = 0; // Stopperi tunnid
	static String h = "00"; // Tundide formaat
	static Integer minute = 0; // Stoppri minutid
//	static String min = "00"; // Minutite formaat
	static Integer second = 0; // Stopperi sekundid
//	static String sec = "00"; // Sekundite formaat
	
	public Excercise2Window(Stage avaLaud){
		avaLaud.setScene(sceneHr2);
		startHr2(avaLaud);
	}
	
	private void startHr2(Stage avaLaud){
		gridHr2.setPadding(new Insets(10, 5, 10, 5));
		gridHr2.setHgap(5);
		gridHr2.setVgap(5);
		sceneHr2.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
//		gridHr2.setGridLinesVisible(true);
		
		Label pealkiri = new Label("PLANK");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Label setCountdownHr2 = new Label("SET COUNTDOWN");
		setCountdownHr2.getStyleClass().add("label-set-countdown-title");
		GridPane.setHalignment(setCountdownHr2, HPos.CENTER);
		GridPane.setConstraints(setCountdownHr2, 1, 2, 2, 1);
		
		TextField countdownFormatHr2 = new TextField();
		countdownFormatHr2.getStyleClass().add("input-field");
		countdownFormatHr2.setPromptText("00");
		countdownFormatHr2.setPrefWidth(85);
		GridPane.setConstraints(countdownFormatHr2, 3, 2, 1, 1);
		
		Label stopperFormat = new Label();
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

		Button backButtonHr2 = new Button("TAGASI");
		backButtonHr2.getStyleClass().add("button-back");
		backButtonHr2.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr2, 1, 5, 3, 1);
		
		gridHr2.getChildren().addAll(pealkiri, setCountdownHr2, countdownFormatHr2, stopperFormat, startBtn, stopBtn, resetBtn, backButtonHr2);
		
		new AnimationTimer(){
			@Override
			public void handle(long now){
				stopperFormat.setText(h + ":" + (minute < 10 ? "0" : "") + minute + ":" + (second < 10 ? "0" : "") + second);
			}
		}.start();
		
		startBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 1;
			System.out.println("START");
//			System.out.println("Kasutaja aeg: " + Integer.parseInt(countdownFormatHr2.getText()));
			CountdownTimer.aegStardini = Integer.parseInt(countdownFormatHr2.getText());
			second = CountdownTimer.aegStardini;
			CountdownTimer countdownToStart = new CountdownTimer();
			countdownToStart.alustaAllalugemist();
		});
		
		stopBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 2;
			
//			Ex1And2Timer stop = new Ex1And2Timer();
//			stop.startTimerHr();
//			CountdownTimer stop2 = new CountdownTimer();
//			stop2.alustaAllalugemist();
			System.out.println("STOPP KLIKK PLANK VAATES");
		});
		
		resetBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 2;
			hour = 0;
			h = "00";
			minute = 0;
			second = 0;
			System.out.println("RESET KLIKK PLANK VAATES");
		});
		
		backButtonHr2.setOnAction(event ->{
			StartPage.harjutuseValik = 0;
			StartPage.taimeriOlek = 0;
//			CountdownTimer stop = new CountdownTimer();
//			stop.allaLugemiseTimer.cancel();
//			Ex1And2Timer stop2 = new Ex1And2Timer();
//			stop2.myTimer.cancel();
//			System.out.println("harjutseValik: " + StartPage.harjutuseValik);
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
	}
}
