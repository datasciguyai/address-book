<<<<<<< HEAD
package addressBook;

/**
 * @author Adam Ross
 *
 */
public class Contact {
	private final int id;
	private static int count = 8675309;
	private ContactType type;
	private Person person;
	private Address address;
	private Phone phone;
	private EmailAddress email;
	private String notes;

	/**
	 * @param type
	 * @param person
	 * @param address
	 * @param phone
	 * @param email
	 * @param notes
	 */
	public Contact(ContactType type, Person person, Address address, Phone phone, EmailAddress email, String notes) {
		this.id = count++;
		this.type = type;
		this.person = person;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.notes = optional(notes);
	}

	public Contact(Contact contact) {
		this(contact.getType(), contact.getPerson(), contact.getAddress(), contact.getPhone(), contact.getEmail(),
				contact.getNotes());

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * @return the type
	 */
	public ContactType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ContactType type) {
		this.type = type;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = optional(notes);
	}

	public String optional(String string) {
		if (string == null)
			return "";
		else
			return string;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s", type, person, address, phone, email, notes);
	}
}
=======
package addressBook;

public class Contact {
	private final int id;
	private static int count = 8675309;
	private ContactType type;
	private Person person;
	private Address address;
	private Phone phone;
	private EmailAddress email;
	private String notes;

	/**
	 * @param type
	 * @param person
	 * @param address
	 * @param phone
	 * @param email
	 * @param notes
	 */
	public Contact(ContactType type, Person person, Address address,
			Phone phone, EmailAddress email, String notes) {
		this.id = count++;
		this.type = type;
		this.person = person;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.notes = optional(notes);
	}

	public Contact(Contact contact) {
		this(contact.getType(), contact.getPerson(), contact.getAddress(),
				contact.getPhone(), contact.getEmail(), contact.getNotes());

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * @return the type
	 */
	public ContactType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ContactType type) {
		this.type = type;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = optional(notes);
	}

	public String optional(String string) {
		if (string == null)
			return "";
		else
			return string;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s", type, person, address, phone,
				email, notes);
	}

}
>>>>>>> refs/heads/adam
