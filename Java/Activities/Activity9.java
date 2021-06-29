package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	
	public static void main ( String[] args) {
		
		 List<String> myList = new ArrayList<>();
		 myList.add("John");
		 myList.add("Amit");
		 myList.add("Rick");
		 myList.add(3,"Jack");
		 myList.add(1,"Tom");
		 
		 //System.out.println(myList);
		 // To print all the names in the List
		 for ( String name : myList)
			 System.out.println(name);
		 
		 //To print the 3rd name in the List
		 System.out.println("\nThe 3rd Name in the List is : " + myList.get(2));
				 
		 // To check if a name exists in the ArrayList.	
		 if(myList.contains("Tom"))
			 	System.out.println("name is present");
		 else
			 	System.out.println("name is not present");
		 
		 
		 // To print the number of names in the ArrayList.
		 System.out.println("The number of names in my List is : " + myList.size());
		 
		 //To remove the name from the List
		 myList.remove("Jack");
		 System.out.println("The name has been removed from the List");
		 
		 // To print the number of names in the ArrayList.
		 System.out.println("The number of names in my List is : " + myList.size());
		 

	}

}
