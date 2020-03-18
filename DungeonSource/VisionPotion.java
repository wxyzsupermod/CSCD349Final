public class VisionPotion extends Potion{
	public void printVisionPotion(int centerX, int centerY) {
		DungeonAdventure.printRooms(centerX-1, centerY-1, centerX+1, centerY+1);
	}
	
	@Override
	public void affectCharacter(DungeonCharacter c) {
		Hero hero = (Hero) c;
		if (hero != null) {
			System.out.println("You drank the vision potion, and now you can see the rooms surrounding you.");
			printVisionPotion(hero.getPosX(), hero.getPosY());
		}
	}
}
