/*Melody Kinyon- DungeonAdventure.java, additional Heroes and Monsters,
 * incorporated the menu system that Yousef created with my own Menu from
 * the refactor portion to include the hidden menu option, initially 
 * got the Hero to move in the dungeon; also in charge of creating 
 * the instructions and detailing the team contributions.Worked closely with
 * Jordan on the final push to make sure all the specifications were
 * met exactly across the board.Captured the working output and the output 
 * from the gitHub usage. All members used this successfully for the 
 * most part, with a few hiccups and a learning curve for all. 
 * 
 * Corbin Smith- Hero.java, created the UML Diagram, initially created 
 * the Vision Potion, initially created Healing Potion,very helpful in
 * testing and debugging the final code to ensure that it worked to
 * specifications. 
 * 
 * Yousef Baghlar-Room.java, created the J-Unit tests,
 * created initial refactor template(monsters, heroes, monster 
 * and hero factory attack interface), created the 
 * initial printDungeon() method,DungeonEntity.java, PillarOfOO.java,
 * pit.java, 
 * 
 * Jordan Fischer- DungeonAdventure.java(refined the gameplay and
 * and helped get the Hero to move appropriately), dungeon.java, 
 * printRooms(array)method, refined VisionPotion, refined the 
 * printDungeon(),refined the movement of the Hero in the dungeon,
 * refined the HealingPotion, Potion.java, RoomFactory.java, 
 * pillarOfOOFactory.java, was hugely helpful in making sure all the
 * code worked to exact specifications with Melody.
 *  
 * 
 * 
 * GamePlay: The player is asked to select a hero from
 * a menu. 
 * The hidden menu option is lucky number 7, this displays the 
 * entire dungeon. 
 * The player then has to name their hero.
 * The player is placed at the entrance of the dungeon.
 * First decision is to move down or right.
 * After moving, info is printed: Number of healing potions, number of
 * vision potions, room number and then the room contents are printed.
 * If there is a monster in the room: a battle ensues where
 * the number of rounds is calculated, and the user chooses between
 * an attack or increasing his own hitPoints. 
 * After the battle occurs for the number of rounds specified, the  
 * user decides to quit or keep battling. If they leave the battle,
 * they are prompted to choose a move in the dungeon(left, right, up,
 * or down). As the player moves along they encounter randomly placed
 * pits, and potions, and monsters. The pillars of OO
 * 
 *  
 */

import java.util.Scanner;

public class DungeonAdventure {
	private static Scanner Keyboard = new Scanner(System.in);
    private static Dungeon dungeon;
    private static Hero theHero;
    private static Monster theMonster;
    private static boolean finished;
	private static Room currentRoom;
	
	public static void main(String[] args) {
		new FlyweightFactory();
		new PillarOfOOFactory();
		finished = false;
		dungeon = new Dungeon(5, 5);
		currentRoom = dungeon.getEntrance();

		printDungeon();
		
		do {
			int option = displayMenu();
			if(option != 7) {
				chooseHero(option);
				readHeroName();
				char decision;
				while (theHero.isAlive() && !finished) {
					printCurrentRoom();
					System.out.println("Use a potion or move? (p/m)");
					decision = Keyboard.next().charAt(0);
					if(decision == 'p') {
						takePotion();
					} else if (decision == 'm') {
						System.out.println("Move left, right, up or down? (l/r/u/d)");
						decision = Keyboard.next().charAt(0);
						if (decision == 'l') {
							currentRoom = theHero.moveLeft();
						} else if (decision == 'r') {
							currentRoom = theHero.moveRight();
						} else if (decision == 'u') {
							currentRoom = theHero.moveUp();
						} else {
							currentRoom = theHero.moveDown();
						}
					}
				}
			} else {
				printDungeon();
			}
		} while (theHero != null && theHero.isAlive() && !finished);
		
		System.out.println("This is where we print the whole dungeon at the end");
		printDungeon();
		
		Keyboard.close();
	}

    private static int displayMenu() {
		int choice;
		System.out.println("Please choose a hero from the following options:");
		System.out.println("1. Warrior");
		System.out.println("2. Sorceress");
		System.out.println("3. Thief");
		System.out.println("4. Elf Wizard");
		System.out.println("5. Gandalf");
		System.out.println("6. Sorcerer");
		choice = Keyboard.nextInt();
		return choice;
	}
    
	public static void chooseHero(int choice) {
		theHero = new HeroFactory().createHero(choice);
		theHero.setPosX(dungeon.getEntrance().x);
		theHero.setPosY(dungeon.getEntrance().y);
		System.out.println("\nA " + theHero.getName() + " enters the dungeon.");
	}
	
	public static void readHeroName() {
		System.out.println("What is the name of the " + theHero.getName() + "?");
		theHero.setName(new Scanner(System.in).nextLine()); // For some reason Keyboard.nextLine() doesn't work here, so a new scanner has to be created.
		System.out.println(theHero.getName() + " seeks the Four Pillars of Object Oriented Programming.");
		System.out.println("\nFind the pillars and bring them to the exit to save your kingdom from terrible code.");
		System.out.println("Your adventure begins...\n\n");
	}
	
	public static boolean playAgain() {
		System.out.println("Play again? (y/n)");
		char again = Keyboard.next().toLowerCase().charAt(0);
		return again == 'y';
	}

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

	public static void battle(Monster monster) {
		theMonster = monster;
		//char pause = 'p';
		System.out.println(theHero.getName() + " encounters " + theMonster.getName() + "!");
		System.out.println("------------- ENTER BATTLE WITH " + theMonster.getName().toUpperCase() + " -------------");

		while (theHero.isAlive() && theMonster.isAlive() /*&& pause != 'q'*/)
		{
			theHero.battle(theMonster, Keyboard);

			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//System.out.print("\n-->q to quit, anything else to continue: ");
			//pause = Keyboard.next().charAt(0);

		}

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated!");
		//else
		//	System.out.println("Quitters never win :O");

		System.out.println("------------- EXIT BATTLE -------------");

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
	
	public static Dungeon getDungeon() {
		return dungeon;
	}
	
	public static void finish() {
		System.out.println("You WIN!");
		finished = true;
	}
	
}