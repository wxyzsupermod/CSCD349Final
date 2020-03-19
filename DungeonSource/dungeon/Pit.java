package dungeon;
public class Pit extends DungeonEntity {
	private int damageDone;
	
	public Pit(int damageDone) {
		super("This is SPARTA");
		this.setDamageDone(damageDone);
	}
	
	public void damageCharacter(DungeonCharacter c) {
		System.out.println(c.getName() + " fell down a pit!");
		Hero hero = (Hero) c;
		if (hero != null) {
			hero.subtractHitPoints(damageDone, false);
		} else {
			c.subtractHitPoints(damageDone);
		}
	}

	public int getDamageDone() {
		return damageDone;
	}

	public void setDamageDone(int damageDone) {
		this.damageDone = damageDone;
	}
}
