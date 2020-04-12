package addressBook;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeremiah Reynolds
 *
 */
public class Contacts {
	private static Contacts contacts = new Contacts();
	private static List<ContactJeremy> c = new ArrayList<>();
	private static ContactList cl;

	private Contacts() {
	}

	public static Contacts getInstance() {
		return contacts;
	}

	public static void createContact(String firstName, String middleName, String lastName) {
		c.add(new ContactJeremy(firstName, middleName, lastName));
	}

	public static List<ContactJeremy> retrieveContact() {
		return c;
	}

	public static void updateContact() {
		cl.updateContactList(c.get(c.size() - 1));
	}

	public static void deleteContact(String firstName) {
		c.removeIf(f -> f.getFirstName() == firstName);
	}
	
	/**
	 * @param cl the cl to set
	 */
	public static void setCl(ContactList cl) {
		Contacts.cl = cl;
	}

}
