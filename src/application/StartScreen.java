package application;

import drawing.Screen;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

public class StartScreen{
	private Button start = new Button();
	private Stage stage;
	private StackPane root = new StackPane();
	
	public StartScreen(Stage stage) {
		this.stage = stage;
		root.prefHeight(580);
		root.prefWidth(800);
		start.setFont(new Font(25));
		start.setText("Start");
		start.setPrefWidth(100);
		
		this.stage.setTitle("SteeveVSZombies");
		this.stage.setResizable(false);
		this.setBackground();
		root.getChildren().add(start);
		root.setAlignment(Pos.CENTER);
		this.setHandle();
		Scene scene = new Scene(root);
		this.stage.setScene(scene);
		
	}
	
	public void setBackground() {
		RenderableHolder.getInstance();
		ImageView imageview = new ImageView(RenderableHolder.startBackground);
		root.getChildren().add(imageview);
	}
	
	public void setHandle() {
		start.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				GameScreen gamescreen = new GameScreen(stage);
				
			}
		});
	}
}
	

