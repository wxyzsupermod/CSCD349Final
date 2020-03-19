package dungeon;

public class CrushingBlow implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		if (Math.random() <= 0.4d) {
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		} else {
			System.out.println(attacker.getName() + " failed to land a crushing blow");
		}
	}
}
