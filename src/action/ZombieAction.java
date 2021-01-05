package action;

import item.Item;

public interface ZombieAction {
	public void doDamage(Item item);
	public void receiveDamage(int damage);
}
