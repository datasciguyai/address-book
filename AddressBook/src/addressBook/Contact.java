package addressBook;

/**
 * Constructs a Contact object, which is the primary element of a contact in the
 * address book.
 * 
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
	 * Constructs the Contact object.
	 * 
	 * @param type    the contact type
	 * @param person  the Person object to be used
	 * @param address the Address object to be used
	 * @param phone   the Phone object to be used
	 * @param email   the Email object to be used
	 * @param notes   notes about the contact
	 */
	public Contact(ContactType type, Person person, Address address,
			Phone phone, EmailAddress email, String notes) {
		this.id = count++;
		this.type = type;
		this.person = person;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.notes = notes;
	}

	/**
	 * Constructs a new contact using an already-existing contact.
	 * 
	 * @param contact the contact in which the new contact will be based
	 */
	public Contact(Contact contact) {
		this(contact.getType(), contact.getPerson(), contact.getAddress(),
				contact.getPhone(), contact.getEmail(), contact.getNotes());
	}

	/**
	 * Gets the unique id for the contact.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the current count which is used to set the id for the contact.
	 * 
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * Gets the type of contact.
	 * 
	 * @return the type
	 */
	public ContactType getType() {
		return type;
	}

	/**
	 * Sets the type of contact.
	 * 
	 * @param type the type to set
	 */
	public void setType(ContactType type) {
		this.type = type;
	}

	/**
	 * Gets the Person object.
	 * 
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Gets the Address object.
	 * 
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Gets the Phone object.
	 * 
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * Returns the Email object.
	 * 
	 * @return the email
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * Returns the notes about the contact.
	 * 
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes for the contact.
	 * 
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Overrides the toString to the following format:<br>
	 * {ContactType}, {Person}, {Address}, {Phone}, {EmailAddress}. {notes}
	 */
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s,%s ", id, type, person, address,
				phone, email, notes);
	}

}
