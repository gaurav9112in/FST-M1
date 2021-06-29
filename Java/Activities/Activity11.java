package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> colors = new HashMap<>();
		colors.put(1, "Green");
		colors.put(2,"Black");
		colors.put(3, "Yellow");
		colors.put(4, "Red");
		colors.put(5, "Blue");
		
		//printing the Map
		System.out.println("The MAP contains : " + colors.entrySet());

		//Remove one colour using the remove() method
		System.out.println("Color removed from the Map is : " + colors.remove(4));
		
		//Check if the colour green exists in the Map using the containsValue() method.
		if(colors.containsValue("Green"))
			System.out.println("Green color is present in the Map");
		else
			System.out.println("Green color is not present in the Map");
		
		//Print the size of the Map using the size() method
		System.out.println("The Size of the Map is : " + colors.size());
		
		//printing the Map
		System.out.println("The MAP contains : " + colors.entrySet());
		
	}

}
