/*Melody Kinyon
 * Corbin Smith
 * Yousef Baghlar
 * Jordan Fischer
 * GamePlay: The player is asked to choose and name their hero
 * The hidden menu option is lucky number 7, this displays the 
 * entire dungeon.
 * The player is placed at the entrance of the dungeon
 * then they get to move right or down.
 * From there they are moved and depending if they have a potion or not, get asked to move 
 * or use potion, then which direction they want to move. 
 * The game ends when the hero dies, or reaches the end.
 * If the player does not wish to play again the dungeon is printed.
 * 
 *  
 */

import java.util.Scanner;

public class DungeonAdventure
{
	private static Scanner Keyboard = new Scanner(System.in);
    private static Dungeon dungeon;
	public static void main(String[] args)
	{
    	Scanner kb = new Scanner(System.in);
		Hero theHero = null;
		Monster theMonster;
		char decision;
		do
		{
		    int option = displayMenu(kb);
			if(option != 7) {
				theHero = chooseHero(option);
				theMonster = generateMonster();
				
				//battle(theHero, theMonster);
			} 
			else {
				 printRoom();
				}
			while(theHero.isAlive()) {
				
			dungeon = new Dungeon(5, 5);
			int curRow= 0;
			int curColumn = 0;
			theHero.movePlayer(curRow, curColumn, dungeon);
			System.out.println("Would you like to move your player down or right?"
					+ " (d or r)");
			decision = kb.next().charAt(0);
			
			if(decision == 'd') {
				theHero.movePlayer(curRow, curColumn +1, dungeon);
				System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
				curColumn ++; 
			}
			else if( decision == 'r') {
				theHero.movePlayer(curRow +1, curColumn, dungeon);
				System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
				 curRow++;
			}
			if(theHero.getHealingPotions()!=0) {
				
			
			System.out.println("Use a potion or move? (p or m)");
			decision = kb.next().charAt(0);
			if(decision == 'p') {
				//use potion
				//printVisionPotion(dungeon, curRow, curColumn);
			}
			else if(decision == 'm') {
				System.out.println("Move left, right, up or down?(l,r,u,d)");
				decision = kb.next().charAt(0);
				if(decision == 'l') {
					theHero.movePlayer(curRow -1, curColumn, dungeon);
					System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
					 curRow--;
				}
				else if( decision == 'r') {
					theHero.movePlayer(curRow +1, curColumn, dungeon);
					System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
					 curRow++;
				}
				else if( decision == 'u') {
					theHero.movePlayer(curRow, curColumn-1, dungeon);
					System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
					 curColumn--;
				}
				else if(decision == 'd') {
					theHero.movePlayer(curRow, curColumn +1, dungeon);
					System.out.println("the Current room is " + theHero.getPosX() + " ," + theHero.getPosY());
					 curColumn++;
				}
			}
		}
	}
	} while (playAgain());
		
		System.out.println("This is where we print the whole dungeon at the end");
		printRoom();
		
	}

    private static int displayMenu(Scanner kb)
	{
		
		int choice;
		System.out.println("Please choose a hero from the following options: ");
		System.out.println("1. Warrior ");
		System.out.println("2. Sorceress ");
		System.out.println("3. Thief ");
		System.out.println("4. Elf Wizard ");
		System.out.println("5. Gandalf  ");
		System.out.println("6. Sorcerer ");
		

		choice = kb.nextInt();
		return choice;
	}	

    
	public static Hero chooseHero(int choice)
	{
		HeroFactory factory = new HeroFactory();

		if(choice == 1) {
			return factory.createHero(1);
		}
		
		else if(choice == 2) {
			return factory.createHero(2);
		}
		
		else if(choice == 3) {
			return factory.createHero(3);
		}
		else if(choice == 4){
			return factory.createHero(4);
		}
		else if( choice == 5) {
			return factory.createHero(5);
		}
		else {
			return factory.createHero(6);
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
	
	public static void printRoom() {
		Room[][] rooms = dungeon.getRooms();
	      
	      for(int i =0; i < rooms.length; i++){
	         
	         for(int j = 0; j < rooms[i].length; j++){         
		            rooms[i][j].printTopRow();
		         }
	         System.out.println("*");
	         for(int j = 0; j < rooms[i].length; j++){         
		            rooms[i][j].printMiddleRow();
		         }
	         System.out.println("*");
	         for(int j = 0; j < rooms[i].length; j++){         
		            rooms[i][j].printBottomRow();
		         }
	      }
	      System.out.println("*");
	}

}//end DungeonAdventure class
