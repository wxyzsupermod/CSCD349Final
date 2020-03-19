import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroTester {
	private Hero h1;
	private Monster m1;
	HeroFactory HF = new HeroFactory();
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
