package jn222dq_assign2;

//There wasn't much information in the assignment on how the passenger class
//was supposed to look.
//So i have implemented a very basic class with a single instance variable
public class Passenger {
	private String name; //field for the passenger name
	
	//default constructor
	public Passenger() {
		this(""); //constructor chaining
	}
	
	//constructor that takes one parameter
	public Passenger(String name) {
		this.name = name;
	}
	
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	//getter for name
	public String getName() {
		return name;
	}
	
	//returns a string representation of the class
	@Override
	public String toString() {
		return getName();
	}

}
