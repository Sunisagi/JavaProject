package gui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import sharedObject.RenderableHolder;

public class ItemBar extends HBox{
	private final static int LavaCoolDown = 10;
	private final static int ArrowCoolDown = 5;
	private final static int SnowCoolDown = 5;
	private ItemCard lavaCard;
	private ItemCard arrowDispenserCard;
	private ItemCard snowDispenserCard;
	
	public ItemBar() {
		lavaCard = new ItemCard("Lava Block",RenderableHolder.lavaCard,LavaCoolDown);
		arrowDispenserCard = new ItemCard("ArrowDispenser",RenderableHolder.arrowDispenserCard, ArrowCoolDown);
		snowDispenserCard = new ItemCard("SnowDispenser",RenderableHolder.snowDispenserCard,SnowCoolDown);
		this.setPrefSize(462, 99);
		this.setSpacing(5);
		this.setPadding(new Insets(0,10,0,0));
		this.getChildren().addAll(arrowDispenserCard,snowDispenserCard,lavaCard);
		setBackGround();
	}

	public void setBackGround() {
		BackgroundImage backBroundImange = new BackgroundImage(RenderableHolder.getInstance().itemBar, BackgroundRepeat.NO_REPEAT,  BackgroundRepeat.NO_REPEAT,
																BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background background = new Background(backBroundImange);
		this.setBackground(background);
		
	}

	public ItemCard getLavaCard() {
		return lavaCard;
	}

	public ItemCard getArrowDispenserCard() {
		return arrowDispenserCard;
	}
	
	public ItemCard getSnowDispenserCard() {
		return snowDispenserCard;
	}
	
	
	
}
