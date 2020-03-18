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
    private static Monster theMonster;
	private static Room currentRoom;
	
	public static void main(String[] args)
	{
		dungeon = new Dungeon(20, 10);
		currentRoom = dungeon.getEntrance();
		
		printDungeon();
		
		do
		{
			int option = displayMenu();
			if(option != 7) {
				theHero = chooseHero(option);
				char decision;
				while (theHero.getHitPoints() != 0) {
					System.out.println("Your current location is " + theHero.getPosY() + ", " + theHero.getPosX());
					printCurrentRoom();
					System.out.println("Use a potion or move? (p or m)");
					decision = Keyboard.next().charAt(0);
					if(decision == 'p') {
						//TODO: Use potion, determine if potion is healing or vision
						takePotion();
					} else if (decision == 'm') {
						System.out.println("Move left, right, up or down?(l,r,u,d)");
						decision = Keyboard.next().charAt(0);
						Room prevRoom = currentRoom;
						if (decision == 'l') {
							currentRoom = theHero.moveLeft();
						} else if (decision == 'r') {
							currentRoom = theHero.moveRight();
						} else if (decision == 'u') {
							currentRoom = theHero.moveUp();
						} else {
							currentRoom = theHero.moveDown();
						}
						if (currentRoom == null) {
							currentRoom = prevRoom; // Revert back to original room if the hero could not move in a certain direction.
						} else {
							theMonster = currentRoom.getMonster();
							if (theMonster != null) {
								battle();
							}
						}
					}
				}
			} else {
				printDungeon();
			}
		} while (theHero != null && theHero.isAlive());
		
		System.out.println("This is where we print the whole dungeon at the end");
		printDungeon();
	}

    private static int displayMenu()
	{
		
		int choice;
		System.out.println("Please choose a hero from the following options: ");
		System.out.println("1. Warrior ");
		System.out.println("2. Sorceress ");
		System.out.println("3. Thief ");
		System.out.println("4. Elf Wizard ");
		System.out.println("5. Gandalf  ");
		System.out.println("6. Sorcerer ");
		

		choice = Keyboard.nextInt();
		return choice;
	}	

    
	public static Hero chooseHero(int choice)
	{
		HeroFactory factory = new HeroFactory();
		Hero hero;

		if(choice == 1) {
			hero = factory.createHero(1);
		}
		
		else if(choice == 2) {
			hero = factory.createHero(2);
		}
		
		else if(choice == 3) {
			hero = factory.createHero(3);
		}
		else if(choice == 4){
			hero = factory.createHero(4);
		}
		else if( choice == 5) {
			hero = factory.createHero(5);
		}
		else {
			hero = factory.createHero(6);
		}
		
		hero.setPosX(dungeon.getEntrance().x);
		hero.setPosY(dungeon.getEntrance().y);
		
		return hero;
	}//end chooseHero method
	
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.next().charAt(0);

		return (again == 'Y' || again == 'y');
		//return theHero.isAlive();
	}//end playAgain method

	
	public static void takePotion() {
		System.out.println("You have " + theHero.getHealingPotions() + " healing potions.");
		System.out.println("You have " + theHero.getVisionPotions() + " vision potions.");
		System.out.println("Type v to drink a vision potion, or type h to drink a healing potion.");
		char potionType = Keyboard.next().charAt(0);
		if (potionType == 'h') {
			theHero.drinkHealingPotion();
		} else {
			theHero.drinkVisionPotion();
		}
	}

	public static void battle()
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " encounters " +
							theMonster.getName() + "!");
		System.out.println("---------------------------------------------");

		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
			theHero.battleChoices(theMonster);

			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.next().charAt(0);

		}

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}
	
	public static void printDungeon() {
		printRooms(0, 0, dungeon.roomsWidth, dungeon.roomsHeight);
	}
	
	public static void printRooms(int startX, int startY, int endX, int endY) {
		startX = Math.min(Math.max(startX, 0), dungeon.roomsWidth - 1);
		startY = Math.min(Math.max(startY, 0), dungeon.roomsHeight - 1);
		endX = Math.min(Math.max(endX, 0), dungeon.roomsWidth - 1);
		endY = Math.min(Math.max(endY, 0), dungeon.roomsHeight - 1);
		if (startX > endX) {
			int t = startX;
			startX = endX;
			endX = t;
		}
		if (startY > endY) {
			int t = startY;
			startY = endY;
			endY = t;
		}
		for(int i = startY; i <= endY; i++){
			for(int j = startX; j <= endX; j++){
				dungeon.getRoom(i, j).printTopRow();
			}
			System.out.println("*");
			for(int j = startX; j <= endX; j++){
				dungeon.getRoom(i, j).printMiddleRow();
			}
			if (endX == dungeon.roomsWidth - 1) {
				System.out.println("*");
			} else {
				System.out.println("|");
			}
		}
		if (endY == dungeon.roomsHeight - 1) {
			for (int j = startX; j <= endX; j ++) {
				System.out.print("* * ");
			}
		} else {
			for (int j = startX; j <= endX; j ++) {
				System.out.print("* - ");
			}
		}
		System.out.println("*");
	}

	public static void printCurrentRoom() {
		System.out.println(currentRoom);
	}
	
	public static Dungeon getDungeon () {
		return dungeon;
	}
	
}
