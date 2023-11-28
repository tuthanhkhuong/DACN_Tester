package pageUIs;

public class SearchPageUI {
	public static final String SEARCH_TEXTBOX = "//input[@id='q']";
	public static final String SEARCH_BUTTON = "//div[@class='buttons']//button[text()='Search']";
	public static final String ADVANCED_SEARCH_CHECKBOX = "//input[@id='advs']";
	public static final String CATEGORY_DROPLIST = "//select[@id='cid']";
	public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "//input[@id='isc']";
	public static final String SEARCH_PRODUCT_TITLE = "//h2[@class='product-title']";

	// -------------ERROR MESSAGE-------------
	public static final String EMPTY_DATA_ERROR_MESSAGE = "//div[@class='warning']";
	public static final String NO_VALIDDATA_ERROR_MESSAGE = "//div[@class='no-result']";
}
