package addressBook;

public class ContactJeremy {
	private String firstName;
	private String middleName;
	private String lastName;

	/**
	 * @param firstName
	 * @param lastName
	 */
	public ContactJeremy(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
}
