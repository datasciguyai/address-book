package addressBook;

/**
 * Represents a person, which is used to create a Contact object.
 * 
 * @author Adam Ross
 *
 */
public class Person {
	private Title title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String company;

	/**
	 * Contsructs the Person object.
	 * 
	 * @param title      the person's title
	 * @param firstName  the person's first name
	 * @param middleName the person's middle name
	 * @param lastName   the person's last name
	 * @param company    the company the person works for
	 */
	public Person(Title title, String firstName, String middleName,
			String lastName, String company) {
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.company = company;
	}

	/**
	 * Gets the person's title.
	 * 
	 * @return the title
	 */
	public Title getTitle() {
		return title;
	}

	/**
	 * Sets the person's title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(Title title) {
		this.title = title;
	}

	/**
	 * Gets the person's first name.
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the person's first name.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the person's middle name.
	 * 
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the person's middle name.
	 * 
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the person's last name.
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the person's last name.
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the company the person works for.
	 * 
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the company the person works for.
	 * 
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}


	/**
	 * Overrides the toString method to the following format:<br>
	 * {title} {first name} {middle name} {last name} {company}
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", title, company, firstName,
				middleName, lastName);
	}

}
