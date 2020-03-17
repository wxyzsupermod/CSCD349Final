import java.util.Random;

public class Dungeon
{
	private Room[][] rooms; // Row-major indexing. So the room at (5, 3) is indexed with rooms[5][3], which coincides with the assignment specification.
	public final int roomsWidth, roomsHeight;
	
	private Room entrance;
	private Room exit;
	
	public Dungeon(int roomsWidth, int roomsHeight) {
		if (roomsWidth * roomsHeight < 6) {
			throw new IllegalArgumentException("There must be at least 6 rooms in the dungeon.");
		}
		this.roomsWidth = roomsWidth;
		this.roomsHeight = roomsHeight;
		reset();
	}
	
	private void reset() {
		generateRooms();
	}
	
	private void generateRooms() {
		RoomFactory factory = new RoomFactory();
		Random rand = new Random();
		rooms = new Room[roomsHeight][];
		for (int i = 0; i < roomsHeight; i ++) {
			rooms[i] = new Room[roomsWidth];
			for (int j = 0; j < roomsWidth; j ++) {
				rooms[i][j] = factory.createRoom(j, i);
			}
		}
		int entranceX = rand.nextInt(roomsWidth);
		int entranceY = rand.nextInt(roomsHeight);
		entrance = rooms[entranceY][entranceX];
		entrance.setEntrance(true);
		exit = rooms[(entranceY+rand.nextInt(roomsHeight-1)+1)%roomsHeight][(entranceX+rand.nextInt(roomsWidth-1)+1)%roomsWidth];
		exit.setExit(true);
	}
	
	public boolean locationIsValid(int i, int j) {
		return i >= 0 && j >= 0 && i < roomsHeight && j < roomsWidth;
	}
	
	public Room getRoom(int i, int j) {
		if (!locationIsValid(i, j)) {
			throw new IllegalArgumentException("The provided location (" + i + ", " + j + ") is invalid.");
		}
		return rooms[i][j];
	}
	
	public Room[][] getRooms() {
		return rooms;
	}
	
	public Room getEntrance() {
		return entrance;
	}

	public Room getExit() {
		return exit;
	}

}
