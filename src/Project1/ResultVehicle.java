package Project1;

/**
 * This class creates the ResultVehicle objects that are stored in the
 * results LinkedList. 
 * 
 * @version 2/22/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 1
 * Section 4
 */

public class ResultVehicle {
	
	/**
	 * The type of vehicle being stored.
	 */
	private char type;
	
	/**
	 * The time the vehicle entered the appropriate queue.
	 */
	private int timeEntered;
	
	/**
	 * The time the vehicle exited the appropriate queue.
	 */
	private int timeExited;
	
	/**
	 * Default Constructor for the ResultVehicle class.
	 * Initializes the type, timeEntered, and timeExited to default values.
	 */
	public ResultVehicle(){	
		type = 'm';
		timeEntered = 0;
		timeExited = 0;
	}// end ResultVehicle
	
	/**
	 * Constructor that initializes the type, timeEntered and
	 * timeExited.
	 * 
	 * @param type - the type of vehicle
	 * @param timeEntered - the time the vehicle entered the intersection
	 * @param timeExited - the time the vehicle exited the intersection
	 */
	public ResultVehicle(char type, int timeEntered, int timeExited){
		this.type = type;
		this.timeEntered = timeEntered;
		this.timeExited = timeExited;
	}// end ResultVehicle()
	
	/**
	 * Get the type of vehicle.
	 * 
	 * @return - the type
	 */
	public char getType() {
		return type;
	}// end getType()
	
	/**
	 * Set the type of vehicle.
	 * 
	 * @param type - the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}// end setType()

	/**
	 * Get the time the vehicle entered the intersection.
	 * 
	 * @return - the timeEntered
	 */
	public int getTimeEntered() {
		return timeEntered;
	}// end getTimeEntered()

	/**
	 * Set the time the vehicle entered the intersection.
	 * 
	 * @param timeEntered - the timeEntered to set
	 */
	public void setTimeEntered(int timeEntered) {
		this.timeEntered = timeEntered;
	}// end setTimeEntered()

	/**
	 * Get the time the vehicle exited the intersection.
	 * 
	 * @return - the timeExited
	 */
	public int getTimeExited() {
		return timeExited;
	}// end getTimeExited()

	/**
	 * Set the time the vehicle exited the intersection.
	 * 
	 * @param timeExited the timeExited to set
	 */
	public void setTimeExited(int timeExited) {
		this.timeExited = timeExited;
	}// end setTimeExited()
	
	/**
	 * Get the string that prints the type, timeEntered, and timeExited of a
	 * ResultVehicle object.
	 * 
	 * @return - the string
	 */
	public String toString(){
		String str = "Type: " + type + " Time Entered: " + timeEntered + " Time Exited: " + timeExited;
		return str;
	}// end toString()
}// end ResultVehicle Class