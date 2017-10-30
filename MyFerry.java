package jn222dq_assign2;

import java.util.ArrayList;
import java.util.Iterator;


public class MyFerry implements Ferry {
	
	/*
	 * IMPORTANT
	 * I'm assuming that even passengers in vehicles counts towards the total passenger space.
	 * (Some years ago I was working with reservations for a ferry company and it was quite often vehicles
	 * could not be added not because there was no space for the vehicles but
	 * because the passenger limit had been reached.)
	 */
	
	private final int passengerCost; //field for the cost of a passenger without a vehicle
	private final int passengerSpace; //field for the maximum number of passengers
	private final int vehicleSpace; //field for the space for vehicles, measured in bicycle units
	private int earnedMoney; //field for the total amount of money earned
	
	private ArrayList<Vehicle> vehicles; //list to store the vehicles in
	
	//list to store passengers without vehicles in
	//the rest of the passengers are stored in their respective vehicles
	private ArrayList<Passenger> passengersWithoutVehicles;
	
	//constructor
	public MyFerry() {
		passengerCost = 25;
		passengerSpace = 200;
		vehicleSpace = 50 * 5;
		earnedMoney = 0;
		vehicles = new ArrayList<Vehicle>();
		passengersWithoutVehicles = new ArrayList<Passenger>();
	}

	//we want to be able to iterate over the vehicles
	@Override
	public Iterator<Vehicle> iterator() {
		return vehicles.iterator();
	}

	// Number of passengers on board
	@Override
	public int countPassengers() {
		int i = passengersWithoutVehicles.size();
		for(Vehicle vehicle : vehicles) {
			i += vehicle.getNoOfPassengers();
		}
		return i;
	}

	// Used vehicle space. One car is 1.
	@Override
	public int countVehicleSpace() {
		//internally bicycle is used as the basic space unit (as suggested in the instructions)
		//one bicycle is 1/5 of a car
		int i = 0;
		for(Vehicle vehicle : vehicles) {
			i += vehicle.getSize();
		}	
		return (int) Math.ceil(i/5.0);
	}

	// Earned money
	@Override
	public int countMoney() {
		return earnedMoney;
	}

	// Embark vehicle, warning if not enough space or already embarked
	@Override
	public void embark(Vehicle v) {
		if(hasRoomForMultiplePassengers(v.getNoOfPassengers())) {
			if(hasSpaceFor(v)) {
				if(!isEmbarked(v)) {
					vehicles.add(v);
					earnedMoney += v.getTotalCost();
				}else {
					throw new RuntimeException("The vehicle is already embarked.");
				}
			}else {
				throw new RuntimeException("There is no space for the vehicle on the ferry.");
			}
		}else {
			throw new RuntimeException("There is no room for the passengers in the vehicle on the ferry.");
		}
	}

	// Embark passenger, warning if not enough room
	@Override
	public void embark(Passenger p) {
		if(hasRoomFor(p)) {
			passengersWithoutVehicles.add(p);
			earnedMoney += passengerCost;
			
		}else {
			throw new RuntimeException("There is no room for the passenger on the ferry.");
		}	
	}

	// Clear (empty) ferry. The money earned remains, 
    // i.e., is not reset to zero 
	@Override
	public void disembark() {
		passengersWithoutVehicles.clear();
		vehicles.clear();
	}

	// true if we can embark vehicle v
	@Override
	public boolean hasSpaceFor(Vehicle v) {	
		int i = v.getSize();
		for(Vehicle vehicle : vehicles) {
			i += vehicle.getSize();
		}
		return i <= vehicleSpace;
	}

	// true if we can embark passenger p
	@Override
	public boolean hasRoomFor(Passenger p) {
		return countPassengers() < passengerSpace;
	}
	
	// Nice looking ferry status print out
	@Override
	public String toString() {
		return "{No of passengers: " + countPassengers() + ", no of vehicles: " + vehicles.size() + ", used vehicle space: " + countVehicleSpace() + ", earned money: " + earnedMoney + "}";
	}
	
	// true if we can embark the number of passengers
	public boolean hasRoomForMultiplePassengers(int noOfPassengers) {
		return countPassengers() + noOfPassengers <= passengerSpace;
	}
	
	//true if the vehicle already is embarked
	private boolean isEmbarked(Vehicle vehicle) {
		boolean embarked = false;
		for(Vehicle v : this) {
			if(vehicle.equals(v))
				embarked = true;
		}
		return embarked;
	}

}
