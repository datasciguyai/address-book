package addressBook;

public class Phone {
	private String phoneHome;
	private String phoneMobile;
	private String phoneOffice;

	/**
	 * @param phoneHome
	 * @param phoneMobile
	 * @param phoneOffice
	 */
	public Phone(String phoneHome, String phoneMobile, String phoneOffice) {
//		if (phoneHome == null)
//			this.phoneHome = "";
//		else
//			this.phoneHome = toPhoneNumber(phoneHome);

//		if (phoneMobile == null)
//			this.phoneMobile = "";
//		else
//			this.phoneMobile = toPhoneNumber(phoneMobile);

//		if (phoneOffice == null)
//			this.phoneOffice = "";
//		else
//			this.phoneOffice = toPhoneNumber(phoneOffice);

		this.phoneHome = optional(phoneHome);
		this.phoneMobile = optional(phoneMobile);
		this.phoneOffice = optional(phoneOffice);
	}

	/**
	 * @return the phoneHome
	 */
	public String getPhoneHome() {
		return phoneHome;
	}

	/**
	 * @param phoneHome the phoneHome to set
	 */
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = optional(phoneHome);
	}

	/**
	 * @return the phoneMobile
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}

	/**
	 * @param phoneMobile the phoneMobile to set
	 */
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = optional(phoneMobile);
	}

	/**
	 * @return the phoneOffice
	 */
	public String getPhoneOffice() {
		return phoneOffice;
	}

	/**
	 * @param phoneOffice the phoneOffice to set
	 */
	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = optional(phoneOffice);
	}

	public String optional(String string) {
		if (string == null)
			return "";
		else
			return toPhoneNumber(string);
	}

	public String toPhoneNumber(String number) {
		number = "(" + number.substring(0, 3) + ")" + number.substring(3, 6)
				+ "-" + number.substring(6);

		return number;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", phoneHome, phoneMobile, phoneOffice);
	}

}
