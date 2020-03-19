package dungeon;
public class RustyBlade implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		System.out.println(attacker.getName() + " slices a rusty blade at " + opponent.getName());
		opponent.subtractHitPoints(15);
	}
}
