package Project1;

/**
 * This class stores the flow rate of each car or truck, 
 * from either of the four directions: North, South, East, or West.
 * 
 * @version 2/22/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 1
 * Section 4
 */

public class IntersectionFlowRate {
	
	/**
	 * The flow rate number of cars coming from the North.
	 */
	private int northFlowRateCars;
	
	/**
	 * The flow rate number of cars coming from the South.
	 */	
	private int southFlowRateCars;
	
	/**
	 * The flow rate number  of cars coming from the East.
	 */
	private int eastFlowRateCars;
	
	/**
	 * The flow rate number of cars coming from the West.
	 */
	private int westFlowRateCars;
	
	/**
	 * The flow rate number of trucks coming from the North.
	 */
	private int northFlowRateTrucks;
	
	/**
	 * The flow rate number of trucks coming from the South.
	 */
	private int southFlowRateTrucks;
	
	/**
	 * The flow rate number of trucks coming from the East.
	 */
	private int eastFlowRateTrucks;
	
	/**
	 * The flow rate number of trucks coming from the West.
	 */
	private int westFlowRateTrucks;
	
	/**
	 * Sole constructor - initializes all the flow rates to 0.
	 */
	public IntersectionFlowRate(){
		
		northFlowRateCars = 0;
		southFlowRateCars = 0;
		eastFlowRateCars = 0;
		westFlowRateCars = 0;
		northFlowRateTrucks = 0;
		southFlowRateTrucks = 0;
		eastFlowRateTrucks = 0;
		westFlowRateTrucks = 0;
		
	}// end IntersectionFlowRate()
	
	/**
	 * Gets the flow rate number of cars coming from the North.
	 * 
	 * @return - the northFlowRateCars
	 */
	public int getNorthFlowRateCars() {
		return northFlowRateCars;
	}// end getNorthFlowRateCars()
	
	
	/**
	 * Sets the flow rate number of cars coming from the North.
	 * The flow rate is divided by 60 because that shows how often
	 * the cars arrive per minute.
	 * 
	 * @param northFlowRateCars - the northFlowRateCars to set
	 */
	public void setNorthFlowRateCars(int northFlowRateCars) {
		this.northFlowRateCars = 60 / northFlowRateCars;
	}// end setNorthFlowRateCars()
	
	/**
	 * Gets the flow rate number of cars coming from the South.
	 * 
	 * @return - the southFlowRateCars
	 */
	public int getSouthFlowRateCars() {
		return southFlowRateCars;
	}// end getSouthFlowRateCars()
	
	/**
	 * Sets the flow rate number of cars coming from the South.
	 * The flow rate is divided by 60 because that shows how often
	 * the cars arrive per minute.
	 * 
	 * @param southFlowRateCars - the southFlowRateCars to set
	 */
	public void setSouthFlowRateCars(int southFlowRateCars) {
		this.southFlowRateCars = 60 / southFlowRateCars;
	}// end setSouthFlowRateCars()
	
	/**
	 * Gets the flow rate number of cars coming from the East.
	 * 
	 * @return - the eastFlowRateCars
	 */
	public int getEastFlowRateCars() {
		return eastFlowRateCars;
	}// end getEastFlowRateCars()
	
	/**
	 * Sets the flow rate number of cars coming from the East.
	 * The flow rate is divided by 60 because that shows how often
	 * the cars arrive per minute.
	 * 
	 * @param eastFlowRateCars - the eastFlowRateCars to set
	 */
	public void setEastFlowRateCars(int eastFlowRateCars) {
		this.eastFlowRateCars = 60 / eastFlowRateCars;
	}// end setEastFlowRateCars()
	
	/**
	 * Gets the flow rate number of cars coming from the West.
	 * 
	 * @return - the westFlowRateCars
	 */
	public int getWestFlowRateCars() {
		return westFlowRateCars;
	}// end getWestFlowRateCars()
	
	/**
	 * Sets the flow rate number of cars coming from the West.
	 * The flow rate is divided by 60 because that shows how often
	 * the cars arrive per minute.
	 * 
	 * @param westFlowRateCars - the westFlowRateCars to set
	 */
	public void setWestFlowRateCars(int westFlowRateCars) {
		this.westFlowRateCars = 60 / westFlowRateCars;
	}// end setWestFlowRateCars()
	
	/**
	 * Gets the flow rate number of trucks coming from the North.
	 * 
	 * @return - the northFlowRateTrucks
	 */
	public int getNorthFlowRateTrucks() {
		return northFlowRateTrucks;
	}// end getNorthFlowRateTrucks()
	
	/**
	 * Sets the flow rate number of trucks coming from the North.
	 * The flow rate is divided by 60 because that shows how often
	 * the trucks arrive per minute.
	 * 
	 * @param northFlowRateTrucks - the northFlowRateTrucks to set
	 */
	public void setNorthFlowRateTrucks(int northFlowRateTrucks) {
		this.northFlowRateTrucks = 60 / northFlowRateTrucks;
	}// end setNorthFlowRaeTrucks()
	
	/**
	 * Gets the flow rate number of trucks coming from the South.
	 * 
	 * @return - the southFlowRateTrucks
	 */
	public int getSouthFlowRateTrucks() {
		return southFlowRateTrucks;
	}// end getSouthFlowRateTrucks()
	
	/**
	 * Sets the flow rate number of trucks coming from the South.
	 * The flow rate is divided by 60 because that shows how often
	 * the trucks arrive per minute.
	 * 
	 * @param southFlowRateTrucks - the southFlowRateTrucks to set
	 */
	public void setSouthFlowRateTrucks(int southFlowRateTrucks) {
		this.southFlowRateTrucks = 60 / southFlowRateTrucks;
	}// end setSouthFlowRateTrucks()
	
	/**
	 * Gets the flow rate number of trucks coming from the East.
	 * 
	 * @return - the eastFlowRateTrucks
	 */
	public int getEastFlowRateTrucks() {
		return eastFlowRateTrucks;
	}// end getEastFlowRateTrucks()
	
	/**
	 * Sets the flow rate number of trucks coming from the East.
	 * The flow rate is divided by 60 because that shows how often
	 * the trucks arrive per minute.
	 * 
	 * @param eastFlowRateTrucks - the eastFlowRateTrucks to set
	 */
	public void setEastFlowRateTrucks(int eastFlowRateTrucks) {
		this.eastFlowRateTrucks = 60 / eastFlowRateTrucks;
	}// end setEastFlowRateTrucks()
	
	/**
	 * Gets the flow rate number of trucks coming from the West.
	 * 
	 * @return - the westFlowRateTrucks
	 */
	public int getWestFlowRateTrucks() {
		return westFlowRateTrucks;
	}// end getWestFlowRateTrucks()
	
	/**
	 * Sets the flow rate number of trucks coming from the West.
	 * The flow rate is divided by 60 because that shows how often
	 * the trucks arrive per minute.
	 * 
	 * @param westFlowRateTrucks - the westFlowRateTrucks to set
	 */
	public void setWestFlowRateTrucks(int westFlowRateTrucks) {
		this.westFlowRateTrucks = 60 / westFlowRateTrucks;
	}// end setWestFlowRateTrucks()
}//end IntersectionFlowRate Class
