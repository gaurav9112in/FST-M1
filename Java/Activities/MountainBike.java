package activities;

public class MountainBike extends Bicycle {
	
	public int seatHeight;
	
	public MountainBike(int gear, int speed, int seatHeight ) {
		super(gear, speed);
		this.seatHeight = seatHeight;
	
	}

	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}	

	public String bicycleDesc() {
	    return(super.bicycleDesc() + "\nSeatHeight of bicycle is " + seatHeight );
	}
	
}
