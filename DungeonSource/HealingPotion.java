import java.util.Random;

public class HealingPotion extends Potion {
	private int healPoints = 0;
	
	public HealingPotion() {
		healPoints = new Random().nextInt(11) + 5;
	}
	
	@Override
	public void affectCharacter(DungeonCharacter c) {
		c.addHitPoints(healPoints);
		System.out.println("You drank a healing potion. Your new HP is " + c.getHitPoints());
	}
}