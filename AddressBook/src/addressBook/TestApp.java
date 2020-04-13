package addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestApp {
	public static void main(String[] args) {
		Random rand = new Random();
		List<Contact> contacts = new ArrayList<>();
		ContactType[] types = ContactType.values();
		Title[] titles = Title.values();
		State[] states = State.values();

		Person adamPerson = new Person(Title.MR, "Adam", null, "Ross",
				"American Express");
		Address adamAddress = new Address("123 My Street", null, "West Jordan",
				State.UT, 84081);
		Phone adamPhone = new Phone("1111111111", null, "2222222222");
		EmailAddress adamEmail = new EmailAddress("aross30@bruinmail.slcc.edu");
		Contact adamContact = new Contact(ContactType.PERSONAL, adamPerson,
				adamAddress, adamPhone, adamEmail,
				"Salt Lake Community College");
		contacts.add(adamContact);

		for (int i = 0; i < 4; i++) {
			contacts.add(new Contact(types[rand.nextInt(types.length)],
					new Person(titles[rand.nextInt(titles.length)],
							randomFirst(), randomMiddle(), randomLast(),
							randomCompany()),
					new Address(randomAddress1(), randomAddress2(),
							randomCity(), states[rand.nextInt(states.length)],
							randomZip()),
					new Phone(randomPhone(), randomPhone(), randomPhone()),
					new EmailAddress(randomEmail()), randomNotes()));
		}

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println("-----------------\n");

		for (Contact contact : contacts) {
			printAll(contact);
		}

	}

	public static void printAll(Contact contact) {
		int i = 0;
		System.out.println(i + " id		: " + contact.getId());
		i++;
		System.out.println(i + " contactType	: " + contact.getType());
		i++;
		System.out.println(i + " title		: " + contact.getPerson().getTitle());
		i++;
		System.out.println(i + " firstName	: " + contact.getPerson().getFirstName());
		i++;
		System.out.println(i + " middleName	: " + contact.getPerson().getMiddleName());
		i++;
		System.out.println(i + " lastName	: " + contact.getPerson().getLastName());
		i++;
		System.out.println(i + " company	: " + contact.getPerson().getCompany());
		i++;
		System.out.println(i + " address1	: " + contact.getAddress().getAddress1());
		i++;
		System.out.println(i + " address2	: " + contact.getAddress().getAddress2());
		i++;
		System.out.println(i + " city		: " + contact.getAddress().getCity());
		i++;
		System.out.println(i + " state	: " + contact.getAddress().getState());
		i++;
		System.out.println(i + " zip		: " + contact.getAddress().getZip());
		i++;
		System.out.println(i + " phoneHome	: " + contact.getPhone().getPhoneHome());
		i++;
		System.out.println(i + " phoneMobile	: " + contact.getPhone().getPhoneMobile());
		i++;
		System.out.println(i + " phoneOffice	: " + contact.getPhone().getPhoneOffice());
		i++;
		System.out.println(				i + " emailAddress	: " + contact.getEmail().getEmail());
		i++;
		System.out.println(i + " notes	: " + contact.getNotes());
		System.out.println("-----------------\n");
	}

	public static String randomFirst() {
		Random rand = new Random();
		String[] list = { "Alex", "Charlie", "Dennis", "Eve", null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static String randomMiddle() {
		Random rand = new Random();
		String[] list = { "F", "H", "I", "J", null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static String randomLast() {
		Random rand = new Random();
		String[] list = { "Lutz", "Miller", "Nester", "Ortega", null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static String randomCompany() {
		Random rand = new Random();
		String[] list = { "Apple", "Microsoft", "Amazon", "Rocket Surgery",
				null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static String randomAddress1() {
		Random rand = new Random();
		int randomHouse = rand.nextInt(rand.nextInt(10000));
		String[] list = { "Oak", "Maple", "Willow", "Sycamore", "Cherry" };
		String[] list2 = { "Dr", "St", "Ave", "Cir" };
		String randomList = list[rand.nextInt(list.length)];
		String randomList2 = list2[rand.nextInt(list2.length)];
		String randomString = Integer.toString(randomHouse) + " " + randomList
				+ " " + randomList2;

		return randomString;
	}

	public static String randomAddress2() {
		Random rand = new Random();
		String[] list = { "Apt " + rand.nextInt(100) + " ", null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static String randomCity() {
		Random rand = new Random();
		String[] list = { "Metropolis", "Gotham", "New City", "Old City" };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

	public static int randomZip() {
		Random rand = new Random();
		int randomList = rand.nextInt(100_000) + 10_000;

		return randomList;
	}

	@SuppressWarnings("null")
	public static String randomPhone() {
		Random rand = new Random();
		int[] list = { rand.nextInt(1_000_000_000) + 1_000_000_000, 0 };
		int randomPhone = list[rand.nextInt(list.length)];
		if (randomPhone == 0)
			return null;
		else
			return Integer.toString(randomPhone);
	}

	public static String randomEmail() {
		Random rand = new Random();
		String[] list = { "wood", "heart", "computer", "pillow", null };
		String[] list2 = { "doctor", "analyst", "scientist", "professional" };
		String[] list3 = { "gmail", "apple", "aol", "yahoo" };
		String randomList = list[rand.nextInt(list.length)];
		String randomList2 = list2[rand.nextInt(list2.length)];
		String randomList3 = list3[rand.nextInt(list3.length)];
		String randomString = randomList + randomList2 + "@" + randomList3
				+ ".com ";

		if (randomList == null)
			return null;
		else
			return randomString;
	}

	public static String randomNotes() {
		Random rand = new Random();
		String[] list = { "Do not answer", "Doesn't have text",
				"Uses facetime a lot", "Spam", null };
		String randomList = list[rand.nextInt(list.length)];

		return randomList;
	}

}
