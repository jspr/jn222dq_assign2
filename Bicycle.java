package jn222dq_assign2;

public class Bicycle extends Vehicle{

	//Constructor
	Bicycle(String registrationNumber) {
		super(1, 1, 50, 0, registrationNumber);
		createPassengers(1);
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return "Bicycle, " + super.toString();
	}

}
