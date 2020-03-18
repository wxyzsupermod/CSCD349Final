
public class IncreaseHitPoints implements Attack {
	private static final int MIN_ADD = 25;
	private static final int MAX_ADD = 50;
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
	    int hPoints;
		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		attacker.addHitPoints(hPoints);
		System.out.println(attacker.getName() + " gained " + hPoints + " points.");
		System.out.println("Total hit points remaining are: " + attacker.getHitPoints());
	}
}
