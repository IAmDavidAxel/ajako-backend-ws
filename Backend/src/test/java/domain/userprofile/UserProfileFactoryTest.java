package domain.userprofile;


import domain.user.UserId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileFactoryTest {

	private static final String USERNAME = "Username";
	private static final String FIRST_NAME = "Arya";
	private static final String LAST_NAME = "Stark";
	private static final String PHONE_NUMBER = "789-898-9632";

	private UserProfileFactory userProfileFactory;

	@Mock
	private UserId userId;

	@Before
	public void setUp(){
		userProfileFactory = new UserProfileFactory();
	}

	@Test
	public void whenCreating_thenCreateUserProfileObject(){

		UserProfile  userProfile = userProfileFactory.create(userId,USERNAME,FIRST_NAME,LAST_NAME,PHONE_NUMBER);

		assertNotNull(userProfile);

	}

}
