package application;



import javafx.util.Duration;

import drawing.Screen;
import gui.Field;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Encounter;


public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	@Override
	public void start(Stage stage) throws Exception{
		StartScreen startScreen = new StartScreen(stage);
		stage.show();

	}
	@Override
	public void stop() throws Exception {
		super.stop();
	}

}
