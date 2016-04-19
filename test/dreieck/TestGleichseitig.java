package dreieck;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGleichseitig {
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
	public void testGleichsteitigFalse() {
		dreieck.setSeite_a(2);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(2);
		
		assertTrue(dreieck.gleichSeitig());
	}
	@Test
	public void testGleichsteitignotA() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.gleichSeitig());
	}
	@Test
	public void testGleichsteitignotB() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.gleichSeitig());
	}
	@Test
	public void testGleichsteitignotC() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(4);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.gleichSeitig());
	}
	@Test
	public void testGleichsteitigTrue() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(3);
		
		assertFalse(dreieck.gleichSeitig());
	}
}
