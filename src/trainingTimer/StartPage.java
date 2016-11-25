package trainingTimer;

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
	
	public StartPage(Stage avaLaud){ //<-- konstruktor (kui nimi on sama klassiga)
		avaLaud.setScene(avaScene); //<-- sceneile andsime stage kaasa
		laud = avaLaud;
		startStage(); //<-- k2ivitasime stagei
	}

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
		
		Label stopperFormat = new Label("00:00:00");
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
		
		/*
		 * Nupud - lähevad uude klassi
		 * -----
		 * Harjutus 1
		 */
		harjutus1.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 1");
			new Excercise1(laud);
		});
		
		/*
		 * Harjutus 2
		 */
		harjutus2.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 2");
			new Excercise2(laud);
		});
		
		/*
		 * Harjutus 3
		 */
		harjutus3.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 3");
			new Excercise3(laud);
		});
		
		/*
		 * Avavaate START nupp
		 */
		startBtn.setOnAction(event ->{
			System.out.println("START KLIKK AVAVAATES");
		});
		
		/*
		 * Avavaate STOPP nupp
		 */
		stopBtn.setOnAction(event ->{
			System.out.println("STOPP KLIKK AVAVAATES");
		});
		
		/*
		 * Avavaate RESET NUPP
		 */
		resetBtn.setOnAction(event ->{
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
