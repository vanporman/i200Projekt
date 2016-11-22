package trainingTimer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		
		Label pealkiri = new Label("WALL SIT");
		pealkiri.getStyleClass().add("label-title");
		GridPane.setHalignment(pealkiri, HPos.CENTER);
		GridPane.setConstraints(pealkiri, 1, 1, 3, 1);

		Button backButtonHr3 = new Button("...tagasi");
		backButtonHr3.setPrefWidth(235);
		GridPane.setConstraints(backButtonHr3, 1, 6, 2, 1);
		
		gridHr3.getChildren().addAll(pealkiri, backButtonHr3);
		
		backButtonHr3.setOnAction(event ->{
			System.out.println("KLIKK TAGASI AVAVAATESSE");
			new StartPage(avaLaud);
		});
	}
}
