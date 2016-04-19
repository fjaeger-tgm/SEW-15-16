package dreieck;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TestGleichschenkelig {
	private int seite_a;
	private int seite_b;
	private int seite_c;
	
	private Dreieck dreieck;
	
	@Before
	public void setUp() throws Exception {
		dreieck = new Dreieck(seite_a,seite_b,seite_c);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testGleichschenkeligFalse() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.gleichSchenkelig());
	}
	@Test
	public void testGleichschenkeligDreieckFalse() {
		dreieck.setSeite_a(0);
		dreieck.setSeite_b(0);
		dreieck.setSeite_c(7);
		
		assertFalse(dreieck.gleichSchenkelig());
	}
	@Test
	public void testGleichschenkeligAgleichB() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(4);
		dreieck.setSeite_c(5);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
	@Test
	public void testGleichschenkeligBgleichC() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(5);
		dreieck.setSeite_c(5);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
	@Test
	public void testGleichschenkeligAgleichC() {
		dreieck.setSeite_a(5);
		dreieck.setSeite_b(8);
		dreieck.setSeite_c(5);
		
		assertTrue(dreieck.gleichSchenkelig());
	}
}
