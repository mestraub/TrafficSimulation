package Project1;

/**
 * This class creates the Vehicle objects used in the TrafficSim class.
 * All objects are stored in queues based on the direction the Vehicles
 * are traveling. (ex: North, South, East, West)
 * 
 * @version 2/22/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 1
 * Section 4
 */

public class Vehicle {
	
	/**
	 * The type of vehicle being stored.
	 */
	private char type;
	
	/**
	 * The time the vehicle entered the appropriate queue.
	 */
	private int timeEntered;
	
	/**
	 *  Default Constructor for the Vehicle class.
	 *  Initializes the vehicle type, and time entered to default values.
	 */
	public Vehicle(){
		type = 'm';
		timeEntered = 0;
	}
	
	/**
	 * Constructor that initializes vehicle type and timeEntered.
	 * 
	 * @param type - The type of vehicle being entered
	 * @param timeEntered - The time the Vehicle entered the intserction
	 */
	public Vehicle(char type, int timeEntered){		
		this.type = type;
		this.timeEntered = timeEntered;
	}// end Vehicle
	
	/**
	 * Get the type of Vehicle.
	 * 
	 * @return the type
	 */
	public char getType() {
		return type;
	}// end getType()
	
	/**
	 * Set the type of Vehicle.
	 * 
	 * @param type - the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}// end setType()

	/**
	 * Get the number the Vehicle entered the intersection.
	 * 
	 * @return the timeEntered
	 */
	public int getTimeEntered() {
		return timeEntered;
	}// end getTimeEntered()

	/**
	 * Set the time the Vehicle entered the intersection.
	 * 
	 * @param timeEntered - the timeEntered to set
	 */
	public void setTimeEntered(int timeEntered) {
		this.timeEntered = timeEntered;
	}// end setTimeEntered()
}// end Vehicle Class