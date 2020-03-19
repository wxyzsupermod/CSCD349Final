package dungeon;
public class MightySword implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " swings a mighty sword at " + opponent.getName());
		opponent.subtractHitPoints(20);
	}
}
