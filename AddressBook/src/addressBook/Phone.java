package addressBook;

/**
 * Represents phone numbers, which is used to construct a Contact object.
 * 
 * @author Adam Ross
 *
 */
public class Phone {
	private String phoneHome;
	private String phoneMobile;
	private String phoneOffice;

	/**
	 * Constructs a Phone object with phone numbers.
	 * 
	 * @param phoneHome   the contact's home phone number
	 * @param phoneMobile the contact's mobile number
	 * @param phoneOffice the contact's office number
	 */
	public Phone(String phoneHome, String phoneMobile, String phoneOffice) {
		this.phoneHome = optional(phoneHome);
		this.phoneMobile = optional(phoneMobile);
		this.phoneOffice = optional(phoneOffice);
	}

	/**
	 * Gets the home phone number.
	 * 
	 * @return the phoneHome
	 */
	public String getPhoneHome() {
		return phoneHome;
	}

	/**
	 * Sets the home phone number.
	 * 
	 * @param phoneHome the phoneHome to set
	 */
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = optional(phoneHome);
	}

	/**
	 * Gets the mobile phone number.
	 * 
	 * @return the phoneMobile
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}

	/**
	 * Sets the mobile phone number.
	 * 
	 * @param phoneMobile the phoneMobile to set
	 */
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = optional(phoneMobile);
	}

	/**
	 * Gets the office phone number.
	 * 
	 * @return the phoneOffice
	 */
	public String getPhoneOffice() {
		return phoneOffice;
	}

	/**
	 * Sets the office phone number.
	 * 
	 * @param phoneOffice the phoneOffice to set
	 */
	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = optional(phoneOffice);
	}

	/**
	 * * Sets certain fields as optional. Determines if the field is null; if
	 * so, it returns blank text to be displayed instead.
	 * 
	 * @param string the String to be determined whether the field is null
	 * @return the String if not null, or blank text if so
	 */
	public String optional(String string) {
		if (string.isEmpty())
			return "";
		else
			return toPhoneNumber(string);
	}

	/**
	 * Modifies each phone number to display in the following format:
	 * (XXX)XXX-XXXX
	 * 
	 * @param number
	 * @return
	 */
	public String toPhoneNumber(String number) {
		number = "(" + number.substring(0, 3) + ")" + number.substring(3, 6)
				+ "-" + number.substring(6);

		return number;
	}

	/**
	 * Overrides the toString method to display each phone number after it has
	 * been formatted.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s", phoneHome, phoneMobile, phoneOffice);
	}

}
