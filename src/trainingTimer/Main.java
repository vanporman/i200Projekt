package trainingTimer;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		Stage avaLaud = new Stage();
		new StartPage(avaLaud); //uus objekt startPage klassist millele on stage kaasa antud
		avaLaud.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
