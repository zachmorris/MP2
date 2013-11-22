/**
 * This is the HtmlValidator class.
 * You should implement this class.
 */
//import a queue
import java.util.Queue;
import java.util.LinkedList;

public class HtmlValidator {
	
	private LinkedList<HtmlTag> internal_queue;
	
	/**
	 *  Creates empty queue of type LinkedList<HtmlTag>
	 *   
	 *  @return creates empty queue of type LinkedList<Htmltag>
	 *  
	 */
	public HtmlValidator(){
		this.internal_queue = new LinkedList<HtmlTag>();
	}
	
	/**
	 *  Creates copy of given queue, throws IllegalArgumentException if the 
	 *  queue passed in is null
	 *  
	 *  @param queue of HtmlTags
	 * 
	 *  @return creates copy of the queue passed in
	 *  
	 *  @throws IllegalArgumentException if the queue passed is null
	 *  
	 */
	public HtmlValidator(Queue<HtmlTag> tags) throws IllegalArgumentException{
		if(tags == null){
			throw new IllegalArgumentException();
		}
		
		this.internal_queue = new LinkedList<HtmlTag>(tags);
		
	}
	
	/**
	 * Adds given tag to the end of the validator's queue, throws 
	 * IllegalArgumentException if the tag is null.
	 *  
	 *  @param HtmlTag to be added to the end of the queue
	 * 
	 *  @return adds the tag to the end of the queue
	 *  
	 *  @throws IllegalArgumentException if the tag passed is null
	 *  
	 */
	public void addTag(HtmlTag tag) throws IllegalArgumentException{
		
		if(tag == null){
			throw new IllegalArgumentException();
		}
		else{
			internal_queue.addLast(tag);
		}
	}
	
	/**
	 *  Returns the queue of HtmlTags, including ones added or removed
	 * 
	 *  @return queue of HtmlTags
	 * 
	 */
	public Queue<HtmlTag> getTags(){
	 	
		return internal_queue;
	}
	
	/**
	 * Removes all instances of tags that match the given element, 
	 * throws IllegalArgumentException if the given element is null
	 *  
	 *  @param element to be removed from the queue
	 * 
	 *  @return removes all instances of the element from the queue
	 *  
	 *  @throws IllegalArgumentException if the element passed is 'null'
	 *  
	 */
	public void removeAll(String element) throws IllegalArgumentException{
		if(element == null) {
			throw new IllegalArgumentException();
		}
		else {
			internal_queue.removeAll(HtmlTag.tokenize(element));
		}
	}
	
	/**
	 *  Prints text representation of the tags in your queue, including
	 *  error output if tags are unclosed or unexpected
	 *  
	 *  @return prints text representation of the tags in your queue to the 
	 *  console, prints error messages if tags are unexpected or unclosed
	 * 
	 */
	public void validate(){
		StackMP2 validator_stack = new StackMP2();
		HtmlTag tempTag;
		int indentSize = 0;
		Queue<HtmlTag> internal_two = new LinkedList<HtmlTag>();
		
		internal_two = (Queue<HtmlTag>) internal_queue.clone();
		
		while(internal_two.isEmpty() == false){
		
			tempTag = internal_two.remove();
			
			if(tempTag.isOpenTag() == true){
				//if open tag, print to screen
				if(tempTag.isSelfClosing() == true){
					//if the head of the queue is self-closing, print
					System.out.println(indent(indentSize) + tempTag.toString());
				}
				else{
					System.out.println(indent(indentSize) + tempTag.toString());
				
					indentSize ++;
				
					validator_stack.push(tempTag);
				}
				
			}
			else if(validator_stack.isEmpty() == false && 
					tempTag.getElement().equals(validator_stack.peek().getElement())){
				//it is a closing tag that matches the tag atop the stack
				indentSize--; 
				System.out.println(indent(indentSize) + tempTag.toString());
				
				validator_stack.pop();
				
			}
			else{
				//closing tag that does not match the tag atop the stack	
				System.out.println("ERROR unexpected tag: " + tempTag.toString());
			}
					
		}
		
		while(validator_stack.isEmpty() == false){
			//left over tags are unclosed
			System.out.println("ERROR unclosed tag: " + validator_stack.pop().toString());
		}
		
	}
	
	/**
	 * Returns a String with integer i number of indents
	 *  
	 * @param i >= 0 the number of indents to string together
	 * 
	 * @return String of blank spaces that acts as the indent
	 */
	public String indent(int i){
		int j;
		
		String indent = new String("    ");
		String toScreen = new String();
		
		for(j=0; j < i; j++){
			toScreen = toScreen.concat(indent);
		}
		return(toScreen);
	}
	
}

