package trainingTimer;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		Stage avaLaud = new Stage();
		new StartPage(avaLaud); //<-- l6ime uue objekti starPage klassist ja andsin stagei kaasa
		avaLaud.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
