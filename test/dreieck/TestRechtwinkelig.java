package dreieck;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TestRechtwinkelig {
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
	public void testRechtWinkeligAgroeﬂerBundAgroeﬂerC() {
		dreieck.setSeite_a(80);
		dreieck.setSeite_b(60);
		dreieck.setSeite_c(40);
		
		assertFalse(dreieck.rechtWinkelig());
	}
	@Test
	public void testRechtWinkeligBgroeﬂerAundBGroeﬂerC() {
		dreieck.setSeite_a(60);
		dreieck.setSeite_b(80);
		dreieck.setSeite_c(40);
		assertFalse(dreieck.rechtWinkelig());
	}
	@Test
	public void testRechtWinkeligCgroeﬂerBundCgroeﬂerA() {
		dreieck.setSeite_a(40);
		dreieck.setSeite_b(60);
		dreieck.setSeite_c(80);
		
		assertFalse(dreieck.rechtWinkelig());
	}
	@Test
	public void testRechtWinkeligFalse() {
		dreieck.setSeite_a(4);
		dreieck.setSeite_b(4);
		dreieck.setSeite_c(4);
		
		assertFalse(dreieck.rechtWinkelig());
	}
}
