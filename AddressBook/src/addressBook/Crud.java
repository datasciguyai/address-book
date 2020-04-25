package addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents Crud; a singleton class that consists of static methods that
 * create, retrieve, update, and delete a contact.
 * 
 * @author Jeremiah Reynolds + Adam Ross
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
		printToFile();
	}

	protected static List<Contact> retrieveContacts() {
		if (contactList.size() == 0) {
			String fileName = "./Contacts.csv";
			File file = new File(fileName);
			if (file.exists()) {
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
					while (reader.ready()) {
						String line = reader.readLine();
						String[] contactInfo = line.split(",");
						ContactType type = Enum.valueOf(ContactType.class, contactInfo[1]);
						Title title = Enum.valueOf(Title.class, contactInfo[2]);
						String company = contactInfo[3];
						String firstName = contactInfo[4];
						String middleName = contactInfo[5];
						String lastName = contactInfo[6];
						String address1 = contactInfo[7];
						String address2 = contactInfo[8];
						String city = contactInfo[9];
						State state = Enum.valueOf(State.class, contactInfo[10]);
						int zip = Integer.parseInt(contactInfo[11]);
						String phoneHome = contactInfo[12];
						String phoneMobile = contactInfo[13];
						String phoneOffice = contactInfo[14];
						String email = contactInfo[15];
						String notes = contactInfo[16];

						contactList.add(new Contact(type, new Person(title, firstName, middleName, lastName, company),
								new Address(address1, address2, city, state, zip),
								new Phone(phoneHome, phoneMobile, phoneOffice), new EmailAddress(email), notes));
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return contactList;
	}

	protected static void updateContact(int id, ContactType type, Title title, String company, String firstName,
			String middleName, String lastName, String address1, String address2, String city, State state, int zip,
			String phoneHome, String phoneMobile, String phoneOffice, String email, String notes) {

		contactList.forEach(c -> {
			if (c.getId() == id) {
				c.setType(type);
				c.getPerson().setTitle(title);
				c.getPerson().setCompany(company);
				c.getPerson().setFirstName(firstName);
				c.getPerson().setMiddleName(middleName);
				c.getPerson().setLastName(lastName);
				c.getAddress().setAddress1(address1);
				c.getAddress().setAddress2(address2);
				c.getAddress().setCity(city);
				c.getAddress().setState(state);
				c.getAddress().setZip(zip);
				c.getPhone().setPhoneHome(phoneHome);
				c.getPhone().setPhoneMobile(phoneMobile);
				c.getPhone().setPhoneOffice(phoneOffice);
				c.getEmail().setEmail(email);
				c.setNotes(notes);
			}
		});

		contactListFrame.updateContactDetails();
		printToFile();
	}

	protected static void deleteContact(int id) {
		contactList.removeIf(f -> f.getId() == id);
		printToFile();
	}

	protected static void setContactList(ContactList contactList) {
		Crud.contactListFrame = contactList;
	}

	protected static void printToFile() {
		String fileContacts = "./Contacts.csv";
		try (PrintWriter writer = new PrintWriter(fileContacts)) {
			contactList.forEach(el -> writer.println(el));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}