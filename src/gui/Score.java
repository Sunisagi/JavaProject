package gui;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Score extends Label{
	private int score=0;
	
	public Score() {
		this.setPrefHeight(99);
		this.setPrefWidth(338);
		this.setFont(new Font(30));
		this.setBackground(Color.BLACK);
	}
	public void setBackground(Color color) {
		BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		this.setBackground(background);
	}
	
	public int level() {
		if(score >= 250)return 10;
		else if(score >= 200)return 30;
		else if(score >= 150)return 50;
		else if(score >= 100)return 100;
		else return 200;
	}
	
	public void Update() {
		String score = Integer.toString(this.score);
		this.setText(score);
		this.setTextFill(Color.WHITE);
		this.setAlignment(Pos.CENTER_RIGHT);
	}
	
	public int getScore() {
		return score;
	}	
	
	public void setScore(int score) {
		this.score += score;
	}
	
}
