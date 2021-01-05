package logic;

import java.util.ArrayList;
import java.util.List;

import ammo.Ammo;
import ammo.Arrow;
import ammo.SnowBall;
import gui.Field;
import item.LavaBlock;
import sharedObject.RenderableHolder;
import zombie.Zombie;

public class Encounter {
	private int hitX = 30;
	private int hitY = 40;
	public void checkHit() {
		for(int i=0;i<Field.getInstance().getZombieOnField().size();i++) {
			for(Zombie zombie : Field.getInstance().getZombieOnField().get(i)) {
				int x = zombie.getX();
				int y = zombie.getY();
				x = Field.getInstance().findColumns(x);
				y = Field.getInstance().findRows(y);
				if(x != -1 && x != 9 && y != -1 && Field.getInstance().getItemOnField().get(y).get(x) != null) {
					if(Field.getInstance().getItemOnField().get(y).get(x) instanceof LavaBlock) {
						int idx = Field.getInstance().getZombieOnField().get(i).indexOf(zombie);
						Field.getInstance().getItemOnField().get(y).get(x).doDamage(i,idx);
					}
					else{zombie.doDamage(Field.getInstance().getItemOnField().get(y).get(x));}
				}else zombie.setWalking(true);
				
				int n=Field.getInstance().getAmmoOnField().size();
				List<Ammo> useAmmo = new ArrayList<Ammo>();
				for(int j=0;j<n;j++) {
					Ammo ammo = Field.getInstance().getAmmoOnField().get(j);
					if(ammo.getY()+hitY >zombie.getY() && ammo.getY()-hitY <zombie.getY()
							&& ammo.getX()+hitX >zombie.getX() && ammo.getX()-hitX < zombie.getX()) {
						int idx = Field.getInstance().getZombieOnField().get(i).indexOf(zombie);
						if(ammo instanceof Arrow) {
							((Arrow) ammo).doDamage(i,idx);
							RenderableHolder.zombieHit.play();
						}
						
						if(ammo instanceof SnowBall) {
							((SnowBall) ammo).doDamage(i,idx);
							RenderableHolder.snow.play();
						}
							
						useAmmo.add(ammo);
						
					}
				}
				for(Ammo ammo : useAmmo) {
					Field.getInstance().getAmmoOnField().remove(ammo);
				}
			}
			int n = Field.getInstance().getZombieOnField().get(i).size();
			List<Zombie> deadZombie = new ArrayList<Zombie>();
			for(Zombie zombie : Field.getInstance().getZombieOnField().get(i)) {
				if(zombie.isDead()) {
					deadZombie.add(zombie);
				}
			}
			
			for(Zombie zombie : deadZombie) {
				Field.getInstance().getZombieOnField().get(i).remove(zombie);
				RenderableHolder.pigmanHurt.play();
			}
		}
	}
}
