import java.lang.Math;
public class VisionPotion {
	public VisionPotion(){}
	public void printVisionPotion(Room[][] rooms, int posX, int posY) {
		for(int x = 0; x < rooms.length; x++) {
			for(int y = 0; y < rooms.length; y++) {
				if(Math.abs(posX - x) > 1 || Math.abs(posY - y) > 1) {
					if(posX - 1 < 0) {
						if(posY - 1 < 0) {
							//top left corner
							System.out.println(rooms[posX][posY].toString());
							System.out.println(rooms[posX + 1][posY].toString());
							System.out.println(rooms[posX + 1][posY + 1].toString());
							System.out.println(rooms[posX][posY + 1].toString());
						}
						else if(posY + 1 > rooms[5].length) {
							//bottom left corner
							System.out.println(rooms[posX][posY].toString());
							System.out.println(rooms[posX + 1][posY].toString());
							System.out.println(rooms[posX + 1][posY - 1].toString());
							System.out.println(rooms[posX][posY - 1].toString());
						}
						//against left wall
						else {
						System.out.println(rooms[posX][posY].toString());
						System.out.println(rooms[posX + 1][posY].toString());
						System.out.println(rooms[posX + 1][posY + 1].toString());
						System.out.println(rooms[posX][posY + 1].toString());
						System.out.println(rooms[posX + 1][posY - 1].toString());
						System.out.println(rooms[posX][posY - 1].toString());
						}
					}
					else if(posX + 1 > rooms.length) {
						if(posY - 1 < 0) {
							//top right corner
							System.out.println(rooms[posX][posY].toString());
							System.out.println(rooms[posX - 1][posY].toString());
							System.out.println(rooms[posX][posY + 1].toString());
							System.out.println(rooms[posX - 1][posY + 1].toString());
						}
						else if(posY + 1 > rooms[5].length) {
							//bottom right corner
							System.out.println(rooms[posX][posY].toString());
							System.out.println(rooms[posX - 1][posY].toString());
							System.out.println(rooms[posX - 1][posY - 1].toString());
							System.out.println(rooms[posX][posY - 1].toString());
						}
						//against right wall
						else {
						System.out.println(rooms[posX][posY].toString());
						System.out.println(rooms[posX][posY - 1].toString());
						System.out.println(rooms[posX][posY + 1].toString());
						System.out.println(rooms[posX - 1][posY].toString());
						System.out.println(rooms[posX - 1][posY - 1].toString());
						System.out.println(rooms[posX - 1][posY + 1].toString());
						}
					}
					else if(posY + 1 > rooms[5].length) {
						//agaisnt bottom wall
						System.out.println(rooms[posX][posY].toString());
						System.out.println(rooms[posX - 1][posY].toString());
						System.out.println(rooms[posX - 1][posY - 1].toString());
						System.out.println(rooms[posX][posY - 1].toString());
						System.out.println(rooms[posX + 1][posY - 1].toString());
						System.out.println(rooms[posX + 1][posY].toString());
					}
					else if(posY - 1 < 0) {
						//against top wall
						System.out.println(rooms[posX][posY].toString());
						System.out.println(rooms[posX - 1][posY].toString());
						System.out.println(rooms[posX + 1][posY].toString());
						System.out.println(rooms[posX - 1][posY + 1].toString());
						System.out.println(rooms[posX + 1][posY + 1].toString());
						System.out.println(rooms[posX][posY + 1].toString());
					}
					else {
						System.out.println(rooms[posX][posY].toString());
						System.out.println(rooms[posX][posY + 1].toString());
						System.out.println(rooms[posX][posY - 1].toString());
						System.out.println(rooms[posX - 1][posY].toString());
						System.out.println(rooms[posX - 1][posY + 1].toString());
						System.out.println(rooms[posX - 1][posY - 1].toString());
						System.out.println(rooms[posX + 1][posY].toString());
						System.out.println(rooms[posX + 1][posY + 1].toString());
						System.out.println(rooms[posX + 1][posY - 1].toString());
					}
				}
				else
					System.out.println("*");
			}
			System.out.println();
		}
	}
}
