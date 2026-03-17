package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info(".....*****Creating User*******........");
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
			
		logger.info(".....*****User is created*******........");
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info(".....*****User info*******........");
		Response response=UserEndPoints.getUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info(".....*****User info is displayed*******........");
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info(".....*****Updating User*******........");
		// update data using payload
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response=UserEndPoints.updateUser(userpayload, this.userpayload.getUsername());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		// checking data after update
		Response updatedResponse=UserEndPoints.getUser(this.userpayload.getUsername());
		Assert.assertEquals(updatedResponse.statusCode(), 200);
		
		logger.info(".....*****User is updated*******........");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info(".....*****deleting User*******........");
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info(".....*****User deleted*******........");
	}
	
	

}
