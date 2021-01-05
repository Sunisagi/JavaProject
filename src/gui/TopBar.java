package gui;

import javafx.scene.layout.HBox;

public class TopBar extends HBox{
	private ItemBar itemBar = new ItemBar();
	private Score scoreBoard = new Score();
	
	public TopBar() {
		this.getChildren().addAll(itemBar,scoreBoard);
	}

	public ItemBar getItemBar() {
		return itemBar;
	}
	
	public Score getScoreBoard() {
		return scoreBoard;
	}

	public void setScoreBoard(Score scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	
}
