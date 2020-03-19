package dungeon;

public class RoomFactory {
	
	public Room createRoom(int x, int y) {
		Room room = new Room(x, y);
		room.fill();
		return room;
	}
	
}
