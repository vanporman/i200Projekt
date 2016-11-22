package trainingTimer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Excercise2 {
	private GridPane gridHr2 = new GridPane();
	private Scene sceneHr2 = new Scene(gridHr2, 235, 300);
	Stage avaLaud;
	
	public Excercise2(Stage avaLaud){
		avaLaud.setScene(sceneHr2);
		startHr2(avaLaud);
	}
	
	private void startHr2(Stage avaLaud){
		gridHr2.setPadding(new Insets(10, 5, 10, 5));
		sceneHr2.getStylesheets().add(getClass().getResource("appStyle.css").toExternalForm());
		
		Label pealkiri = new Label("WALL SIT");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);

		Button backButtonHr2 = new Button("...tagasi");
		backButtonHr2.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr2, 1, 6, 2, 1);
		
		gridHr2.getChildren().addAll(pealkiri, backButtonHr2);
		
		backButtonHr2.setOnAction(event ->{
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
	}
}
