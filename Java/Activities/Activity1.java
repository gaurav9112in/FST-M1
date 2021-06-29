package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car carname = new Car();
		carname.make = 2014;
		carname.color = "Black";
		carname.transmission = "Manual";
		
		 
		carname.displayCharacterstics();
		carname.accelerate();
		carname.brake();
		
	}

}