package jn222dq_assign2;

public class Lorry extends Vehicle{
	
	//Constructor
	Lorry(int passengers, String registrationNumber) throws IllegalArgumentException{
		super(2, 8*5, 300, 15, registrationNumber);
		createPassengers(passengers);
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return "Lorry, " + super.toString();
	}

}
