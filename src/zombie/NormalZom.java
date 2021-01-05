package zombie;

import action.ZombieAction;

public class NormalZom extends Zombie implements ZombieAction {
	
	private final static String NormalZomName = "Normal Zombie";
	private final static int NormalZomHp = 1000;
	private final static int NormalZomSpeed = 2;
	private final static int NormalZomAttack = 50;

	public NormalZom() {
		super(NormalZomName, NormalZomHp, NormalZomSpeed, NormalZomAttack);
	}
	
}
