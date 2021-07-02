package activities;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubProjectActivity {
	
    RequestSpecification requestSpec;
	//String SSHkey = "key";
	int id;
	
	
	@BeforeClass
	public void RequestSpecBuilder()
	{
		// removed the token for security purposes
		String AuthHeader = "";
		
		requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri("https://api.github.com").log(LogDetail.ALL)
                // Build request specification
                .addHeader("Authorization", "Token "+ AuthHeader)
                .build();
		
		
				
	}
	
	@Test(priority=1)
	public void PostRequest()
	{
		String reqBody = "{ \"title\": \"TestAPIKey\",  \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCAq09LJ9yc6IPc8V7DWZ5JDL2URV6eMllkBR9Ru8MUocj2MkrfOEB+vaY27sRVIiBY2Mtt8s0pMfRhZZqEqohPhxjPnMVRK1buANP7SZ26IJ/hfW+3VvM0LwGlZ9rmf2q3+jOiJaSlHpwg2ydJ/3672NZf05odCD9GWP7Dcgi9vTjckWgNBwIgEiqWFnn90eJdmSJN9vn/JE0KPZacIxXBNSrs58DMtuJC+mo+nkdwA5vw/FuR2yF2UMj1RmeE4lmgd/05b5YFbmZ2csAvQ60fGlKsi7GyG0YA2i52oYJcnhFqzCCuivyulhifZxEfeIXfPcbTiGj4iH7M8cF8x+av\" }";
		
		
		
		Response response = 
		        given().spec(requestSpec) // Set headers
		        .body(reqBody).when().post("/user/keys"); // Send POST request
		
		String resBody = response.getBody().asPrettyString();
	    System.out.println(resBody);
	    
	    id = response.then().extract().path("id");
	    
	    System.out.println(id);
	    
	    // Assert the updates
	    response.then().assertThat().statusCode(201);   //.body("name", equalTo("Hansel"));		

	}
	
	@Test(priority=2)
	public void getRequest()
	{
		
		Response response = 
		        given().spec(requestSpec) // Set headers
		        .when().get("/user/keys"); // Send GET request
		
		String resBody = response.getBody().asPrettyString();
	    System.out.println(resBody);
	    
	    // Assert the updates
	    response.then().assertThat().statusCode(200);   //.body("name", equalTo("Hansel"));		

	}
	
	@Test(priority=3)
	public void deleteRequest()
	{
		
		Response response = 
		        given().spec(requestSpec)
		        .pathParam("keyId", id)// Set headers
		        .when().delete("/user/keys/{keyId}"); // Send DELETE request
		
		String resBody = response.getBody().asPrettyString();
	    System.out.println(resBody);
	    
	    // Assert the updates
	    response.then().assertThat().statusCode(204);   //.body("name", equalTo("Hansel"));		

	}
	

}
