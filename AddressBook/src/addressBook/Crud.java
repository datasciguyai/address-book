package addressBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Crud; a singleton class that consists of static methods that
 * create, retrieve, update, and delete a contact.
 * 
 * @author Jeremiah Reynolds
 *
 */
public class Crud {
	private static Crud crud = new Crud();
	private static List<Contact> contactList = new ArrayList<>();
	private static ContactList contactListFrame;

	private Crud() {
	}

	protected static Crud getInstance() {
		return crud;
	}

	protected static void createContact(ContactType type, Title title, String company, String firstName,
			String middleName, String lastName, String address1, String address2, String city, State state, int zip,
			String phoneHome, String phoneMobile, String phoneOffice, String email, String notes) {

		Person person = new Person(title, firstName, middleName, lastName, company);
		Address address = new Address(address1, address2, city, state, zip);
		Phone phone = new Phone(phoneHome, phoneMobile, phoneOffice);
		EmailAddress emailAddress = new EmailAddress(email);

		contactList.add(new Contact(type, person, address, phone, emailAddress, notes));
		contactListFrame.addNewContact(contactList.get(contactList.size() - 1));
	}

	protected static List<Contact> retrieveContact() {
		return contactList;
	}

//	protected static void updateContact() {
//		// TODO Implement contact update functionality
//	}

	protected static void deleteContact(int id) {
		contactList.removeIf(f -> f.getId() == id);
	}

	protected static void setContactList(ContactList contactList) {
		Crud.contactListFrame = contactList;
	}
}
