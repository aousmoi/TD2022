package service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import td.model.User;

public class UserServiceTest {

	@Test
	public void createUserTest() {
		User user1 = new User("Anass", "OUSMOI");
		assertEquals(user1.getNom(), "Anass");	
	}
}
