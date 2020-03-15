import java.util.Random;

public class Pit extends DungeonEntity{
	private int damageDone;
	
	public Pit() {
		this.setChangeInHealth(new Random().nextInt(25 - 10) + 1);
      this.setName("Pit");
	}
}
