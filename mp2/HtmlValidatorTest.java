import static org.junit.Assert.*;
import org.junit.Test;

public class HtmlValidatorTest {

	@Test
	public void test_addTag() {
	
		String table = new String("table");
		String paragraph = new String("paragraph");
		
		HtmlTag t = new HtmlTag(table);
		HtmlTag p = new HtmlTag(paragraph);
		
		HtmlValidator tester = new HtmlValidator();
		
		tester.addTag(t);
		tester.addTag(p);
		
		//when we add multiple tags to the queue, the tag we added
		//first should be first in line
		assertEquals(t, tester.getTags().peek());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_addNullTag() {
						
		HtmlValidator tester = new HtmlValidator();
		
		//should throw exception if we pass a null tag
		tester.addTag(null);			
	}
	
	@Test
	public void test_getTags() {
		
		String expected = new String("[]");
		HtmlValidator tester = new HtmlValidator();
		
		//an empty LinkedList should produce an empty string
		assertEquals(expected, tester.getTags().toString());
	}
	
	@Test
	public void test_removeAll() {
		
		String table = new String("table");
		String paragraph = new String("paragraph");
		
		HtmlTag t = new HtmlTag(table);
		HtmlTag p = new HtmlTag(paragraph);
		
		HtmlValidator tester = new HtmlValidator();
		
		tester.addTag(p);
		tester.addTag(t);
		tester.addTag(p);
		
		tester.removeAll(p.toString());
		
		//tester should contain no p tags
		assertEquals(false, tester.getTags().contains(p));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_removeAllNull() {
						
		HtmlValidator tester = new HtmlValidator();
		
		//should throw exception when we try to remove a null tag
		tester.removeAll(null);			
	}
		
	@Test
	public void test_indent() {
		
		int indentAmount = 1;
		String correct = new String("    ");
		
		HtmlValidator tester = new HtmlValidator();
		
		tester.indent(indentAmount);
		System.out.println(correct);
		//compared by inspection in the console output
		
	}
  
}  