package pageUIs;

public class MyAccountPageUI {
	// -------------My account-------------
	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";

	public static final String MYACCOUNT_MALE_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String MYACCOUNT_FEMALE_RADIO_BUTTON = "//input[@id='gender-female']";

	public static final String MYACCOUNT_FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String MYACCOUNT_LAST_NAME_TEXTBOX = "//input[@id='LastName']";

	public static final String MYACCOUNT_DAYOFBIRTH_DROPLIST = "//select[@name='DateOfBirthDay']";
	public static final String MYACCOUNT_MONTHOFBIRTH_DROPLIST = "//select[@name='DateOfBirthMonth']";
	public static final String MYACCOUNT_YEAROFBIRTH_DROPLIST = "//select[@name='DateOfBirthYear']";
	public static final String MYACCOUNT_EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String MYACCOUNT_NEWSELECTER_CHECKBOX = "//input[@id='Newsletter']";
	public static final String MYACCOUNT_COMPANYNAME_TEXTBOX = "//input[@id='Company']";

	public static final String MYACCOUNT_SAVE_BUTTON = "//button[@id='save-info-button']";
	public static final String MYACCOUNT_SUCCESS_MESSAGE = "//p[@class='content']";
	//span[@id='FirstName-error']

	// -------------Login page-------------
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String LOGIN_BUTTON = "//button[@class='button-1 login-button']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";

	// -------------Address-------------

	public static final String MYACCOUNT_ADDRESSES_LABEL = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String MYACCOUNT_ADDRESSES_ADDNEW_BUTTON = "//button[text()='Add new']";
	public static final String MYACCOUNT_ADDRESSES_SAVE_BUTTON = "//button[@class='button-1 save-address-button']";

	public static final String MYACCOUNT_ADDRESSES_FIRSTNAME_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String MYACCOUNT_ADDRESSES_LASTNAME_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String MYACCOUNT_ADDRESSES_EMAIL_TEXTBOX = "//input[@id='Address_Email']";
	public static final String MYACCOUNT_ADDRESSES_COUNTRY_DROPLIST = "//select[@id='Address_CountryId']";
	public static final String MYACCOUNT_ADDRESSES_STATE_DROPLIST = "//select[@id='Address_StateProvinceId']";
	public static final String MYACCOUNT_ADDRESSES_CITY_TEXTBOX = "//input[@id='Address_City']";
	public static final String MYACCOUNT_ADDRESSES_ADDRESS1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String MYACCOUNT_ADDRESSES_ZIPCODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String MYACCOUNT_ADDRESSES_PHONENUMBER_TEXTBOX = "//input[@id='Address_PhoneNumber']";

	public static final String ADDRESS_EMAIL_TEXT = "//li[@class='email']";
	public static final String ADDRESS_PHONE_TEXT = "//li[@class='phone']";
	public static final String ADDRESS_COMPANY_TEXT = "//li[@class='company']";
	public static final String ADDRESS_ADDRESS1_TEXT = "//li[@class='address1']";
	public static final String ADDRESS_CITY_STATE_ZIP_TEXT = "//li[@class='city-state-zip']";
	public static final String ADDRESS_COUNTRY_TEXT = "//li[@class='country']";

	// -------------Change Password-------------
	// a[text()='Change password']
	public static final String CHANGEPASSWORD_LABLE = "//a[text()='Change password']";
	public static final String CHANGEPASSWORD_ADDOLD_TEXTBOX = "//input[@id='OldPassword']";
	public static final String CHANGEPASSWORD_CREATENEWPASS_TEXTBOX = "//input[@id='NewPassword']";
	public static final String CHANGEPASSWORD_CONFIRMPASS_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	public static final String CHANGEPASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";
	public static final String PASSOWRD_CHANGED_ERROR = "//p[@class='content']";

	public static final String LOGOUT_LABLE = "//a[@class='ico-logout']";
	public static final String LOGIN_LABLE = "//a[@class='ico-login']";
	public static final String SPAN_CLOSE_BUTTON = "//span[@class='close']";
}
