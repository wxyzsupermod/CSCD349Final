

public abstract class Monster extends DungeonCharacter
{
	private double chanceToHeal;
	private int minHeal, maxHeal;

	public Monster(String name, int hitPoints, int attackSpeed,
			double chanceToHit, double chanceToHeal,
			int damageMin, int damageMax,
			int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	}

	public void heal(int healPoints) {
		addHitPoints(healPoints);
		System.out.println(this.getName() + " healed for " + healPoints + " hit points.\n");
		System.out.println("Total hit points remaining are: " + this.getHitPoints());
	}

	public void subtractHitPoints(int hitPoints) {
		super.subtractHitPoints(hitPoints);
		if (Math.random() <= chanceToHeal && this.getHitPoints() > 0) {
			heal((int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal);
		}
	}

}
