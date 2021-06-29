package activities;

public class Bicycle implements BicycleParts,BicycleOperations {
	
    public int gears;
    public int currentSpeed;
	
	public Bicycle(int gear, int speed)
	{
		this.gears = gear;
		this.currentSpeed = speed;
	}

	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		this.currentSpeed -= decrement; 		
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		this.currentSpeed += increment;
	}
	
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	}
	
	

}
