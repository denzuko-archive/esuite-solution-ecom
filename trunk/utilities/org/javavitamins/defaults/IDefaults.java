package org.javavitamins.defaults;

public interface IDefaults extends IApplicationDefaults {

	static final String APPLICATION = "APPLICATION";
	static final String APPLICATION_ID = "application.id"; // BACKERS_MGMT
	// static final String APPLICATION_NAME = "application.id"; //BACKERS_MGMT
	static final String APP_DATE_FORMAT = "application.dateformat";
	static final String APP_DOB_FORMAT = "application.dob";
	static final String APP_CURRENCY_SYMBOL = "application.currency.symbol";
	static final String MODULE = "MODULE";

	static final String ALERTS_BDAY_THRESHOLD = "alerts.bday.threshold";

	static final String UMGMT = "UMGMT";
	static final String CRM = "CRM";
	static final String CATALOG = "CATALOG";
	static final String INVENTORY = "INVENTORY";
	static final String POS = "POS";
	static final String INVOICE = "INVOICE";
	static final String ORDER = "ORDER";
	static final String KOT = "KOT";
	static final String TRANSACTION = "TRANSACTION";
	static final String AUDIT = "AUDIT";

	static final String ALL_CONSOLE = "ALL_CONSOLE";
	static final String ALL = "ALL";
	static final String ANY = "%";

	static final String CUSTOMERS_AS_OPTIONS = "CUSTOMERS_AS_OPTIONS";

	static final String GENDER_TYPE = "GENDER_TYPE";
	static final String GENDER_TYPE_M = "Male";
	static final String GENDER_TYPE_F = "Female";

	static final String MARITIAL_STATUS_TYPE = "MARITIAL_STATUS_TYPE";
	static final String MARITIAL_STATUS_TYPE_SINGLE = "Single";
	static final String MARITIAL_STATUS_TYPE_MARRIED = "Married";
	static final String MARITIAL_STATUS_TYPE_WIDOWED = "Widowed";

	static final String ADDRESS_TYPE = "ADDRESS_TYPE";
	static final String PERMANENT_ADDRESS = "PERMANENT_ADDRESS";
	static final String LOCAL_ADDRESS = "LOCAL_ADDRESS";
	static final String CORPORATE_ADDRESS = "CORPORATE_ADDRESS";
	static final String DELIVERY_ADDRESS = "DELIVERY_ADDRESS";
	static final String SHIPPING_ADDRESS = "SHIPPING_ADDRESS";
	static final String BILLING_ADDRESS = "BILLING_ADDRESS";

	static final String CONTACT_TYPE = "CONTACT_TYPE";
	static final String RESIDENTIAL_PHONE = "RESIDENTIAL_PHONE";
	static final String RESIDENTIAL_FAX = "RESIDENTIAL_FAX";
	static final String OFFICE_PHONE = "OFFICE_PHONE";
	static final String OFFICE_FAX = "OFFICE_FAX";
	static final String MOBILE = "MOBILE";
	static final String EMAIL = "EMAIL";

	static final String CUSTOMER_TYPE = "CUSTOMER_TYPE";
	static final String RETAIL_CUST = "RETAIL_CUST";
	static final String CORPORATE_CUST = "CORPORATE_CUST";
	static final String COMPLEMENT_CUST = "COMPLEMENT_CUST";

	static final String ALERT_CUST_BDAY = "ALERT_CUST_BDAY";

	static final String USER_TYPE = "USER_TYPE";
	static final String _WUCASHIER = "CASHIER";
	static final String _WUACCOUNTANT = "ACCOUNTANT";

	static final String USER_ROLE = "USER_ROLE";
	static final String _ADMINISTRATOR = "ADMINISTRATOR";
	static final String _GUEST = "GUEST";
	static final String _WORK_USER = "WORK_USER";
	static final String _WORK_MANAGER = "WORK_MANAGER";
	static final String _AGENT = "AGENT";

	static final String CATALOG_ENTRY = "CATALOG_ENTRY";
	static final String ROOT = "ROOT";
	static final String CAKES = "Cakes";
	static final String PASTERIES = "Pasteries";
	static final String DESSERTS = "Desserts";
	static final String BREADS = "Breads";
	static final String BUISCUITS = "Buiscuits";
	static final String COOKIES = "Cookies";
	static final String SNACKS = "Snacks";
	static final String FILLERS = "Fillers";
	static final String BURGERS = "Burgers";
	static final String SANDWICHES = "Sandwiches";
	static final String MAGGI = "Maggi";
	static final String FRANKIES = "Frankies";
	static final String COLD_COFFEE = "Cold Coffee";
	static final String MOCKTAILS = "Mocktails";
	static final String HOT_BEVERAGES = "Mocktails";
	static final String COLD_DRINKS = "Cold Drinks";
	static final String MINERAL_WATER = "Mineral Water";
	static final String PREMIUM_CHOLCATES = "Premium Choclates";
	static final String MERCHANDISING_STUFF = "Merchandising Stuff";
	
	static final String RESTAURANT = "RESTAURANT";

	static final String TYPE_OF_CATALOG = "TYPE_OF_CATALOG";
	static final String TYPE_OF_PRODUCT = "TYPE_OF_PRODUCT";
	static final String PRODUCT_OPTION = "PRODUCT_OPTION";

	static final String PT_RAW = "PTRAW";
	static final String PT_WIP = "PTWIP";
	static final String PT_FINISHED = "PTFINISHED";
	static final String PT_WASTED = "PTWASTED";
	static final String PT_RESTAURANT = "PTRESTAURANT";
	static final String PT_ALL = "PTALL";

	static final String OL_CANCELED = "OL_CANCELED";
	static final String OL_CLOSED = "OL_CLOSED";
	static final String OL_ORDER = "OL_ORDER";
	static final String OL_KOT = "OL_KOT";
	static final String OL_OUTSTANDING_ORDERS = "OL_OUTSTANDING_ORDERS";
	static final String OL_OUTSTANDING_PAYMENTS = "OL_OUTSTANDING_PAYMENTS";

	static final String EGGLESS = "EGGLESS";
	static final String BUTTER = "BUTTER";
	static final String CHEESE = "CHEESE";
	static final String GRILLED = "GRILLED";

	static final String WEIGHT_OPTION = "PR_WEIGHT_OPTION";
	static final String GRAM = "GRAM";
	static final String KGRAM = "KGRAM";
	static final String LTR = "LTR";
	static final String MLTR = "MLTR";
	static final String UNITS = "UNITS";
	static final String PCS = "PCS";

	static final String W250gm = "W250Gram";
	static final String W500gm = "W500Gram";
	static final String W1kg = "W1Kg";
	static final String W2kg = "W2Kg";

	static final String ORDER_STATUS = "ORDER_STATUS";
	static final String OS_NEW = "NEW";
	static final String OS_CASH_PAID = "CASH PAID";
	static final String OS_CREDITED = "CREDITED";
	static final String OS_DELIVERED = "DELIVERED";
	static final String OS_PAID = "PAID";
	static final String OS_COMPLEMENTED = "COMPLEMENTED";
	static final String OS_CLOSED = "CLOSED";
	static final String OS_CANCELED = "CANCELED";

	static final String OS_DELIVERY_PENDING = "DELIVERY PENDING";
	static final String OS_PAYMENT_PENDING = "PAYMENT PENDING";

	static final String PAYMENT_TERMS = "PAYMENT_TERMS";
	static final String PAYMENT_METHODS = "PAYMENT_METHODS";

	static final String CREDIT_CARD_TYPES = "CREDIT_CARD_TYPES";
	final static String MASTER_CARD = "MASTER CARD";
	final static String VISA_CARD = "VISA";
	final static String DISCOVER_CARD = "DISCOVER";
	final static String AMEX_CARD = "AMEX";

	static final String ORDER_TYPE = "ORDER_TYPE";
	// static final String OT_KOT = "KOT";
	static final String OT_CASH = "Cash";
	static final String OT_CREDIT = "Credit";
	static final String OT_COMPLEMENTARY = "Complementary";
	// static final String OT_DELIVERABLE = "Deliverable";

	static final String SYS_GUEST_USER = "guest@loafaround.com";
	static final String SYS_CASH_USER = "cash-user@loafaround.com";

	static final String XSACTION = "XSACTION";
	static final String XS_PAY_AMOUNT = "XS_PAY_AMOUNT";
	static final String XS_CLOSE = "XS_CLOSE";
	static final String XS_DELIVER = "XS_DELIVER";
	static final String XS_COMPLEMENT = "XS_COMPLEMENT";
	static final String XS_CANCEL = "XS_CANCEL";

}
