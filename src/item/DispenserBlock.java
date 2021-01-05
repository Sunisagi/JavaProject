package item;

import action.AmmoandItemAction;
import ammo.Ammo;
import ammo.Arrow;
import ammo.SnowBall;
import gui.Field;

public class DispenserBlock extends Item implements AmmoandItemAction {
	
	private final static int DispenserDurability = 1000;
	private Ammo ammo;
	private int turn;
	

	public DispenserBlock(String name,Ammo ammo) {
		super(DispenserDurability, name);
		this.ammo=ammo;
		this.turn = 0;
		// TODO Auto-generated constructor stub
	}
	
	public void shootAmmo() {
		turn++;
		if(turn%60==0){
			Ammo newAmmo;
			if(ammo instanceof Arrow) {
				newAmmo = new Arrow();
			}else {
				 newAmmo = new SnowBall();
			}
			newAmmo.setX(x+80);
			newAmmo.setY(y+25);
			Field.getInstance().addAmmo(newAmmo);
		}
				
	}
	

}
