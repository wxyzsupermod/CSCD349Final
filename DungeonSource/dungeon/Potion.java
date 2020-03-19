package dungeon;

public abstract class Potion extends DungeonEntity {
	
	public abstract void affectCharacter(DungeonCharacter c);
	
	public Potion(String name) {
		super(name);
	}
	
}
