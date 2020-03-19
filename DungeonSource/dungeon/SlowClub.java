package dungeon;
public class SlowClub implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " slowly swings a club at " + opponent.getName());
		opponent.subtractHitPoints(18);
	}
}
