import java.util.Scanner;

public class Dungeon
{
	private static Scanner Keyboard = new Scanner(System.in);
    public static void main(String[] args)
	{
		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method


	public static Hero chooseHero()
	{
		int choice;
		HeroFactory factory = new HeroFactory();

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = Keyboard.nextInt();

		if(choice == 1) {
			return factory.createHero(1);
		}
		
		else if(choice == 2) {
			return factory.createHero(2);
		}
		
		else {
			return factory.createHero(3);
		}

	}//end chooseHero method

	public static Monster generateMonster()
	{
		int choice;
		MonsterFactory factory = new MonsterFactory();

		choice = (int)(Math.random() * 3) + 1;
		
		if(choice == 1) {
			return factory.createMonster(1);
		}
		
		else if(choice == 2) {
			return factory.createMonster(2);
		}
		
		else {
			return factory.createMonster(3);
		}

	}//end generateMonster method


	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.next().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method


	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.next().charAt(0);

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}//end Dungeon class