package ammo;

import action.AmmoandItemAction;
import gui.Field;
import zombie.Zombie;

public class SnowBall extends Ammo implements AmmoandItemAction {
	
	private final static String SnowBallName = "Snow Ball";
	private final static int SnowBallDamage = 100;
	private final static int SnowBallXslow = 1;
	private final static int SnowBallSpeed = 1;
	private int xslow = SnowBallXslow;

	public SnowBall() {
		super(SnowBallDamage, SnowBallName, SnowBallSpeed);
		this.xslow=SnowBallXslow;
		speed = SnowBallSpeed;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doDamage(int rows, int idx) {
		Field.getInstance().getZombieOnField().get(rows).get(idx).receiveDamage(this.damage);
		Field.getInstance().getZombieOnField().get(rows).get(idx).xspeed(this.xslow);
		
	}

	@Override
	public void receiveDamage(int damage) {
		// TODO Auto-generated method stub
		
	}
	

}
