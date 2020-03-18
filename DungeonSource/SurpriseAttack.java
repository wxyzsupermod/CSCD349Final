public class SurpriseAttack implements Attack {
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!");
			Hero hero = (Hero) attacker;
			if (hero != null) {
				hero.getExtraTurn();
				opponent.subtractHitPoints(30);
			}
		} else if (surprise >= .9) {
			System.out.println(opponent.getName() + " saw you and blocked your attack!");
		} else {
			System.out.println("Surprise attack failed!");
			opponent.subtractHitPoints(10);
		}
	}
}
