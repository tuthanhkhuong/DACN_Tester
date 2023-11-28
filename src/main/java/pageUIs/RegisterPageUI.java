package pageUIs;

public class RegisterPageUI {
	public static final String REGISTER_EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String REGISTER_PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String REGISTER_CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";

	public static final String REGISTER_MALE_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String REGISTER_FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String REGISTER_LAST_NAME_TEXTBOX = "//input[@id='LastName']";

	public static final String REGISTER_DAYOFBIRTH_DROPLIST = "//select[@name='DateOfBirthDay']";
	public static final String REGISTER_MONTHOFBIRTH_DROPLIST = "//select[@name='DateOfBirthMonth']";
	public static final String REGISTER_YEAROFBIRTH_DROPLIST = "//select[@name='DateOfBirthYear']";

	public static final String REGISTER_COMPANYNAME_TEXTBOX = "//input[@id='Company']";

	// ----------- VERIFY MESSAGE -----------
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String EXISTS_EMAIL_ERROR_MESSAGE = "//li[text()='The specified email already exists']";
	public static final String REGISTER_PASSWORD_MESSAGE = "//span[@id='Password-error']";
	public static final String REGISTER_CONFIRM_PASSWORD_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String REGISTER_FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String REGISTER_LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String REGISTER_SPAN = "//a[text()='Register']";
}
