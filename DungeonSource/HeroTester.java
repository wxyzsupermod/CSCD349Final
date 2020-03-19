import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroTester {
	private Hero h1;
	private Monster m1;
	HeroFactory HF = new HeroFactory();
	MonsterFactory MF = new MonsterFactory();
	
	@Test
	public void testAddHitPointsDaedric() {
		m1 = new Daedric();
		m1.addHitPoints(5);
		
		assertEquals(75, m1.getHitPoints());
	}
	
	
	@Test
	public void testAddHitPointsGremlin() {
		m1 = new Gremlin();
		m1.addHitPoints(5);
		
		assertEquals(75, m1.getHitPoints());
	}
	
	
	@Test
	public void testAddHitPointsOgre() {
		m1 = new Ogre();
		m1.addHitPoints(5);
		
		assertEquals(205, m1.getHitPoints());
	}
	
	@Test
	public void testAddHitPointsSkeleton() {
		m1 = new Skeleton();
		m1.addHitPoints(5);
		
		assertEquals(105, m1.getHitPoints());
	}
	
	@Test
	public void testAddHitPointsZombie() {
		m1 = new Zombie();
		m1.addHitPoints(5);
		
		assertEquals(75, m1.getHitPoints());
	}
	
	
	
	
	// ++++++++++++++++++++++
	
	@Test 
	public void testAddHitPointsElfWizard() {
		h1 = new ElfWizard();
		h1.addHitPoints(7);
		
		assertEquals(82, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsElfWizard() {
		h1 = new ElfWizard();
		h1.subtractHitPoints(4);
		
		assertEquals(71, h1.getHitPoints());
	}
	
	
	@Test 
	public void testAddHitPointsGandalf() {
		h1 = new Gandalf();
		h1.addHitPoints(10);
		
		assertEquals(210, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsGandalf() {
		h1 = new Gandalf();
		h1.subtractHitPoints(9);
		
		assertEquals(191, h1.getHitPoints());
	}
	
	@Test 
	public void testAddHitPointsSorcerer() {
		h1 = new Sorcerer();
		h1.addHitPoints(1);
		
		assertEquals(201, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsSorcerer() {
		h1 = new Sorcerer();
		h1.subtractHitPoints(2);
		
		assertEquals(198, h1.getHitPoints());
	}
	
	@Test 
	public void testAddHitPointsSorceress() {
		h1 = new Sorceress();
		h1.addHitPoints(3);
		
		assertEquals(78, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsSorceress() {
		h1 = new Sorceress();
		h1.subtractHitPoints(2);
		
		assertEquals(73, h1.getHitPoints());
	}
	
	@Test 
	public void testAddHitPointsThief() {
		h1 = new Thief();
		h1.addHitPoints(6);
		
		assertEquals(81, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsThief() {
		h1 = new Thief();
		h1.subtractHitPoints(1);
		
		assertEquals(74, h1.getHitPoints());
	}
	
	@Test 
	public void testAddHitPointsWarrior() {
		h1 = new Warrior();
		h1.addHitPoints(1);
		
		assertEquals(126, h1.getHitPoints());
	}
	
	@Test
	public void testSubtractHitPointsWarrior() {
		h1 = new Warrior();
		h1.subtractHitPoints(5);
		
		assertEquals(120, h1.getHitPoints());
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testHeroWarrior() {
		h1 = new Warrior();
		assertEquals(.2, h1.getChanceToBlock());
	}
	
	@Test
	public void testHeroSorceress() {
		h1 = new Sorceress();
		assertEquals(.3, h1.getChanceToBlock());
	}
	
	@Test
	public void testHeroThief() {
		h1 = new Thief();
		assertEquals(.5, h1.getChanceToBlock());
	}
	
	@Test
	public void testHeroElfWizard() {
		h1 = new ElfWizard();
		assertEquals(.5, h1.getChanceToBlock());
	}
	
	@Test
	public void testHeroGandalf() {
		h1 = new Gandalf();
		assertEquals(.8, h1.getChanceToBlock());
	}
	@Test
	public void testHeroSorcerer() {
		h1 = new Sorcerer();
		assertEquals(.8, h1.getChanceToBlock());
	}
	@Test
	public void testHeroFactoryException() {
		IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {
			HF.createHero(7);});
		assertEquals("Choice " + "7" + " is invalid", exception.getMessage());
	}
}
