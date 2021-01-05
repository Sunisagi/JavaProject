package ammo;

import action.AmmoandItemAction;
import gui.Field;
import zombie.Zombie;

public class Arrow extends Ammo implements AmmoandItemAction {
	
	private final static String ArrowName = "Arrow";
	private final static int ArrowDamage = 200;
	private final static int ArrowSpeed = 2;
	private int damage = ArrowDamage;

	public Arrow() {
		super(ArrowDamage, ArrowName, ArrowSpeed);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
	}


	@Override
	public void doDamage(int rows, int idx) {
		Field.getInstance().getZombieOnField().get(rows).get(idx).receiveDamage(this.damage);
		
	}
	
	

}
