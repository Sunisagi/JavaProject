package application;

import drawing.Screen;
import gui.Field;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sharedObject.RenderableHolder;

public class GameScreen {
	private static Stage stage;
	private static Timeline gameLoop;
	private StackPane root = new StackPane();
	
	public GameScreen(Stage stage) {
		this.stage = stage;
		root.prefHeight(580);
		root.prefWidth(800);
		
		this.stage.setTitle("SteeveVSZombies");
		this.stage.setResizable(false);
		root.getChildren().addAll(Screen.getInstance());
		Scene scene = new Scene(root);
		this.stage.setScene(scene);
		RenderableHolder.zombie.play();
		this.stage.show();
		
		
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.034),
				new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent ae)
					{
						Field.getInstance().Update();
						Screen.getInstance().getTopBar().getScoreBoard().Update();
					}
				});
		
		gameLoop.getKeyFrames().add(kf);
		gameLoop.play();
		
	}

	public static void lose() {
		LoseScreen loseScreen = new LoseScreen(stage);
		RenderableHolder.hurt.play();
		gameLoop.stop();
		
	}

}
	
	
	
	
	
	
