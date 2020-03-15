import java.lang.Math;
public class VisionPotion {
	// Problem is that you are printing the things correctly but not actually printing the
	// array correctly so try to print the array and check if the values are in the correct range to be shown
	// then and only then can you print the room
	public VisionPotion(){}
	public void printVisionPotion(Room[][] rooms, int posX, int posY) {
		for(int x = 0; x < rooms.length; x++) {
			for(int y = 0; y < rooms.length; y++) {
				System.out.print(rooms[x][y]);
			}
			System.out.println();
		}
	}
}
