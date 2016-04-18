package dreieck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestIstDreieck {
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
	public void testIstDreieckANull() {
		dreieck.setSeite_a(0);
		dreieck.setSeite_b(1);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void testIstDreieckBNull() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(0);
		dreieck.setSeite_c(2);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void testIstDreieckCNull() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(0);
		
		assertFalse(dreieck.istDreieck());
	}
	
	@Test
	public void testIstDreieckANegativ() {
		dreieck.setSeite_a(-1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(3);
		
		assertFalse(dreieck.istDreieck());
	}
	
	public void testIstDreieckBNegativ() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(-2);
		dreieck.setSeite_c(3);
		
		assertFalse(dreieck.istDreieck());
	}
	
	public void testIstDreieckCNegativ() {
		dreieck.setSeite_a(1);
		dreieck.setSeite_b(2);
		dreieck.setSeite_c(-3);
		
		assertFalse(dreieck.istDreieck());
	}
}
