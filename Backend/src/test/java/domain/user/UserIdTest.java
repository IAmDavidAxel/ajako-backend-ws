package domain.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserIdTest {

	private UserId userId;

	@Before
	public void setUp(){
		userId = new UserId();
	}

	@Test
	public void userIdNotNullAtCreation()throws Exception{

		String id = userId.getIdValue();

		assertNotNull(id);
	}

	@Test
	public void whenCreatingTwoIds_thenTheTwoAreDifferent(){
		UserId firstId = new UserId();
		UserId secondId = new UserId();

		String firstIdValue = firstId.getIdValue();
		String secondIdValue =secondId.getIdValue();

		assertNotEquals(firstIdValue,secondIdValue);
	}

}
