package dungeon;
public class HealingPotion extends Potion {
	private int healPoints = 0;
	
	public HealingPotion(int healingPoints) {
		super("Healing Potion");
		if (healingPoints <= 0) {
			throw new IllegalArgumentException("healingPoints is zero or negative");
		}
		healPoints = healingPoints;
	}
	
	@Override
	public void affectCharacter(DungeonCharacter c) {
		c.addHitPoints(healPoints);
		System.out.println("You drank a healing potion. Your new HP is " + c.getHitPoints());
	}
}
