import java.util.Scanner;

public class Gandalf extends Hero {
	
	private static Scanner Keyboard = new Scanner(System.in);

	public Gandalf() {
		super("Gandalf the Great", 130, 5, .7, 45, 70, .5);
	}
	
	public void iceSpell(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(this.getName() + " lands an ICE SPELL for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(this.getName() + " failed to land an ice spell");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

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
		    System.out.println("2. Ice Spell on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.nextInt();

		    if(choice == 1) {
		    	attack(opponent);
		    }
		    
		    else if(choice == 2) {
		    	iceSpell(opponent);
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
