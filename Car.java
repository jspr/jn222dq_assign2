package jn222dq_assign2;

public class Car extends Vehicle{
	
	//Constructor
	Car(int passengers, String registrationNumber) throws IllegalArgumentException{
		super(4, 5, 100, 15, registrationNumber);
		createPassengers(passengers);
	}
	
	//returns a string representation of the object
	@Override
	public String toString() {
		return "Car, " + super.toString();
	}

}

