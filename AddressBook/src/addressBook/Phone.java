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
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneOffice = phoneOffice;
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
		this.phoneHome = phoneHome;
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
		this.phoneMobile = phoneMobile;
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
		this.phoneOffice = phoneOffice;
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
