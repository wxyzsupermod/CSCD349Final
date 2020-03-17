import java.util.Scanner;

public class Sorcerer extends Hero{
	private static Scanner Keyboard = new Scanner(System.in);
	public Sorcerer() {
		super("Sorcerer", 140, 8, .5, 55, 75, .6, 90);
	}
	
	public void tornadoSpell(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(this.getName() + " lands a TORNADO SPELL for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(this.getName() + " failed to land a tornado spell");
			System.out.println();
		}//blow failed

	}//end tornadoSpell method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + "  a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Tornado Spell on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.nextInt();

		    if(choice == 1) {
		    	attack(opponent);
		    }
		    
		    else if(choice == 2) {
		    	tornadoSpell(opponent);
		    }
		    
		    else {
		    	System.out.println("invalid choice!");
		    }
		    

			this.setNumTurns(this.getNumTurns()-1);
			if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		} while(this.getNumTurns() > 0);

    }//end battleChoices method
}

