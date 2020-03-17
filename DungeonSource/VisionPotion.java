import java.lang.Math;
public class VisionPotion extends Potion{
	// Problem is that you are printing the things correctly but not actually printing the
	// array correctly so try to print the array and check if the values are in the correct range to be shown
	// then and only then can you print the room
	public VisionPotion(){}
	public void affectCharacter(DungeonCharacter c) {
		
	}
	public void printVisionPotion(Room[][] rooms, int posY, int posX) {
		for(int x = 0; x < rooms.length; x++) {
			for(int y = 0; y < rooms.length; y++) {
				if(Math.abs(posX - x) <= 1 && Math.abs(posY - y) <= 1) {
					if(x == posX && y == posY) {
						System.out.printf("%-5s", " @ ");
					}
					else {
						System.out.printf("%-5s", rooms[x][y].toString());
					}
				}
				else {
					System.out.printf("%-5s", " * ");
				}
			}
			System.out.println();
		}
	}
}
