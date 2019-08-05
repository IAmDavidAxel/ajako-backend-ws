package domain.token;

import domain.datetime.DateTime;
import domain.token.generator.RandomnAlphaNumericGenerator;
import utility.datamanager.ApplicationConfiguration;


import java.time.Instant;

public class Token {

	private String tokenValue;
	private ValidationStatus status;
	private DateTime createdAt;
	private TokenExpirationPolicy policy;



	public Token(DateTime dateTime) {
		createdAt = dateTime;
		policy = TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicyFromProperties);
		tokenValue = "";
	}

	public Token(String token, long tokenCreationDate){
		tokenValue = token;
		policy = TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicyFromProperties);
		createdAt = new DateTime(tokenCreationDate);
	}

	public void generate(){
		tokenValue = RandomnAlphaNumericGenerator.generateAlphaNumericString(ApplicationConfiguration.tokenLength);

		status= ValidationStatus.VALID;
		createdAt.setToCurrentTime();
	}


	public void checkTokenValidity(String dateString) {
		long providedDate = Instant.parse(dateString).toEpochMilli() / 1000;
		long expireIn = policy.expiresIn();
		long actualExpirationDate = createdAt.convertToUnixTime() / 1000 + expireIn;

		if (actualExpirationDate < providedDate) {
			status = ValidationStatus.INVALID;
		}
	}

	public void changePolicy(TokenExpirationPolicy tokenExpirationPolicy) {
		policy = tokenExpirationPolicy;
	}

	public void verifyValue(String tokenValue) throws IllegalTokenValidationException {
		if (!this.tokenValue.equals(tokenValue)){
			throw new IllegalTokenValidationException();
		}
	}



}
