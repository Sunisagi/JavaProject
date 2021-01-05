package gui;

import java.util.ArrayList;
import java.util.List;

import ammo.Ammo;
import ammo.Arrow;
import ammo.SnowBall;
import application.GameScreen;
import drawing.Screen;
import item.DispenserBlock;
import item.Item;
import item.LavaBlock;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.Encounter;
import logic.RandomZombie;
import sharedObject.RenderableHolder;
import zombie.NormalZom;
import zombie.Pigman;
import zombie.Zombie;

public class Field extends Canvas{
	private int[] rows;
	private int[] columns;
	private List<Ammo> ammoOnField = new ArrayList<Ammo>();
	private List<List<Item>> itemOnField = new ArrayList<List<Item>>();
	private List<List<Zombie>> zombieOnField = new ArrayList<List<Zombie>>();
	private GraphicsContext gc = getGraphicsContext2D();
	private RandomZombie randomZombie = new RandomZombie();
	private Encounter counter = new Encounter();
	
	private static final Field instance = new Field();
	
	public Field() {
		super(800,491);
		this.setrow();
		this.setcolumn();
		this.setVisible(true);
		this.setItemOnField();
		this.setZombieOnField();
	}

	private void setrow() {
		rows = new int[6];
		rows[0] = 15;
		rows[1] = 108;
		rows[2] = 206;
		rows[3] = 304;
		rows[4] = 402;
		rows[5] = 500;
		
	}
	
	private void setcolumn() {
		columns = new int[10];
		columns[0] = 5;
		columns[1] = 98;
		columns[2] = 186;
		columns[3] = 274;
		columns[4] = 362;
		columns[5] = 457;
		columns[6] = 545;
		columns[7] = 633;
		columns[8] = 721;
		columns[9] = 810;
	}
	
	private void setItemOnField() {
		for(int i=0;i<rows.length;i++) {
			List<Item> item = new ArrayList<Item>();
			for(int j=0;j<columns.length-1;j++) {
				item.add(null);
			}
			itemOnField.add(item);
		}
	}
	
	private void setZombieOnField() {
		for(int i=0;i<rows.length-1;i++) {
			zombieOnField.add(new ArrayList<Zombie>());
		}
	}
	
	public int findRows(double y) {
		for(int i=1;i<rows.length;i++) {
			if((y>=rows[i-1]) && (y<rows[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public int findColumns(double x) {
		for(int i=1;i<columns.length;i++) {
			if(x>=columns[i-1] && x<columns[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean hasItem(int x,int y) {
		y = findRows(y);
		x = findColumns(x);
		if (itemOnField.get(y).get(x) == null) {
			return false;
		}
		return true;
	}
	
	public boolean setItem(int x,int y,Item item) {
		if(!hasItem(x,y)){
			y = findRows(y);
			x = findColumns(x);
			item.setX(columns[x-1]);
			item.setY(rows[y-1]);
			itemOnField.get(y).set(x, item);
			RenderableHolder.stone.play();
			return true;
		}else if(item == null) {
			y = findRows(y);
			x = findColumns(x);
			itemOnField.get(y).set(x, item);
		}
		return false;
	}
	
	public Item cardToItem(String name) {
		if(name == "Lava Block"){
			return new LavaBlock();
		}
		if(name =="ArrowDispenser") {
			return new DispenserBlock("ArrowDispenser",new Arrow());
		}
		if(name == "SnowDispenser") {
			return new DispenserBlock("SnowDispenser",new SnowBall());
		}
		return null;
	}
	
	public void setZombie() {
		int n = Screen.getInstance().getTopBar().getScoreBoard().level();
		Zombie zombie = randomZombie.zombieOut(n);
		if(zombie != null) {
			int row = randomZombie.RandomRow();
			zombie.setX(columns[9]);
			zombie.setY(rows[row]);
			zombieOnField.get(row).add(zombie);
			RenderableHolder.zombie.play();
		}
	}
	
	public void addAmmo(Ammo ammo) {
		ammoOnField.add(ammo);
	}
	
	public void Update() {
		//gc.clearRect(0, 0, 800, 491);
		gc.drawImage(RenderableHolder.field,0,0);
		setZombie();
		counter.checkHit();
		for(int i=0;i<itemOnField.size();i++) {
			for(int j=0;j<itemOnField.get(i).size();j++) {
				if(itemOnField.get(i).get(j) != null){
					if(itemOnField.get(i).get(j) instanceof LavaBlock) {
						gc.drawImage(RenderableHolder.lava,columns[j-1], rows[i-1]);
					}
					if(itemOnField.get(i).get(j) instanceof DispenserBlock) {
						gc.drawImage(RenderableHolder.dispenser,columns[j-1], rows[i-1]);
						((DispenserBlock) itemOnField.get(i).get(j)).shootAmmo();
					}
				}
			}
		}
		for(Ammo ammo : ammoOnField) {
			ammo.setX(ammo.getX()+ammo.getSpeed());
			if(ammo instanceof Arrow) {
				gc.drawImage(RenderableHolder.arrow, ammo.getX(), ammo.getY());
			}
			if(ammo instanceof SnowBall) {
				gc.drawImage(RenderableHolder.snowBall, ammo.getX(), ammo.getY());
			}
		}
		
		for(int i=0;i<zombieOnField.size();i++) {
			for(Zombie zombie : zombieOnField.get(i)) {
				zombie.walk();
				if(zombie.getX()<=0) GameScreen.lose();
				if(zombie instanceof NormalZom) {
					gc.drawImage(RenderableHolder.normalZombie, zombie.getX(), zombie.getY());
				}
				if(zombie instanceof Pigman) {
					gc.drawImage(RenderableHolder.pigMan, zombie.getX(), zombie.getY());
				}
			}
		}
		
	}
	public GraphicsContext getGc() {
		return gc;
	}

	public int[] getRows() {
		return rows;
	}

	public int[] getColumns() {
		return columns;
	}
	
	public List<Ammo> getAmmoOnField() {
		return ammoOnField;
	}
	
	public List<List<Item>> getItemOnField() {
		return itemOnField;
	}
	
	
	public List<List<Zombie>> getZombieOnField() {
		return zombieOnField;
	}
	
	public Zombie getZombie(int x,int y) {
		
		x = findColumns(x);
		y = findRows(y);
		return zombieOnField.get(y).get(x);
	}
	
	public Item getItem(int row,int column) {
		return itemOnField.get(row).get(column);
	}

	public static Field getInstance() {
		return instance;
	}

	public Encounter getCounter() {
		return counter;
	}
	
}
