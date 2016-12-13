package trainingTimer;

import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Excercise1Window{
	
//	public static int aegStardini;
	private GridPane gridHr1 = new GridPane();
	private Scene sceneHr1 = new Scene(gridHr1, 235, 300);
	Stage avaLaud;
	
	static Integer hour = 0; // Stopperi tunnid
	static String h = "00"; // Tundide formaat
	static Integer minute = 0; // Stoppri minutid
//	static String min = "00"; // Minutite formaat
	static Integer second = 0; // Stopperi sekundid
	static String sec; // Sekundite formaat
	
	public Excercise1Window(Stage avaLaud){
		avaLaud.setScene(sceneHr1);
		startHr1(avaLaud);
	}
	
	private void startHr1(Stage avaLaud){
		gridHr1.setPadding(new Insets(10, 5, 10, 5));
		gridHr1.setHgap(5);
		gridHr1.setVgap(5);
		sceneHr1.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
//		gridHr1.setGridLinesVisible(true);
		
		Label pealkiri = new Label("WALL SIT");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Label setCountdownHr1 = new Label("SET COUNTDOWN");
		setCountdownHr1.getStyleClass().add("label-set-countdown-title");
		GridPane.setHalignment(setCountdownHr1, HPos.CENTER);
		GridPane.setConstraints(setCountdownHr1, 1, 2, 2, 1);
		
		TextField countdownFormatHr1 = new TextField();
		countdownFormatHr1.getStyleClass().add("input-field");
		countdownFormatHr1.setPromptText("00");
		countdownFormatHr1.setPrefWidth(85);
		GridPane.setConstraints(countdownFormatHr1, 3, 2, 1, 1);
		
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

		Button backButtonHr1 = new Button("TAGASI");
		backButtonHr1.getStyleClass().add("button-back");
		backButtonHr1.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr1, 1, 5, 3, 1);
		
		gridHr1.getChildren().addAll(pealkiri, setCountdownHr1, countdownFormatHr1, stopperFormat, startBtn, stopBtn, resetBtn, backButtonHr1);
		
		new AnimationTimer(){
			@Override
			public void handle(long now){
				stopperFormat.setText(h + ":" + (minute < 10 ? "0" : "") + minute + ":" + (second < 10 ? "0" : "") + second);
			}
		}.start();
		
		startBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 0;
			System.out.println("START");
			CountdownTimer.aegStardini = Integer.parseInt(countdownFormatHr1.getText());
			second = CountdownTimer.aegStardini;
			sec = "second";
			CountdownTimer countdownToStart = new CountdownTimer();
			countdownToStart.alustaAllalugemist();
		});
		
		stopBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 1;
			
			Ex1And2Timer stop = new Ex1And2Timer();
			stop.startTimerHr();
//			CountdownTimer stop2 = new CountdownTimer();
//			stop2.alustaAllalugemist();
			System.out.println("STOPP KLIKK WALL SIT VAATES");
		});
		
		resetBtn.setOnAction(event ->{
			StartPage.taimeriOlek = 1;
			hour = 0; // Resetitud stopperi tunnid
			h = "00"; // Resetitud tundide formaat
			minute = 0; // Resetitud stoppri minutid
			second = 0; // Resetitud stopperi sekundid
			System.out.println("RESET KLIKK WALL SIT VAATES");
		});
		
		backButtonHr1.setOnAction(event ->{
			StartPage.harjutuseValik = 0;
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
		
	}
}
