

public class Dungeon
{
	private Room[][] rooms; // Row-major indexing. So the room at (5, 3) is indexed with rooms[5][3], which coincides with the assignment specification.
	private final int roomsWidth, roomsHeight;
	
	private Entrance entrance;
	private Exit exit;
	
	public Dungeon(int roomsWidth, int roomsHeight) {
		if (roomsWidth * roomsHeight < 4) {
			throw new IllegalArgumentException("There must be at least 4 rooms in the dungeon.");
		}
		this.roomsWidth = roomsWidth;
		this.roomsHeight = roomsHeight;
		reset();
	}
	
	private void reset() { // Clear the state of the game, 
		generateRooms();
	}
	
	private void generateRooms() {
		RoomFactory factory = new RoomFactory();
		entrance = new Entrance();
		exit = new Exit();
		rooms = new Room[roomsHeight][];
		for (int i = 0; i < roomsHeight; i ++) {
			rooms[i] = new Room[roomsWidth];
			for (int j = 0; j < roomsWidth; j ++) {
				rooms[i][j] = factory.createRoom(j, i);
				if (i == 0 && j == 0) {
					rooms[i][j].setEntrance (entrance);
					System.out.println("Add entrance");
				} else if (i == 4 && j == 4) {
					rooms[i][j].setExit (exit);
					System.out.println("Add exit");
				}
			}
		}
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
	
}
