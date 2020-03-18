public class Kris implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " jabs his kris at " + opponent.getName());
		opponent.subtractHitPoints(10);
	}
}
