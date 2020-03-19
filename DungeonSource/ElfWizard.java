import java.util.Scanner;

public class ElfWizard extends Hero {
	
	private static Scanner Keyboard = new Scanner(System.in);
	public ElfWizard() {
		super("ElfWizard", 150, 9, .4, 75, 55, .7);
		//need attack in ctr
	}
	
	public void dizzinessSpell(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(this.getName() + " lands a DIZZINESS SPELL for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(this.getName() + " failed to land a dizziness spell");
			System.out.println();
		}//blow failed

	}//end dizzinessSpell method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + "  a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void getTurns(DungeonCharacter opponent)
	{
		int choice;

		super.getTurns(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Dizziness Spell on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.nextInt();

		    if(choice == 1) {
		    	attack(opponent);
		    }
		    
		    else if(choice == 2) {
		    	dizzinessSpell(opponent);
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

