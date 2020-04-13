package addressBook;

public class Person {

	private Title title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String company;

	/**
	 * @param title
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param company
	 */
	public Person(Title title, String firstName, String middleName,
			String lastName, String company) {
		this.title = title;
		this.firstName = optional(firstName);
		this.middleName = optional(middleName);
		this.lastName = optional(lastName);
		this.company = optional(company);
	}

	/**
	 * @return the title
	 */
	public Title getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Title title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = optional(firstName);
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = optional(middleName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = optional(lastName);
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = optional(company);
	}

	public String optional(String string) {
		if (string == null)
			return "";
		else
			return string;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", title, firstName, middleName,
				lastName, company);
	}

}
