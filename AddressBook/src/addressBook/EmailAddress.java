package addressBook;

/**
 * Represents an email address, which is used to create a Contact object.
 * 
 * @author Adam Ross
 *
 */
public class EmailAddress {
	private String email;

	/**
	 * Constructs the EmailAddress object. Checks to see if the email address is
	 * blank; if so, returns an empty String to be displayed.
	 * 
	 * @param email the contact's email address
	 */
	public EmailAddress(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	/**
	 * Overrides the toString method to display the email address correctly.
	 */
	@Override
	public String toString() {
		return email;
	}

}
