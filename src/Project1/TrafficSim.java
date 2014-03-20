package Project1;

import java.util.*;
import java.io.*;

/**
 * This class models a traffic light simulation where the cars only go straight from North, South, East and West. 
 * 
 * @version 2/22/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 1
 * Section 4
 */

public class TrafficSim {

	/**
	 * This queue holds the vehicles coming from the north.
	 */
	private Queue<Vehicle> northbound;
	
	/**
	 * This queue holds the vehicles coming from the south.
	 */
	private Queue<Vehicle> southbound;
	
	/**
	 * This queue holds the vehicles coming from the east.
	 */
	private Queue<Vehicle> eastbound;
	
	/**
	 * This queue holds the vehicles coming from the west. 
	 */
	private Queue<Vehicle> westbound;
	
	/**
	 * This is used to set the flow rates from the vehicles in each direction.
	 */
	private IntersectionFlowRate flowRate;
	
	/**
	 * This is the custom singly linked list that holds objects of the ResultVehicle class.
	 */
	private Project1.LinkedList<ResultVehicle> results; // linked list is generic
	
	/**
	 * Constructor for the TrafficSim class. This initializes traffic queues, IntersectionFlowRate
	 * class, and the results linked list. This also reads the input file, and calls lightSimulation()
	 * to do the simulation work and print the board states.
	 * 
	 * @param fileName - name of the file to be read by readFromFile(fileName)
	 */
	public TrafficSim(String fileName){
		
		northbound = new java.util.LinkedList<Vehicle>();
		southbound = new java.util.LinkedList<Vehicle>();
		eastbound = new java.util.LinkedList<Vehicle>();
		westbound = new java.util.LinkedList<Vehicle>();
		flowRate = new IntersectionFlowRate();
		results = new Project1.LinkedList<ResultVehicle>();
		
		readFromFile(fileName); 
		lightSimulation();
	}// end TrafficSim()
	
	/**
	 * Reads the file and separates the file based on direction,
	 * the flow rate for cars, and the flow rate for trucks.
	 * The flow rate for cars and trucks and is set based on the direction.
	 * 
	 * @param fileName - the name of the file being read
	 * @return - returns true if the file was read correctly and false if it wasn't
	 */
	private boolean readFromFile (String fileName){
		
		File textFile = new File(fileName);
		
		String str;
		int cars;
		int trucks;
		char direction;
		
		try {
			// reads in the text file
			Scanner scanFile = new Scanner(textFile); 
			
			while (scanFile.hasNext()){
				str = scanFile.next();
				direction = str.charAt(0);
				cars = scanFile.nextInt();
				trucks = scanFile.nextInt();
				
				//Reads the direction of the flow rate for cars and trucks, and sets them.
				switch (direction){ 			
					case 'N': 
							flowRate.setNorthFlowRateCars(cars);
							flowRate.setNorthFlowRateTrucks(trucks);
							break;  
					case 'S': 
							flowRate.setSouthFlowRateCars(cars);
							flowRate.setSouthFlowRateTrucks(trucks);
							break;
					case 'E': 
							flowRate.setEastFlowRateCars(cars);
							flowRate.setEastFlowRateTrucks(trucks);
							break;
					case 'W': 
							flowRate.setWestFlowRateCars(cars);
							flowRate.setWestFlowRateTrucks(trucks);
							break;
					default : 
							System.out.println("An inaccurate direction was entered. Try again.");
				}
			}
			
			scanFile.close();
			return true;
			
		}// end try
		catch (FileNotFoundException e){	
			
			System.out.println("File not found.");
			e.printStackTrace();
			return false;
		}// end catch
	}// end readFromFile()
	
	/**
	 * Prints the board state of the intersection during the simulation.
	 */
	public void printBoard(){
		
		System.out.printf("%8s%5d%n", "SB", southbound.size());
		
		if(southbound.size() == 0){
			for (int i = 0; i < 6; i++)
				System.out.printf("%n");
		}else if (southbound.size() == 1){
			for (int i = 0; i < 5; i++)
				System.out.printf("%n");
			
			System.out.printf("%10s%n", southbound.peek().getType());
		}else if(southbound.size() == 2){			
			for (int i = 0; i < 4; i++)
				System.out.printf("%n");
			
			System.out.printf("%10s%n", 'x');
			System.out.printf("%10s%n", southbound.peek().getType());		
		}else if (southbound.size() == 3){
			for (int i = 0; i < 3; i++)
				System.out.printf("%n");
			
			for (int i = 0; i < 2; i++)
				System.out.printf("%10s%n", 'x');
			
			System.out.printf("%10s%n", southbound.peek().getType());	
		}else if (southbound.size() == 4){
			for (int i = 0; i < 2; i++)
				System.out.printf("%n");
			
			for (int i = 0; i < 3; i++)
				System.out.printf("%10s%n", 'x');
			
			System.out.printf("%10s%n", southbound.peek().getType());			
		}else if (southbound.size() == 5){
			System.out.printf("%n");
			
			for (int i = 0; i < 4; i++)
				System.out.printf("%10s%n", 'x');
			
			System.out.printf("%10s%n", southbound.peek().getType());			
		}else if (southbound.size() >= 6){
			for (int i = 0; i < 5; i++)
				System.out.printf("%10s%n", 'x');
			
			System.out.printf("%10s%n", southbound.peek().getType());
		}// end southbound of board state		
		
		System.out.printf("%s%20s%n", "EB", "WB"); 

		if (eastbound.size() == 1){
			System.out.printf("%9s", eastbound.peek().getType());
		}else if (eastbound.size() == 2){
			System.out.printf("%8s%s",'x', eastbound.peek().getType());
		}else if (eastbound.size() == 3){
			System.out.printf("%7s%s%s",'x', 'x' , eastbound.peek().getType());
		}else if (eastbound.size() == 4){
			System.out.printf("%6s%s%s%s",'x', 'x','x', eastbound.peek().getType());
		}else if (eastbound.size() == 5){
			System.out.printf("%5s%s%s%s%s",'x','x','x','x', eastbound.peek().getType());
		}else if (eastbound.size() >= 6){
			System.out.printf("%4s%s%s%s%s%s",'x','x','x','x','x', eastbound.peek().getType());
		}// end eastbound of board state		
		
		if (westbound.size() == 1){
			System.out.printf("%2s", westbound.peek().getType());
		}else if (westbound.size() == 2){
			System.out.printf("%2s%s",westbound.peek().getType(), 'x');
		}else if (westbound.size() == 3){
			System.out.printf("%2s%s%s",westbound.peek().getType(), 'x', 'x');
		}else if (westbound.size() == 4){
			System.out.printf("%2s%s%s%s",westbound.peek().getType(), 'x', 'x','x');
		}else if (westbound.size() == 5){
			System.out.printf("%2s%s%s%s%s",westbound.peek().getType(), 'x','x','x','x', 'x');
		}else if (westbound.size() >= 6){
			System.out.printf("%2s%s%s%s%s%s",westbound.peek().getType(), 'x','x','x','x','x');
		}// end westbound of board state
		
		System.out.printf("%n%d%20d%n", eastbound.size(), westbound.size());
		
		if(northbound.size() == 0){
			for (int j = 0; j < 6; j++)
				System.out.printf("%n");
		}else if (northbound.size() == 1){
			System.out.printf("%10s%n", northbound.peek().getType());
			
			for (int i = 0; i < 5; i++)
				System.out.printf("%n");
		}else if(northbound.size() == 2){
			System.out.printf("%10s%n", northbound.peek().getType());
			System.out.printf("%10s%n", 'x');
			
			for (int i = 0; i < 4; i++)
				System.out.printf("%n");
		}else if (northbound.size() == 3){
			System.out.printf("%10s%n", northbound.peek().getType());
			for (int i = 0; i < 2; i++)
				System.out.printf("%10s%n", 'x');
			
			for (int i = 0; i < 3; i++)
				System.out.printf("%n");	
		}else if (northbound.size() == 4){
			System.out.printf("%10s%n", northbound.peek().getType());
			
			for (int i = 0; i < 3; i++)
				System.out.printf("%10s%n", 'x');
			
			for (int i = 0; i < 2; i++)
				System.out.printf("%n");			
		}else if (northbound.size() == 5){
			System.out.printf("%10s%n", northbound.peek().getType());				
			
			for (int i = 0; i < 4; i++)
				System.out.printf("%10s%n", 'x');
			
			System.out.printf("%n");			
		}else if (northbound.size() >= 6){
			System.out.printf("%10s%n", northbound.peek().getType());
			
			for (int i = 0; i < 5; i++)
				System.out.printf("%10s%n", 'x');		
		}// end northbound of board state
			
		System.out.printf("%8s%5d", "NB", northbound.size());
		
	}// end printBoard()
	
	/**
	 * Runs the traffic simulation and calls printBoard() to print the board before and
	 * during the simulation.
	 */
	public void lightSimulation(){
		
		// Creates the initial vehicles at the beginning of the intersection.
		
		for (int i = 0; i < 2; i++){
			northbound.add(new Vehicle('c', 0));
			southbound.add(new Vehicle ('c', 0));
			eastbound.add(new Vehicle ('c', 0));
			westbound.add(new Vehicle ('c', 0));
		}		
		
		printBoard();

		System.out.println("\nat clock: 0");
		System.out.println("--------------------------------------");
		
		// if true green for NS, if false red for NS
		boolean green = true;
		
		int counterNS = 0;
		int counterEW = 0;
		
		// trucks take 2 seconds to leave the intersection
		int truckDelayNorth = 2;	
		int truckDelaySouth = 2;
		int truckDelayEast = 2;
		int truckDelayWest = 2;
		
		
		for (int i = 1; i <= 120; i++){

			if (green){
				if (northbound.size() > 0){
					if(northbound.peek().getType() == 'c'){
						results.addLink(new ResultVehicle(northbound.peek().getType(), 
											northbound.peek().getTimeEntered(), i));
						northbound.remove();
					}else if (northbound.peek().getType() == 't' && (truckDelayNorth == 2 || truckDelayNorth == 1)){
						truckDelayNorth--;
					}
						
					if (truckDelayNorth == 0){
						results.addLink(new ResultVehicle(northbound.peek().getType(), 
											northbound.peek().getTimeEntered(), i));
						northbound.remove();
						truckDelayNorth = 2;
					}
				}
					
				if (southbound.size() > 0){
					if(southbound.peek().getType() == 'c'){
						results.addLink(new ResultVehicle(southbound.peek().getType(), 
											southbound.peek().getTimeEntered(), i));
						southbound.remove();
					}else if (southbound.peek().getType() == 't' && (truckDelaySouth == 2 || truckDelaySouth == 1)){
						truckDelaySouth--;
					}
					
					if (truckDelaySouth == 0){
						results.addLink(new ResultVehicle(southbound.peek().getType(), 
											southbound.peek().getTimeEntered(), i));
						southbound.remove();
						truckDelaySouth = 2;
					}
				}
					
				counterNS++;
				
			}// end if green
				
			if (!green){
				if (eastbound.size() > 0){
					if(eastbound.peek().getType() == 'c'){
						results.addLink(new ResultVehicle(eastbound.peek().getType(), 
											eastbound.peek().getTimeEntered(), i));
						eastbound.remove();
					}else if (eastbound.peek().getType() == 't' && (truckDelayEast == 2 || truckDelayEast == 1)){
						truckDelayEast--;
					}
					
					if (truckDelayEast == 0){
						results.addLink(new ResultVehicle(eastbound.peek().getType(), 
											eastbound.peek().getTimeEntered(), i));
						truckDelayEast = 2;
						eastbound.remove();
					}
				}
				
				if (westbound.size() > 0){
					if(westbound.peek().getType() == 'c'){
						results.addLink(new ResultVehicle(westbound.peek().getType(), 
											westbound.peek().getTimeEntered(), i));
						westbound.remove();
					}else if (westbound.peek().getType() == 't' && (truckDelayWest == 2 || truckDelayWest == 1)){
						truckDelayWest--;
					}
					
					if (truckDelayWest == 0){
						results.addLink(new ResultVehicle(westbound.peek().getType(), 
											westbound.peek().getTimeEntered(), i));
						westbound.remove();
						truckDelayWest = 2;
					}					
				}
				
				counterEW++;
				
			}// end if !green
			
			// adding vehicles to the appropriate queue
			
			if(i % flowRate.getNorthFlowRateCars() == 0)
				addVehicle('N', new Vehicle ('c', i));
			if(i % flowRate.getNorthFlowRateTrucks() == 0)
				addVehicle('N', new Vehicle ('t', i));
			if(i % flowRate.getSouthFlowRateCars() == 0)
				addVehicle('S', new Vehicle ('c', i));
			if(i % flowRate.getSouthFlowRateTrucks() == 0)
				addVehicle('S', new Vehicle ('t', i));
			if(i % flowRate.getEastFlowRateCars() == 0)
				addVehicle('E', new Vehicle ('c', i));
			if(i % flowRate.getEastFlowRateTrucks() == 0)
				addVehicle('E', new Vehicle ('t', i));
			if(i % flowRate.getWestFlowRateCars() == 0)
				addVehicle('W', new Vehicle ('c', i));
			if(i % flowRate.getWestFlowRateTrucks() == 0)
				addVehicle('W', new Vehicle ('t', i));
			
			printBoard();
			
			System.out.println("\nat clock: " + i);
			System.out.println("--------------------------------------");
			
			if (counterNS >= 30 && (westbound.size() > 0 || eastbound.size() > 0)){				
				System.out.println("Light has to change. Met minimum length green, and EW is waiting.");
				green = false;
				counterNS = 0;				
			}else if ((eastbound.size() == 0 && westbound.size() == 0) && counterEW >= 10 && counterEW < 30){
				System.out.println("Light has to change. EW is empty, and NS is primary (try to keep green).");
				green = true;
				counterEW = 0;
			}else if (counterEW >= 30){
				System.out.println("Light has to change. EW went over maximal amount of time green. NS is waiting.");
				green = true;
				counterEW = 0;
			}
		}// ends for loop for light simulation
		
		int carsLinkedList = 0;		// storing the number of cars that passed
		int trucksLinkedList = 0; 	// storing the number of trucks that passed
		double waitTime = 0;		// storing the added sum of wait time between vehicles
		
		// linked list starts at int 1
		for (int i = 1; i <= results.sizeOfLinkedList(); i ++){ 	
			if (results.get(i).getType() == 'c')
				carsLinkedList++;
			else if (results.get(i).getType() == 't')
				trucksLinkedList++;
			
			waitTime += (results.get(i).getTimeExited() - results.get(i).getTimeEntered());		// adding wait times together
		}
		
		double avgWaitTime = waitTime / results.sizeOfLinkedList();		// calculates the average wait time
		
		System.out.println("\nThe final results are:");
		System.out.println("The number of vehicles that passed through the intersection is: " + results.sizeOfLinkedList());
		System.out.println("The number of cars that passed through the intersection is: " + carsLinkedList);
		System.out.println("The number of trucks that passed through the intersection is: " + trucksLinkedList);
		System.out.printf("The average wait time for this intersection is: %.6f", avgWaitTime);
		
	}// end lightSimulation()
	
	/**
	 * Adds a Vehicle object, based on direction to the appropriate queue.
	 * 
	 * @param direction - the direction the Vehicle is going
	 * @param x - the Vehicle object
	 * @return - returns true if the Vehicle was added correctly, and false if it wasn't.
	 */
	private boolean addVehicle(char direction, Vehicle x){
		
		switch (direction){
			case 'N' : 
				northbound.add(x);
				break;
			case 'S' : 
				southbound.add(x);
				break;
			case 'E' : 
				eastbound.add(x);
				break;
			case 'W' : 
				westbound.add(x);
				break;
			default : 
				return false;		// direction given was invalid
		}
		
		return true;
		
	}// end addVehicle()
}// end TrafficSim Class