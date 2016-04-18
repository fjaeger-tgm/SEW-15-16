package jäger;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import static org.junit.Assert.*;
import org.junit.*;

public class TestStringTokenizer {
	StringTokenizer st;
	
	@Test
	public void testNextTokenSpaceDelimiter() {
		st = new StringTokenizer("Hallo Welt");
		assertEquals("Hallo",st.nextToken());
	}
	@Test
	public void testNextTokenTabDelimiter() {
		st = new StringTokenizer("Hallo	Welt");
		assertEquals("Hallo",st.nextToken());
	}
	@Test
	public void testNextTokenNewLineDelimiter() {
		st = new StringTokenizer("Hallo\nWelt");
		assertEquals("Hallo",st.nextToken());
	}
	@Test
	public void testNextTokenFormFeedDelimiter() {
		st = new StringTokenizer("Hallo\fWelt");
		assertEquals("Hallo",st.nextToken());
	}
	@Test
	public void testNextTokenWithCarriageReturnDelimiter() {
		st = new StringTokenizer("Hallo\rWelt");
		assertEquals("Hallo",st.nextToken());
	}
	@Test(expected=NoSuchElementException.class)
	public void testNextTokenWithoutExistingToken() {
		st = new StringTokenizer("");
		st.nextToken();
	}
}
