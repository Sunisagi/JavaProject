package ammo;

import action.AmmoandItemAction;
import gui.Field;
import zombie.Zombie;

public abstract class Ammo implements AmmoandItemAction{
	protected int damage;
	protected String name;
	protected int x,y;
	protected int speed;
	
	public Ammo(int damage, String name,int speed) {
		this.name = name;
		this.damage = damage;
		this.speed = speed;
	}
	
	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
	}


	@Override
	public void doDamage(int rows, int idx) {
		
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

	public int getSpeed() {
		return speed;
	}
	
	
}
