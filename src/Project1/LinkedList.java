package Project1;

/**
 * This is a custom built singly linked list class.
 * The linked list accepts generic data types.
 * 
 * @version 2/22/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 1
 * Section 4
 */

public class LinkedList<E> {

	/**
	 * The head node of the linked list.
	 */
	private Node head;
	
	/**
	 * The size of the linked list.
	 */
	private int size;
	
	/**
	 * Default constructor for the LinkedList class.
	 * The constructor sets the head node to null, and
	 * indicates that the size of the linked list is zero.
	 */
	public LinkedList()
	{
		this.head = new Node(null);
		size = 0;
	}// end LinkedList()
	
	/**
	 * Adds a node to the linked list.
	 * 
	 * @param data - a generic data type being added
	 */
	public void addLink(E data){
		
		Node temp = new Node(data);
		Node current = head;		//starting at head node and moving to end of list				
		
		while(current.getNext() != null){
			current = current.getNext();
		}
		
		current.setNext(temp);
		size++; 					// increment the number of element
	}// end of addLink()
	
	/**
	 * Get a node from an index.
	 * 
	 * @param index - the number at which the node is located
	 * @return E - a generic data type
	 */
	public E get(int index){
		
		if (index <= 0){		// the linked list index starts at 0, not 1
			return null;
		}
		
		Node current = head.getNext();
		
		for (int i = 1; i < index; i ++){
			if (current.getNext() == null){
				return null;
			}
			current = current.getNext();
		}
		
		return current.getData();
	}// end get()
	
	/**
	 * Removes a node from the linked list at a certain index.
	 * 
	 * @param index - the number at which the node is located
	 * @return - returns true if the node was removed, and false if it wasn't
	 */
	public boolean removeLink(int index){
				
		if (index < 1 || index > sizeOfLinkedList())		// if index is out of range, exit
			return false;
		
		Node current = head;
		
		for (int i = 1; i < index; i++){					// linked list index starts at 1, not 0
			if (current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
		size--;
		return true;
	}// end removeLinked()
	
	/**
	 * Returns the size of the linked list.
	 * 
	 * @return int - size of linked list
	 */
	public int sizeOfLinkedList(){
		return size;
	}// end sizeOfLinkedList()
	
	/**
	 * Tells if the linked list is empty or not.
	 * 
	 * @return - returns true if the linked list is empty, and false if it isn't
	 */
	public boolean isEmpty(){
		return sizeOfLinkedList() == 0;
	}// end isEmpty()
	
	/**
	 * This is used for printing the data from the linked list. 
	 * 
	 * @return string - the string that will be printed
	 */
	public String toString()
	{
		Node current = head.getNext();
		String output = "";
		
		while(current != null){
			output += "[" + current.getData().toString() + "]\n";
			current = current.getNext();
		}
		
		return output;
	}// end toString()
	
	/**
	 * A private class within the Linked List class.
	 * This class creates the nodes for the linked list.
	 * 
	 * @version 2/22/14
 	 * @author Megan Straub <mstraub1@umbc.edu>
 	 * CMSC 341 - Spring 2014 - Project 1
 	 * Section 4
 	 **/
	private class Node{
		
		/**
		 * This defines generic data for the node.
		 */
		E data; 
		
		/**
		 * This makes a reference to the next node in the linked list.
		 */
		Node next;
		
		/**
		 * Default constructor for Node class.
		 * It sets the next node to null, and defines the data for the node.
		 * 
		 * @param data - the data for the node
		 */
		public Node(E data){
			next = null;
			this.data = data;
		}// end Node()
		
		/**
		 * Constructor for the Node class.
		 * This constructor creates a new node and sets the data to that node.
		 * 
		 * @param data - the data for the node
		 * @param newNode - the new node being created
		 */
		public Node(E data, Node newNode)
		{
			next = newNode;
			this.data = data;
		}// end Node()
		
		/**
		 * Gets the data at a node.
		 * 
		 * @return E - the node data
		 */
		public E getData(){
			return data;
		}// end getData()
		
		/**
		 * Sets the data in a particular node.
		 * 
		 * @param data - the data being set
		 */
		public void setData(E data){
			this.data = data;
		}// end setData()
		
		/**
		 * Gets the next node in the linked list.
		 * 
		 * @return Node - the next node
		 */
		public Node getNext(){
			return  next;
		}// end getNext()
		
		/**
		 * Sets the next node in the linked list.
		 * 
		 * @param newNode - the new Node being added
		 */
		public void setNext(Node newNode){
			next = newNode;
		}// end setNext()
	}// end Node Class
}// end LinkedList Class