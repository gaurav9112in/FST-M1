package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a HashSet named hs
		Set<String> hs = new HashSet<>();
		
		//Add 6 objects using add() method to the HashSet
		hs.add("One");
		hs.add("Two");
		hs.add("Three");
		hs.add("Four");
		hs.add("Five");
		hs.add("Six");
		
		//Printing the Set
		System.out.println("The elements in Set are :" + hs);

		//Remove an element using the remove() method
		hs.remove("Four");
		
		// try to remove an element that is not present in the Set
		if(hs.remove("Seven"))
			System.out.println("Seven is removed from the Set");
		else
			System.out.println("WARNING : Seven is not present in the Set. So, it cant be removed");
		
		//Use the contains() method to check if an item "Five" is in the Set or not
		if(hs.contains("Five") )
			System.out.println("Five is present in the Set");
		else
			System.out.println("Five is not present in the Set");
		
		//Print the updated set
		System.out.println("The elements in Set are :" + hs);

		
	}

}
