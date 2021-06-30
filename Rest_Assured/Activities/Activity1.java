package activities;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;


public class Activity1 {
	
	String BASE_URL = "https://petstore.swagger.io/v2/pet";
	int id;
	
	@Test(priority=1)
	public void addNewPet()
	{
		
		String reqBody = "{ \"id\": 77232,  \"name\": \"Riley\", \"status\": \"alive\" }";
		
		Response response = 
		        given().contentType(ContentType.JSON) // Set headers
		        .body(reqBody).when().post(BASE_URL); // Send POST request
		
		id = response.jsonPath().getInt("id");
		
		System.out.println(response.asPrettyString());
		
		response.then().body("id", equalTo(id));	
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
		
	}
	
	@Test(priority=2)
	public void getPetInfo()
	{
		
		Response response = 
		        given().contentType(ContentType.JSON) // Set headers
		        .when().pathParam("petId", id)
		        .get(BASE_URL+"/{petId}"); // Send GET request
		
		
		System.out.println(response.asPrettyString());
			
		response.then().body("id", equalTo(id));	
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	
	}
	
	@Test(priority=3)
	public void deletePet()
	{
		
		Response response = 
		        given().contentType(ContentType.JSON) // Set headers
		        .when().pathParam("petId", String.valueOf(id))
		        .delete(BASE_URL+"/{petId}"); // Send GET request
		
		System.out.println(response.asPrettyString());	
		
		response.then().body("code", equalTo(200));	
		response.then().body("message", equalTo(String.valueOf(id)));
	
	}

}
