package dungeon;
public class Hands implements Attack{
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " Smacks You " + opponent.getName());
		opponent.subtractHitPoints(2);
	}
}
