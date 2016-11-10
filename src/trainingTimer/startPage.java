package trainingTimer;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class startPage {
	private GridPane avaGrid = new GridPane();
	private Scene avaScene = new Scene(avaGrid, 235, 300);
	
	public startPage(){
		startStage();
	}

	private void startStage() {
		Stage avaLaud = new Stage();
		//avaGrid.setGridLinesVisible(true);
		avaGrid.setPadding(new Insets(10, 5, 10, 5));
		avaScene.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
		avaLaud.setScene(avaScene);
		avaLaud.show();
		
		Label pealkiri = new Label("HARJUTUSED");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);
		
		Button harjutus1 = new Button("Wall Sit");
		harjutus1.setPrefWidth(75);
		GridPane.setConstraints(harjutus1, 1, 2);
		Button harjutus2 = new Button("Plank");
		harjutus2.setPrefWidth(85);
		GridPane.setConstraints(harjutus2, 2, 2);
		Button harjutus3 = new Button("Side Plank");
		harjutus3.setPrefWidth(75);
		GridPane.setConstraints(harjutus3, 3, 2);
		
		Label stopperFormat = new Label("00:00:00");
		stopperFormat.setId("stoppwatch-style");
		GridPane.setHalignment(stopperFormat, HPos.CENTER);
		GridPane.setConstraints(stopperFormat, 1, 4, 3, 1);
		
		Button startBtn = new Button("START");
		startBtn.setPrefWidth(75);
		GridPane.setConstraints(startBtn, 1, 5);
		Button stopBtn = new Button("STOP");
		stopBtn.setPrefWidth(85);
		GridPane.setConstraints(stopBtn, 2, 5);
		Button resetBtn = new Button("RESET");
		resetBtn.setPrefWidth(75);
		GridPane.setConstraints(resetBtn, 3, 5);
		
		Button closeApp = new Button("SULGE");
		closeApp.setPrefWidth(235);
		GridPane.setConstraints(closeApp, 1, 6, 3, 1);
		
		avaGrid.getChildren().addAll(pealkiri, harjutus1, harjutus2, harjutus3, stopperFormat, startBtn, stopBtn, resetBtn, closeApp);
		
		/*
		 * Nupud
		 * -----
		 * Harjutus 1
		 */
		harjutus1.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 1");
			//avaLaud.setScene(sceneHr1);
		});
		
		/*
		 * Harjutus 2
		 */
		harjutus2.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 2");
			//avaLaud.setScene(sceneHr2);
		});
		
		/*
		 * Harjutus 3
		 */
		harjutus3.setOnAction(event ->{
			System.out.println("KLIKK HARJUTUS 3");
			//avaLaud.setScene(sceneHr3);
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
