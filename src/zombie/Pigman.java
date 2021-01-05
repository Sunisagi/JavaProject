package zombie;

import action.ZombieAction;

public class Pigman extends Zombie implements ZombieAction {
	
	private final static String PigmanName = "Pigman";
	private final static int PigmanHp = 1200;
	private final static int PigmanSpeed = 3;
	private final static int PigmanAttack = 100;

	public Pigman() {
		super(PigmanName, PigmanHp, PigmanSpeed, PigmanAttack);
		// TODO Auto-generated constructor stub
	}

}
