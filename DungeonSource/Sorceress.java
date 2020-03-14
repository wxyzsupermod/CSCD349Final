import java.util.Scanner;

public class Sorceress extends Hero
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	private static Scanner Keyboard = new Scanner(System.in);;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


    }//end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(this.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ this.getHitPoints());
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	
	@Override
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.nextInt();
		    
		    
		    if(choice == 1) {
		    	attack(opponent);
		    }
		    
		    else if(choice == 2) {
		    	increaseHitPoints();
		    }
		    
		    else {
		    	System.out.println("invalid choice!");
		    }

			this.setNumTurns(this.getNumTurns() -1);
		    if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		} while(this.getNumTurns() > 0 && this.getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class