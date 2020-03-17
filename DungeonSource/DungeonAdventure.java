/*Melody Kinyon
 * Corbin Smith
 * Yousef Baghlar
 * Jordan Fischer
 * GamePlay: The player is asked to name their hero
 * The player is placed at the entrance of the dungeon
 * then they get to move right or down
 * based on what is in the room: pit- lose points move to another room
 * potion: increase potion number and see if they want to use it
 * then move again if there is a monster:
 * The user is first prompted to choose a hero, then user is
 * asked to name the character. After this the number of rounds is 
 * calculated, and the user gets to choose between an attack or increasing
 * his own hitPoints. Based on the choice the battle occurs for the 
 * number of rounds specified and then the user is asked to quit or 
 * continue, if they quit a message is printed, and they are prompted 
 * to play again. If they say n, then the entire dungeon is printed. 
 * The hidden menu option is lucky number 7, this displays the 
 * entire dungeon.
 *  
 */

import java.util.Scanner;

public class DungeonAdventure
{
	private static Scanner Keyboard = new Scanner(System.in);
    private static Dungeon dungeon;
    private static Hero theHero;
    private static int curX = 0;
	private static int curY = 0;
	public static void main(String[] args)
	{
    	Scanner kb = new Scanner(System.in);
		Monster theMonster;
		dungeon = new Dungeon(5, 5);
		do
		{//begin do
			int option = displayMenu(kb);
			
			if(option != 7) {
				theHero = chooseHero(option);
				theMonster = generateMonster();
				
				System.out.println("Would you like to move your player down or right? (d or r)");
				char decision = kb.next().charAt(0);
				Room currentRoom;
				if(decision == 'd') {//begin if
					currentRoom = theHero.movePlayer(curX ++, curY, dungeon);
				} else {
					currentRoom = theHero.movePlayer(curX, curY ++, dungeon);
				}
				theMonster = currentRoom.getMonster();
				if(theMonster!=null) {
					battle(theHero, theMonster);
				}
				System.out.println("The current room is: " + theHero.getPosX() + " and " + theHero.getPosY());
				while (theHero.getHitPoints() != 0) {
					System.out.println("Use a potion or move? (p or m)");
					decision = kb.next().charAt(0);
					if(decision == 'p') {
						//TODO: Use potion, determine if potion is healing or vision
					} else if (decision == 'm') {//begin else if
						System.out.println("Move left, right, up or down?(l,r,u,d)");
						decision = kb.next().charAt(0);
						if (decision == 'l') {
							currentRoom = theHero.movePlayer(curX, curY --, dungeon);
						} else if (decision == 'r') {
							currentRoom = theHero.movePlayer(curX, curY ++, dungeon);
						} else if (decision == 'u') {
							currentRoom = theHero.movePlayer(curX --, curY, dungeon);
						} else {
							currentRoom = theHero.movePlayer(curX ++, curY, dungeon);
						}
					}
					System.out.println("The current room is: " + theHero.getPosX() + " and " + theHero.getPosY());
				}
			} else {
				printRoom();
			}
		} while (theHero != null && theHero.isAlive());
		
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
		//return theHero.isAlive();
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
