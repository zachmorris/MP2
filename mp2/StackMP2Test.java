import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;


public class StackMP2Test {

	@Test
	public void testIsEmpty() {
		
		StackMP2 tester = new StackMP2();
		
		//a newly constructed stack should be empty
		assertEquals(tester.isEmpty(), true);
	}
	
	@Test
	public void testPush() {
		
		StackMP2 tester = new StackMP2();
		
		String table = new String("table");
		
		HtmlTag t = new HtmlTag(table);
		
		tester.push(t);
		
		//if the push() method works, the stack should not be empty
		assertEquals(tester.isEmpty(), false);
	}
	@Test
	public void testPop() {
		
		StackMP2 tester = new StackMP2();
		
		String table = new String("table");
		String lineBreak = new String("br /");
		
		HtmlTag t = new HtmlTag(table);
		HtmlTag br = new HtmlTag(lineBreak);
		
		tester.push(t);
		tester.push(br);
		
		//br was pushed last, so it should removed first
		assertEquals(tester.pop(), br);
	}
	
	@Test
	public void testPeek() {

		StackMP2 tester = new StackMP2();
		
		String table = new String("table");
		String lineBreak = new String("br /");
		
		HtmlTag t = new HtmlTag(table);
		HtmlTag br = new HtmlTag(lineBreak);
		
		tester.push(t);
		tester.push(br);
		
		//br was pushed last, so it should be at the top of the stack
		assertEquals(tester.peek(), br);
	}
	
	@Test (expected = EmptyStackException.class)
	public void testPopException()	{
		
		StackMP2 tester = new StackMP2();
		
		//should throw exception when we try to remove top tag from empty stack
		tester.pop();
	}
	
	@Test (expected = EmptyStackException.class)
	public void testPeekException() {
		
		StackMP2 tester = new StackMP2();
		
		//should throw exception when we try to look at top tag from empty stack
		tester.peek();
	}
}
