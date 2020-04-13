package addressBook;

import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeremiah Reynolds
 *
 */
public class Contacts {
	private static Contacts contacts = new Contacts();
	private static List<Contact> contact = new ArrayList<>();
	private static ContactList cl;

	private Contacts() {
	}

	public static Contacts getInstance() {
		return contacts;
	}
	
		public static void createContact(ContactType type, Title title, String company, String firstName, String middleName,
			String lastName, String address1, String address2, String city, State state, int zip, String phoneHome,
			String phoneMobile, String phoneOffice, String email, String notes) {

		Person p = new Person(title, firstName, middleName, lastName, company);
		Address a = new Address(address1, address2, city, state, zip);
		Phone ph = new Phone(phoneHome, phoneMobile, phoneOffice);
		EmailAddress e = new EmailAddress(email);

		contact.add(new Contact(type, p, a, ph, e, notes));
	}

	public static List<Contact> retrieveContact() {
		return contact;
	}

	public static void updateContact() {
//		cl.updateContactList(contact.get(contact.size() - 1));
	}

	public static void deleteContact(String firstName) {
//		contact.removeIf(f -> f.getFirstName() == firstName);
	}

	/**
	 * @param cl the cl to set
	 */
	public static void setCl(ContactList cl) {
		Contacts.cl = cl;
	}

	

}
