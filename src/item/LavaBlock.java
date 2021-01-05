package item;

import action.AmmoandItemAction;
import gui.Field;
import zombie.Zombie;

public class LavaBlock extends Item implements AmmoandItemAction {

	private final static int LavaBlockDurability = 10;
	private final static String LavaBlockName = "Lava Block";
	private final static int LavaBlockDamage = 100;
	private int damage;
	
	public LavaBlock() {
		super(LavaBlockDurability, LavaBlockName);
		this.damage=LavaBlockDamage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doDamage(int rows,int idx) {
		// TODO Auto-generated method stub
		Field.getInstance().getZombieOnField().get(rows).get(idx).receiveDamage(this.damage);
		receiveDamage(1);
	}
	
	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
		if (damage!=1) {
			damage=0;
		}
		this.durability-=damage;
		if (durability<=0) {
			Field.getInstance().setItem(x, y, null);
		}
	}

}
