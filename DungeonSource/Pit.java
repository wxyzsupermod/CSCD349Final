import java.util.Random;

public class Pit {
	private int damageDone;
	
	public Pit() {
		this.setDamageDone(new Random().nextInt(20 - 1 + 1));
	}

	public int getDamageDone() {
		return damageDone;
	}

	public void setDamageDone(int damageDone) {
		this.damageDone = damageDone;
	}
}
