/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackMP2 {
	// An ArrayList to hold HtmlTag objects.
	// Use this to implement StackMP2.
	private ArrayList<HtmlTag> stack_internal;
	
	/**
	 * Creates an empty stack of type ArrayList<HtmlTag>
	 * 
	 * @return creates an empty stack of type ArrayList<HtmlTag>
	 * 
	 */
	public StackMP2( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}
	
	/** 
	 * Adds the given HtmlTag to the top of the stack
	 * 
	 * @param an HtmlTag 
	 *
	 * @return adds the HtmlTag to the top of the stack
	 */
	public void push( HtmlTag tag ) {
		
		stack_internal.add(0, tag);
	}
		
	/**
	 * Removes and returns the tag at the top of the stack, throws
	 * EmptyStackException if the stack is empty
	 * 
	 * @return removes and returns the tag at the top of the stack
	 * 
	 * @throws EmptyStackException if the stack is empty
	 * 
	 */
	public HtmlTag pop( ) throws EmptyStackException {
				
		if(isEmpty() == true){
			throw new EmptyStackException();
		}
		else {
			return stack_internal.remove(0);
		}
	}
	
	/**
	 * Returns, but does not remove, the HtmlTag at the top of the
	 * stack. Throws EmptyStackException if the stack is empty.
	 *
	 * @return HtmlTag at the top of the stack
	 * 
	 * @throws EmptyStackException if the stack is empty
	 * 
	 */
	public HtmlTag peek( ) throws EmptyStackException {
		
		if(isEmpty() == true){
			throw new EmptyStackException();
			
		}
		else {		
			return stack_internal.get(0);
		}
	}
	
	/**
	 * Returns true if the stack is empty, false otherwise
	 * 
	 * @return true if the stack is empty, false otherwise
	 * 
	 */
	public boolean isEmpty( ) {
		
		return stack_internal.isEmpty();
	}
}
