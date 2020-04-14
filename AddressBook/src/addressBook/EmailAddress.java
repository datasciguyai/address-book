<<<<<<< HEAD
package addressBook;

/**
 * @author Adam Ross
 *
 */
public class EmailAddress {
	private String email;

	/**
	 * @param email
	 */
	public EmailAddress(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	@Override
	public String toString() {
		return email;
	}
}
=======
package addressBook;

public class EmailAddress {

	private String email;

	/**
	 * @param email
	 */
	public EmailAddress(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null)
			this.email = "";
		else
			this.email = email;
	}

	@Override
	public String toString() {
		return email;
	}

}
>>>>>>> refs/heads/adam
