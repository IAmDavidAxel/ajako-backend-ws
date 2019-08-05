package utility.datamanager;

public class ApplicationConfiguration {

	/**
	 * Security properties configuration Password policy: basic
	 * Expiration : midterm, shorterm, longterm
	 */
	public static String tokenExpirationPolicyFromProperties;
	public static int tokenLength;
	public static String passwordPolicyMode;


	/**
	 * Application general properties files
	 */
	public static String mode;
	public static int serverPort;

	/**
	 * Data Base configuration
	 */
	public static String sqliteDbName;
	public static String testSqliteDbName;
	public static String sqliteSchemaFileName;

	/**
	 * Mail Service configuration variables
	 */
	public static String mailAddress;
	public static String mailPassword;
	public static String sendInterval;
	public static String sendAttempt;


	/**
	 * Manager credentials
	 */
	public static String managerUsername;
	public static String managerPassword;

}
