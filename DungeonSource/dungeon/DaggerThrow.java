package dungeon;
public class DaggerThrow implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " throws daggers at " + opponent.getName());
		opponent.subtractHitPoints(25);
	}
}
