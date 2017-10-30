package jn222dq_assign2;

public class FerryMain {

	public static void main(String[] args) {
		
		
		
		System.out.println("Createing a new ferry.");
		MyFerry myFerry = new MyFerry();
		System.out.println("String representation of the ferry: " + myFerry);
		
		System.out.println("Embarking a bicycle.");
		myFerry.embark(new Bicycle(getNewRegistrationNumber()));
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Embarking another bicycle.");
		myFerry.embark(new Bicycle(getNewRegistrationNumber()));
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Embarking a car with 4 passengers.");
		myFerry.embark(new Car(4,getNewRegistrationNumber()));
		System.out.println("String representation of the ferry: " + myFerry);
		
		System.out.println("Trying to embark another car with the same registration number.");
		try {
			myFerry.embark(new Car(1,"REG-2"));
		}catch(RuntimeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		
		System.out.println("Embarking a lorry with 1 passenger.");
		myFerry.embark(new Lorry(1,getNewRegistrationNumber()));
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Embarking a bus with 20 passengers.");
		myFerry.embark(new Bus(20,getNewRegistrationNumber()));
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Iterating over the vehichles:");
		for(Vehicle vehicle : myFerry) {
			System.out.println(vehicle);
		}
		System.out.println("Disembarking the ferry.");
		myFerry.disembark();
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Embarking 50 cars.");
		for(int i=0; i<50; i++) {
			myFerry.embark(new Car(1,getNewRegistrationNumber()));
		}
		System.out.println("String representation of the ferry: " + myFerry);
		System.out.println("Can another car be embarked: " + myFerry.hasSpaceFor(new Car(1,getNewRegistrationNumber())));
		System.out.println("Trying anyway.");
		try {
			myFerry.embark(new Car(1,getNewRegistrationNumber()));
		}catch(RuntimeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
	
	private static int registrationNumber = 0;
	private static String getNewRegistrationNumber() {
		return "REG-" + registrationNumber++;
	}

}
