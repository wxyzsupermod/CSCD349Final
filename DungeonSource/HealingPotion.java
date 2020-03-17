import java.util.Random;

public class HealingPotion extends Potion {
	private int healPoints = 0;
	
	public HealingPotion() {
		this.setHealPoints(this.getHealPoints() + new Random().nextInt(15 - 5 + 1));
	}

	public int getHealPoints() {
		return healPoints;
	}

	public void setHealPoints(int healPoints) {
		this.healPoints = healPoints;
	}
	
	@Override
	public void affectCharacter(DungeonCharacter c) {
		c.addHitPoints(healPoints);
	}
}
