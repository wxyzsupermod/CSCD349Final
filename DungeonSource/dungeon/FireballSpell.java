package dungeon;
public class FireballSpell implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " casts a fireball spell at " + opponent.getName());
		opponent.subtractHitPoints(25);
	}
}
