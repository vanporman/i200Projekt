package trainingTimer;

/*
 * Avaleht, siit saab jooksutada kas stopperit v6i valida yhe kolmest harjutusest
 */

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartPage {
	private GridPane avaGrid = new GridPane();
	private Scene avaScene = new Scene(avaGrid, 235, 300);
	Stage laud;
	// Vajalik taimeri jookstamiseks ja l6petamiseks
	public static int taimeriOlek = 0; // 1-jookseb, 2-seisab
	// Vajalik selleks, et õige allalugemise timer valitakse CountdownTimer klassist
	public static int harjutuseValik = 0; // 1-wall sit, 2-plank, 3-side plank
	
	static Integer hour = 0; // Stopperi tunnid
	static String h = "00"; // Tundide formaat
	static Integer minute = 0; // Stoppri minutid
	static String min = "00"; // Minutite formaat
	static Integer second = 0; // Stopperi sekundid
	static String sec = "00"; // Sekundite formaat
	
	public StartPage(Stage avaLaud){ // konstruktor (kui nimi on sama klassiga)
		avaLaud.setScene(avaScene); // sceneile on stage kaasa antud
		laud = avaLaud;
		startStage(); // k2ivitasin stage
	}

	//StartPage - avaleht
	private void startStage() {
		avaGrid.setPadding(new Insets(10, 5, 10, 5));
		avaGrid.setHgap(5);
		avaGrid.setVgap(5);
		avaScene.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
//		avaGrid.setGridLinesVisible(true);
		
		Label pealkiri = new Label("HARJUTUSED");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Button harjutus1 = new Button("Wall Sit");
		harjutus1.getStyleClass().add("button-choose-excercise");
		harjutus1.setPrefWidth(75);
		GridPane.setConstraints(harjutus1, 1, 2);
		Button harjutus2 = new Button("Plank");
		harjutus2.getStyleClass().add("button-choose-excercise");
		harjutus2.setPrefWidth(85);
		GridPane.setConstraints(harjutus2, 2, 2);
		Button harjutus3 = new Button("Side Plank");
		harjutus3.getStyleClass().add("button-choose-excercise");
		harjutus3.setPrefWidth(75);
		GridPane.setConstraints(harjutus3, 3, 2);
		
		Label stopperFormat = new Label();
		stopperFormat.setId("stoppwatch-style");
		GridPane.setHalignment(stopperFormat, HPos.CENTER);
		GridPane.setConstraints(stopperFormat, 1, 4, 3, 1);
		
		Button startBtn = new Button("START");
		startBtn.getStyleClass().add("button-start");
		startBtn.setPrefWidth(75);
		GridPane.setConstraints(startBtn, 1, 5);
		Button stopBtn = new Button("STOP");
		stopBtn.getStyleClass().add("button-stop");
		stopBtn.setPrefWidth(85);
		GridPane.setConstraints(stopBtn, 2, 5);
		Button resetBtn = new Button("RESET");
		resetBtn.getStyleClass().add("button-start");
		resetBtn.setPrefWidth(75);
		GridPane.setConstraints(resetBtn, 3, 5);
		
		Button closeApp = new Button("SULGE");
		closeApp.getStyleClass().add("button-stop");
		closeApp.setPrefWidth(235);
		GridPane.setConstraints(closeApp, 1, 6, 3, 1);
		
		avaGrid.getChildren().addAll(pealkiri, harjutus1, harjutus2, harjutus3, stopperFormat, startBtn, stopBtn, resetBtn, closeApp);
		
		new AnimationTimer(){
			@Override
			public void handle(long now){
				stopperFormat.setText(h+":"+min+":"+sec);
			}
		}.start();
		
		/*
		 * Nupud
		 * -----
		 * Harjutus 1
		 */
		harjutus1.setOnAction(event ->{
			harjutuseValik = 1;
			System.out.println("KLIKK HARJUTUS " + harjutuseValik);
			new Excercise1Window(laud);
		});
		
		/*
		 * Harjutus 2
		 */
		harjutus2.setOnAction(event ->{
			harjutuseValik = 2;
			System.out.println("KLIKK HARJUTUS " + harjutuseValik);
			new Excercise2Window(laud);
		});
		
		/*
		 * Harjutus 3
		 */
		harjutus3.setOnAction(event ->{
			harjutuseValik = 3;
			System.out.println("KLIKK HARJUTUS " + harjutuseValik);
			new Excercise3Window(laud);
		});
		
		/*
		 * Avavaate START nupp
		 */
		startBtn.setOnAction(event ->{
			taimeriOlek = 0;
			System.out.println("START KLIKK AVAVAATES");
			Stopper start = new Stopper();
			start.startStopper();
		});
		
		/*
		 * Avavaate STOPP nupp
		 */
		stopBtn.setOnAction(event ->{
			taimeriOlek = 1;
			Stopper stop = new Stopper();
			stop.startStopper();
			System.out.println("STOPP KLIKK AVAVAATES");
		});
		
		/*
		 * Avavaate RESET NUPP
		 */
		resetBtn.setOnAction(event ->{
			if (taimeriOlek == 1){
				hour = 0; // Resetitud stopperi tunnid
				h = "00"; // Resetitud tundide formaat
				minute = 0; // Resetitud stoppri minutid
				min = "00"; // Resetitud minutite formaat
				second = 0; // Resetitud stopperi sekundid
				sec = "00"; // Resetitud sekundite formaat
			}
			System.out.println("RESET KLIKK AVAVAATES");
		});
		/*
		 * SULGEB RAKENDUSE
		 */
		closeApp.setOnAction(event ->{
			System.out.println("SULGEN");
			Platform.exit();
		});
	}
}
