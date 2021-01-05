package zombie;

import action.ZombieAction;
import drawing.Screen;
import item.Item;

public class Zombie implements ZombieAction {
	protected String name;
	protected int hp;
	protected int speed;
	protected int attack;
	protected int x;
	protected int y;
	protected boolean walking = true;
	protected boolean dead = false;
	public Zombie(String name,int hp,int speed,int attack) {
		this.name = name;
		this.attack = attack;
		this.speed = speed;
		this.hp = hp;
	}

	@Override
	public void doDamage(Item item) {
		// TODO Auto-generated method stub
		item.receiveDamage(this.attack);
		walking = false;
	}

	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
		this.hp-=damage;
		if(this.hp <= 0) {
			Screen.getInstance().getTopBar().getScoreBoard().setScore(10);
			dead = true;
		}
		
	}
	public void walk() {
		if(walking) {
			x = x-speed;
		}
	}
	
	public void xspeed(int xspeed) {
		this.speed= xspeed;
	}

	public int getX() {
		return x;
	}

	public void setX(int d) {
		this.x = d;
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

	public int getHp() {
		return hp;
	}

	public boolean isWalking() {
		return walking;
	}

	public void setWalking(boolean walking) {
		this.walking = walking;
	}

	public boolean isDead() {
		return dead;
	}
	
}
