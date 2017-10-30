package jn222dq_assign2;

import java.util.ArrayList;

public abstract class Vehicle {
	protected final int minPassengers; //the minimum number of passengers in/on the vehicle
	protected final int maxPassengers; //the maximum number of passengers in/on the vehicle
	protected final int size; //number of size units used by the vehicle, measured in bicycle units
	protected final int vehicleCost; //the basic cost for the vehicle
	protected final int passengerCost; //the cost of each passenger
	
	protected ArrayList<Passenger> passengers; //list to store the passengers in
	
	/*
	 * The instructions for the assignment says:
	 * 
	 *   "[...] the same vehicle cannot embark twice."
	 *   
	 * In order to fulfill this requirement we need to define when two vehicle objects are
	 * to be considered the same. It would be possible to simply check if the the references
	 * to the heap are the same, but this would mean that two different object representations
	 * of the same physical vehicle would not match.
	 * 
	 * Instead I'm using a registrationNumber field for the vehicles and compares this field
	 * in the overridden equals method
	 * 
	 * (At least motor vehicles to have some kind of registration number and even bicycles
	 * have some kind of identification number (ramnummer in Swedish) but maybe bicycles would
	 * be handled in some other fashion in a real application.)
	 * 
	 */
	
	protected String registrationNumber;
	
	//constructor
	public Vehicle(int maxPassengers, int size, int vehicleCost, int passengerCost, String registrationNumber){
		this.minPassengers = 1;
		this.maxPassengers = maxPassengers; 
		this.size = size;
		this.vehicleCost = vehicleCost;
		this.passengerCost = passengerCost;
		this.passengers = new ArrayList<Passenger>();
		this.registrationNumber = registrationNumber;
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return "registration number: " + getRegistrationNumber() + ", number of passengers: " + getNoOfPassengers();
	}
	
	//returns equality
	@Override
	public boolean equals(Object other) {
		if(other instanceof Vehicle) {
			return ((Vehicle) other).getRegistrationNumber().equals(getRegistrationNumber());
		}else {
			return false;
		}
	}
	
	//getter methods for the fields
	public int getMinPassengers() {
		return minPassengers;
	}
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getVehicleCost() {
		return vehicleCost;
	}
	
	public int getPassengerCost() {
		return passengerCost;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	//returns the number of passengers in/on the vehicle
	public int getNoOfPassengers() {
		return passengers.size();
	}
	
	//returns the total cost of the vehicle and its passengers
	public int getTotalCost() {
		return vehicleCost + passengerCost * getNoOfPassengers();
	}
	
	//updates a passengers name
	public void updatePassengerName(int index, String name) throws IndexOutOfBoundsException {
		if(index >= 0 && index < passengers.size()) {
			passengers.get(index).setName(name);
		}else {
			throw new IndexOutOfBoundsException ("Invalid index.");
		}
	}
	
	//creates a number of passengers with default values
	protected void createPassengers(int noOfPassengers) throws IllegalArgumentException {
		if(noOfPassengers >= minPassengers && noOfPassengers <= maxPassengers) {
			for(int i=0; i<noOfPassengers; i++) {
				passengers.add(new Passenger());
			}
		}else {
			throw new IllegalArgumentException ("Invalid number of passengers.");
		}
	}
	
	

}
