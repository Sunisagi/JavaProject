package application;

import drawing.Screen;
import gui.Score;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

public class LoseScreen {
	private Stage stage;
	private Label score = new Label();
	private Label youLose = new Label();
	private StackPane root = new StackPane();
	
	public LoseScreen(Stage stage) {
		this.stage = stage;
		root.prefHeight(580);
		root.prefWidth(800);
		
		int point = Screen.getInstance().getTopBar().getScoreBoard().getScore();
		score.setFont(new Font(30));
		String score0 = Integer.toString(point);
		score.setText("score : "+ score0);
		BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		score.setBackground(background);
		
		youLose.setFont(new Font(50));
		youLose.setText("Game Over");
		youLose.setTextFill(Color.WHITE);
		this.setBackground();
		HBox hbox = new HBox();
		root.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(10);
		hbox.getChildren().addAll(youLose,score);
		root.getChildren().add(hbox);
		//this.setHandle();
		
		
		Scene scene = new Scene(root);
		this.stage.setScene(scene);
		
	}
	
	public void setBackground() {
		RenderableHolder.getInstance();
		ImageView imageview = new ImageView(RenderableHolder.loseScene);
		root.getChildren().add(imageview);
	}
	
	//public void setHandle() {
		/*mainMenu.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				StartScreen startscreen = new StartScreen(stage);
				
			}
		});*/
	//}
	
	
}
