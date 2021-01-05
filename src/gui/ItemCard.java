package gui;

import java.awt.Color;

import item.LavaBlock;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import sharedObject.RenderableHolder;

public class ItemCard extends Button {
	private String name;
	private Image image;
	private int cooldown;
	private boolean hasCoolDown = false;
	private  Thread thread;
	
	public ItemCard(String name,Image image,int cooldown) {
		this.name = name;
		this.image = image;
		this.cooldown = cooldown;
		this.setPrefWidth(64);
		this.setPrefHeight(90);
		setBackGround();
	}
	
	public void setBackGround() {
		BackgroundImage backBroundImange = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,  BackgroundRepeat.NO_REPEAT,
																BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background background = new Background(backBroundImange);
		this.setBackground(background);
	}
	
	public void coolDownTime(ItemCard itemCard) {
		if (hasCoolDown) {
			thread = new Thread( () -> {
				Image image = itemCard.image;
				for(int i=0;i<cooldown;i++) {
					try {
						
						if(i==cooldown/2) {
							if(itemCard.name == "Lava Block") {
								image = RenderableHolder.lavaCard50;
							}
							else if(itemCard.name == "ArrowDispenser") {
								image = RenderableHolder.arrowDispenserCard50;
							}
							else if(itemCard.name == "SnowDispenser") {
								image = RenderableHolder.snowDispenserCard50;
							}
						}else if(i==0) {
							if(itemCard.name == "Lava Block") {
								image = RenderableHolder.lavaCard100;
							}
							else if(itemCard.name == "ArrowDispenser") {
								image = RenderableHolder.arrowDispenserCard100;
							}
							else if(itemCard.name == "SnowDispenser") {
								image = RenderableHolder.snowDispenserCard100;
							}
						}else if(i==cooldown/4) {
							if(itemCard.name == "Lava Block") {
								image = RenderableHolder.lavaCard75;
							}
							else if(itemCard.name == "ArrowDispenser") {
								image = RenderableHolder.arrowDispenserCard75;
							}
							else if(itemCard.name == "SnowDispenser") {
								image = RenderableHolder.snowDispenserCard75;
							}
						}else if(i==(cooldown/4+cooldown/2)) {
							if(itemCard.name == "Lava Block") {
								image = RenderableHolder.lavaCard25;
							}
							else if(itemCard.name == "ArrowDispenser") {
								image = RenderableHolder.arrowDispenserCard25;
							}
							else if(itemCard.name == "SnowDispenser") {
								image = RenderableHolder.snowDispenserCard25;
							}
						}
						BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,  BackgroundRepeat.NO_REPEAT,
																BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
						Background background = new Background(backgroundImage);
						itemCard.setBackground(background);
						thread.sleep(1000);
						if(i == cooldown-1) {
							hasCoolDown = false;
							coolDownTime(itemCard);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
			
			
		}
		else {
			itemCard.setBackGround();
		}
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public boolean getHasCoolDown() {
		return hasCoolDown;
	}

	public void setHasCoolDown(boolean hasCoolDown) {
		this.hasCoolDown = hasCoolDown;
	}
	
}
