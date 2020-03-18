public abstract class DungeonEntity {
	private String name;
	private int posX, posY;
	
	public DungeonEntity(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name is empty");
		}
		this.name = name;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	void visitRoom(Room room) {
		setPosX(room.x);
		setPosY(room.y);
	}
	
	public Room moveTo(int x, int y) {
		Dungeon d = DungeonAdventure.getDungeon();
		if(d.locationIsValid(y, x)) {
			Room room = d.getRoom(y, x);
			visitRoom(room);
			return room;
		}
		return null;
	}
	
	public Room moveRight() {
		return moveTo(posX+1, posY);
	}
	
	public Room moveLeft() {
		return moveTo(posX-1, posY);
	}

	public Room moveUp() {
		return moveTo(posX, posY-1);
	}

	public Room moveDown() {
		return moveTo(posX, posY+1);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
