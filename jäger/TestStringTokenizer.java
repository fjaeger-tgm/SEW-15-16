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
}
