package showcase;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
//import static org.mockito.ArgumentMatcher;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MockupTest {
	LinkedList mockedList;
	
	@Before
	public void setUp() {
		mockedList = mock(LinkedList.class);
	}
	
	@Test
	public void testBehaviour() {
		 List mockedList = mock(List.class);
		 mockedList.add("one");
		 mockedList.clear();
		 
		//überprüft ob du die Anweisung ausgeführt wurde
		 verify(mockedList).add("one");
		 verify(mockedList).clear();
	}
	@Test(expected=RuntimeException.class)
	public void testStubbing() {
		 
		 when(mockedList.get(0)).thenReturn("first");
		 when(mockedList.get(1)).thenThrow(new RuntimeException());
		 
		 //gibt first aus, da wir es Zeile 35 definiert haben
		 System.out.println(mockedList.get(0));
		 
		 //wirft eine RuntimeExeception
		 System.out.println(mockedList.get(1));
		 
		 //printet null da, wir es nicht definiert haben
		 System.out.println(mockedList.get(999));
		  
		 //überprüft ob du die Anweisung ausgeführt wurde
		 verify(mockedList).get(0);
	}
	/*@Test
	public void testArgumentMatcher() {
		 //stubbing using built-in anyInt() argument matcher
		 when(mockedList.get(anyInt())).thenReturn("element");

		 //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
		 when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		 //following prints "element"
		 System.out.println(mockedList.get(999));

		 //you can also verify using an argument matcher
		 verify(mockedList).get(anyInt());
	}*/
	
	
	@Test
	public void testNumberOfInvocations() {

		 mockedList.add("once");

		 mockedList.add("twice");
		 mockedList.add("twice");

		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");

		 verify(mockedList).add("once");
		 //schaut wie oft die Anweisung ausgeführt wurde
		 verify(mockedList, times(1)).add("once");

		 //exact number of invocations verification
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");

		 //überprüft ob die Anweisung gar nicht ausgeführt wurde
		 verify(mockedList, never()).add("never happened");

		 // ausgeführt >=1
		 verify(mockedList, atLeastOnce()).add("three times");
		 // ausgeführt >=2
		 verify(mockedList, atLeast(2)).add("twice");
		 // augeführt <= 5
		 verify(mockedList, atMost(5)).add("three times");
	}
	
	@Test(expected=RuntimeException.class)
	public void testStubbingMethodsWithExceptions() {
		doThrow(new RuntimeException()).when(mockedList).clear();

		   //Aufgrund der Zeile 97 wird hier eine RuntimeException geworfen
		   mockedList.clear();
	}
}
