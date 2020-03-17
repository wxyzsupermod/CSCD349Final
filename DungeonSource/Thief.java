import java.util.Scanner;

public class Thief extends Hero
{
	private static Scanner Keyboard = new Scanner(System.in);

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);



    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								this.getName() + " gets an additional turn.");
			this.setNumTurns(this.getNumTurns() + 1);
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.nextInt();
		    
		    if(choice == 1) {
		    	attack(opponent);
		    }
		    
		    else if(choice == 2) {
		    	surpriseAttack(opponent);
		    }
		    
		    else {
		    	System.out.println("invalid choice!");
		    }

			this.setNumTurns(this.getNumTurns() - 1);
			if (this.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + this.getNumTurns());

		} while(this.getNumTurns() > 0);

    }
}