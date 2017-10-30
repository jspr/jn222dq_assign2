package jn222dq_assign2;

public class Bus extends Vehicle{
	
	//Constructor
	Bus(int passengers, String registrationNumber) throws IllegalArgumentException{
		super(20, 4*5, 200, 10, registrationNumber);
		createPassengers(passengers);
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return "Bus, " + super.toString();
	}

}
