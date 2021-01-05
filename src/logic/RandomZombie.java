package logic;

import java.util.Random;

import zombie.NormalZom;
import zombie.Pigman;
import zombie.Zombie;

public class RandomZombie {
	private Random random = new Random();
	
	public int RandomRow() {
		return random.nextInt(5);
	}
	
	public Zombie getZombieType() {
		if( random.nextInt(5) == 0) {
			return new Pigman();
		}
		return new NormalZom();
	}
	
	public Zombie zombieOut(int n) {
		if(random.nextInt(n) == 0) {
			return getZombieType();
		}
		else {
			return null;
		}
		
	}
}
