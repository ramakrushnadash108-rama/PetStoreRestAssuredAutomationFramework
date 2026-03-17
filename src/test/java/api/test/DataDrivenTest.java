package api.test;


import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DataDrivenTest {
		
		
		
		@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
		public void testPostUser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone)
		{
			User userPayload =new User();
			
			userPayload.setId(Integer.parseInt(UserID));
			userPayload.setUsername(UserName);
			userPayload.setFirstName(FirstName);
			userPayload.setLastName(LastName);
			userPayload.setEmail(Email);
			userPayload.setPassword(Password);
			userPayload.setPhone(Phone);
			
			
			Response response=UserEndPoints.createUser(userPayload);
			Assert.assertEquals(response.getStatusCode(), 200);
					
		}
		
		@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
		public void testGetUserByName(String UserName)
		{
			Response response=UserEndPoints.getUser(UserName);
			Assert.assertEquals(response.statusCode(), 200);
		}
		
		
		//@Test(priority=3)
		public void testUpdateUserByName()
		{
			// update data using payload
			
//			userpayload.setFirstName(faker.name().firstName());
//			userpayload.setLastName(faker.name().lastName());
//			userpayload.setEmail(faker.internet().safeEmailAddress());
//			
			
//			Response response=UserEndPoints.updateUser(userpayload, this.userpayload.getUsername());
//			response.then().log().body();
//			
//			Assert.assertEquals(response.getStatusCode(), 200);
//			// checking data after update
//			Response updatedResponse=UserEndPoints.getUser(this.userpayload.getUsername());
//			Assert.assertEquals(updatedResponse.statusCode(), 200);
			
		}
		
		@Test(priority=4, dataProvider="UserNames", dataProviderClass=DataProviders.class)
		public void testDeleteUserByName(String UserName)
		{
			Response response=UserEndPoints.deleteUser(UserName);
			Assert.assertEquals(response.getStatusCode(), 200);
		}
		
		

	


}
