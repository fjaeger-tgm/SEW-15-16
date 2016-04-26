package showcase;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
//import static org.mockito.ArgumentMatcher;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.NoInteractionsWanted;

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
		 
		//�berpr�ft ob du die Anweisung ausgef�hrt wurde
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
		  
		 //�berpr�ft ob du die Anweisung ausgef�hrt wurde
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
		 //schaut wie oft die Anweisung ausgef�hrt wurde
		 verify(mockedList, times(1)).add("once");

		 //exact number of invocations verification
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");

		 //�berpr�ft ob die Anweisung gar nicht ausgef�hrt wurde
		 verify(mockedList, never()).add("never happened");

		 // ausgef�hrt >=1
		 verify(mockedList, atLeastOnce()).add("three times");
		 // ausgef�hrt >=2
		 verify(mockedList, atLeast(2)).add("twice");
		 // augef�hrt <= 5
		 verify(mockedList, atMost(5)).add("three times");
	}
	
	@Test(expected=RuntimeException.class)
	public void testStubbingMethodsWithExceptions() {
		doThrow(new RuntimeException()).when(mockedList).clear();

		   //Aufgrund der Zeile 97 wird hier eine RuntimeException geworfen
		   mockedList.clear();
	}
	
	@Test
	public void testVerification() {
		 // A. Single mock whose methods must be invoked in a particular order
		 List singleMock = mock(List.class);

		 //using a single mock
		 singleMock.add("was added first");
		 singleMock.add("was added second");

		 //create an inOrder verifier for a single mock
		 InOrder inOrder = inOrder(singleMock);

		 //following will make sure that add is first called with "was added first, then with "was added second"
		 inOrder.verify(singleMock).add("was added first");
		 inOrder.verify(singleMock).add("was added second");

		 // B. Multiple mocks that must be used in a particular order
		 List firstMock = mock(List.class);
		 List secondMock = mock(List.class);

		 //using mocks
		 firstMock.add("was called first");
		 secondMock.add("was called second");

		 //create inOrder object passing any mocks that need to be verified in order
		 InOrder inOrder2 = inOrder(firstMock, secondMock);

		 //following will make sure that firstMock was called before secondMock
		 inOrder2.verify(firstMock).add("was called first");
		 inOrder2.verify(secondMock).add("was called second");

		 // Oh, and A + B can be mixed together at will
	}
	
	@Test
	public void testInteraction() {
		List mockOne = mock(List.class);
		List mockTwo = mock(List.class);
		List mockThree = mock(List.class);
		 
		 mockOne.add("one");

		 //�berpr�ft ob du die Anweisung ausgef�hrt wurde
		 verify(mockOne).add("one");

		 //�berpr�ft ob die Anweisung niemals ausgef�hrt wurde
		 verify(mockOne, never()).add("two");

		 //�berpr�ft ob die anderen Listen nicht davon betroffen waren
		 verifyZeroInteractions(mockTwo, mockThree);
	}
	
	@Test(expected= NoInteractionsWanted.class)
	public void testInvocation() {
		//using mocks
		 mockedList.add("one");
		 mockedList.add("two");

		 verify(mockedList).add("one");

		 //Fehlermeldung weil keine Interaktionen gewollt sind
		 verifyNoMoreInteractions(mockedList);
		
	}
	
}
