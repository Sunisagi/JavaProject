package item;

import action.AmmoandItemAction;
import gui.Field;
import sharedObject.RenderableHolder;
import zombie.Zombie;

public class Item implements AmmoandItemAction {
	protected int durability;
	protected String name;
	protected int x,y;
	
	public Item(int durability, String name) {
		this.name = name;
		this.durability = durability;
	}
	
	@Override
	public void doDamage(int rows,int idx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
		this.durability-=damage;
		if (durability<=0) {
			Field.getInstance().setItem(x, y, null);
			RenderableHolder.stone.play();
		}
	}

	public String getName() {
		return this.name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
