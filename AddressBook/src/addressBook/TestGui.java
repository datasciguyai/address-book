package addressBook;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TestGui extends JFrame {

	static Random rand = new Random();
	private DefaultListModel<Contact> listModel;
	private DefaultListModel<String> names;
	private JTextPane txtType;
	private JTextPane txtTitle;
	private JTextPane txtFirstName;
	private JTextPane txtMiddleName;
	private JTextPane txtLastName;
	private JTextPane txtCompany;
	private JTextPane txtAdddress1;
	private JTextPane txtAddress2;
	private JTextPane txtCity;
	private JTextPane txtState;
	private JTextPane txtZip;
	private JTextPane txtPhoneHome;
	private JTextPane txtPhoneMobile;
	private JTextPane txtPhoneOffice;
	private JTextPane txtEmailAddress;
	private JTextPane txtNotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGui frame = new TestGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Contact test1 = new Contact(getRandomContact());
		Contact test2 = new Contact(getRandomContact());
		Contact test3 = new Contact(getRandomContact());
		Contact test4 = new Contact(getRandomContact());
		Contact test5 = new Contact(getRandomContact());
		Contact test6 = new Contact(getRandomContact());
		Contact test7 = new Contact(getRandomContact());
		Contact test8 = new Contact(getRandomContact());
		Contact test9 = new Contact(getRandomContact());
		Contact test10 = new Contact(getRandomContact());
		String testName1 = test1.getPerson().getFirstName() + " "
				+ test1.getPerson().getMiddleName() + " "
				+ test1.getPerson().getLastName();
		String testName2 = test2.getPerson().getFirstName() + " "
				+ test2.getPerson().getMiddleName() + " "
				+ test2.getPerson().getLastName();
		String testName3 = test3.getPerson().getFirstName() + " "
				+ test3.getPerson().getMiddleName() + " "
				+ test3.getPerson().getLastName();
		String testName4 = test4.getPerson().getFirstName() + " "
				+ test4.getPerson().getMiddleName() + " "
				+ test4.getPerson().getLastName();
		String testName5 = test5.getPerson().getFirstName() + " "
				+ test5.getPerson().getMiddleName() + " "
				+ test5.getPerson().getLastName();
		String testName6 = test6.getPerson().getFirstName() + " "
				+ test6.getPerson().getMiddleName() + " "
				+ test6.getPerson().getLastName();
		String testName7 = test7.getPerson().getFirstName() + " "
				+ test7.getPerson().getMiddleName() + " "
				+ test7.getPerson().getLastName();
		String testName8 = test8.getPerson().getFirstName() + " "
				+ test8.getPerson().getMiddleName() + " "
				+ test8.getPerson().getLastName();
		String testName9 = test9.getPerson().getFirstName() + " "
				+ test9.getPerson().getMiddleName() + " "
				+ test9.getPerson().getLastName();
		String testName10 = test10.getPerson().getFirstName() + " "
				+ test10.getPerson().getMiddleName() + " "
				+ test10.getPerson().getLastName();

		listModel = new DefaultListModel<>();
		listModel.addElement(test1);
		listModel.addElement(test2);
		listModel.addElement(test3);
		listModel.addElement(test4);
		listModel.addElement(test5);
		listModel.addElement(test6);
		listModel.addElement(test7);
		listModel.addElement(test8);
		listModel.addElement(test9);
		listModel.addElement(test10);

		names = new DefaultListModel<>();
		names.addElement(testName1);
		names.addElement(testName2);
		names.addElement(testName3);
		names.addElement(testName4);
		names.addElement(testName5);
		names.addElement(testName6);
		names.addElement(testName7);
		names.addElement(testName8);
		names.addElement(testName9);
		names.addElement(testName10);

		JPanel pnlContactList = createContactListPanel();
		contentPane.add(pnlContactList, BorderLayout.WEST);

		JPanel pnlContactDetails = createContactLabelsPanel();
		contentPane.add(pnlContactDetails, BorderLayout.CENTER);

		JPanel contactDetails = creatreContactDetailsPanel();
		contentPane.add(contactDetails, BorderLayout.EAST);

		JPanel panelButtons = createButtonsPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
	}

	private JPanel createButtonsPanel() {
		JList<String> contactList = new JList<>(names);
		JPanel panelButtons = new JPanel();
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = contactList.getSelectedIndex();
				names.remove(index);

				if (index == names.getSize()) {
					// removed item in last position
					index--;
				}

				contactList.setSelectedIndex(index);
			}
		});
		panelButtons.add(btnDelete);
		return panelButtons;
	}

	private JPanel creatreContactDetailsPanel() {
		JPanel contactInfo = new JPanel();
		contactInfo.setLayout(new GridLayout(0, 1, 0, 0));

		txtType = new JTextPane();
		contactInfo.add(txtType);
		txtTitle = new JTextPane();
		contactInfo.add(txtTitle);
		txtFirstName = new JTextPane();
		contactInfo.add(txtFirstName);
		txtMiddleName = new JTextPane();
		contactInfo.add(txtMiddleName);
		txtLastName = new JTextPane();
		contactInfo.add(txtLastName);
		txtCompany = new JTextPane();
		contactInfo.add(txtCompany);
		txtAdddress1 = new JTextPane();
		contactInfo.add(txtAdddress1);
		txtAddress2 = new JTextPane();
		contactInfo.add(txtAddress2);
		txtCity = new JTextPane();
		contactInfo.add(txtCity);
		txtState = new JTextPane();
		contactInfo.add(txtState);
		txtZip = new JTextPane();
		contactInfo.add(txtZip);
		txtPhoneHome = new JTextPane();
		contactInfo.add(txtPhoneHome);
		txtPhoneMobile = new JTextPane();
		contactInfo.add(txtPhoneMobile);
		txtPhoneOffice = new JTextPane();
		contactInfo.add(txtPhoneOffice);
		txtEmailAddress = new JTextPane();
		contactInfo.add(txtEmailAddress);
		txtNotes = new JTextPane();
		contactInfo.add(txtNotes);
		return contactInfo;
	}

	private JPanel createContactLabelsPanel() {
		JPanel pnlContactDetails = new JPanel();
		pnlContactDetails.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblTitle = new JLabel("Title:");
		pnlContactDetails.add(lblTitle);
		JLabel lblType = new JLabel("Type:");
		pnlContactDetails.add(lblType);
		JLabel lblFirstName = new JLabel("First name:");
		pnlContactDetails.add(lblFirstName);
		JLabel lblMiddleName = new JLabel("Middle name:");
		pnlContactDetails.add(lblMiddleName);
		JLabel lblLastName = new JLabel("Last name:");
		pnlContactDetails.add(lblLastName);
		JLabel lblCompany = new JLabel("Company:");
		pnlContactDetails.add(lblCompany);
		JLabel lblAddress1 = new JLabel("Address 1:");
		pnlContactDetails.add(lblAddress1);
		JLabel lblAddress2 = new JLabel("Address 2:");
		pnlContactDetails.add(lblAddress2);
		JLabel lblCity = new JLabel("City:");
		pnlContactDetails.add(lblCity);
		JLabel lblState = new JLabel("State:");
		pnlContactDetails.add(lblState);
		JLabel lblZip = new JLabel("Zip:");
		pnlContactDetails.add(lblZip);
		JLabel lblPhoneHome = new JLabel("Home phone:");
		pnlContactDetails.add(lblPhoneHome);
		JLabel lblPhoneMobile = new JLabel("Mobile phone:");
		pnlContactDetails.add(lblPhoneMobile);
		JLabel lblPhoneOffice = new JLabel("Office phone:");
		pnlContactDetails.add(lblPhoneOffice);
		JLabel lblEmail = new JLabel("Email address:");
		pnlContactDetails.add(lblEmail);
		JLabel lblNotes = new JLabel("Notes:");
		pnlContactDetails.add(lblNotes);

		return pnlContactDetails;
	}

	private JPanel createContactListPanel() {
		JList<String> contactList = new JList<>(names);
		contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contactList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				displayInfo();
			}

			private void displayInfo() {
				int index = contactList.getSelectedIndex();

				txtType.setText(listModel.get(index).getType().toString());
				txtTitle.setText(
						listModel.get(index).getPerson().getTitle().toString());
				txtFirstName.setText(
						listModel.get(index).getPerson().getFirstName());
				txtMiddleName.setText(
						listModel.get(index).getPerson().getMiddleName());
				txtLastName.setText(
						listModel.get(index).getPerson().getLastName());
				txtCompany
						.setText(listModel.get(index).getPerson().getCompany());
				txtAdddress1.setText(
						listModel.get(index).getAddress().getAddress1());
				txtAddress2.setText(
						listModel.get(index).getAddress().getAddress2());
				txtCity.setText(listModel.get(index).getAddress().getCity());
				txtState.setText(listModel.get(index).getAddress().getState()
						.toString());
				txtZip.setText(Integer
						.toString(listModel.get(index).getAddress().getZip()));
				txtPhoneHome.setText(
						listModel.get(index).getPhone().getPhoneHome());
				txtPhoneMobile.setText(
						listModel.get(index).getPhone().getPhoneMobile());
				txtPhoneOffice.setText(
						listModel.get(index).getPhone().getPhoneOffice());
				txtEmailAddress
						.setText(listModel.get(index).getEmail().toString());
				txtNotes.setText(listModel.get(index).getNotes());
			}

		});
		JPanel pnlContactList = new JPanel();
		pnlContactList.setLayout(new GridLayout(0, 1, 0, 0));
		pnlContactList.add(contactList);

		return pnlContactList;
	}

	private static Contact getRandomContact() {
		ContactType[] types = ContactType.values();
		Title[] titles = Title.values();
		State[] states = State.values();

		return new Contact(types[rand.nextInt(types.length)],
				new Person(titles[rand.nextInt(titles.length)], randomFirst(),
						randomMiddle(), randomLast(), randomCompany()),
				new Address(randomAddress1(), randomAddress2(), randomCity(),
						states[rand.nextInt(states.length)], randomZip()),
				new Phone(randomPhone(), randomPhone(), randomPhone()),
				new EmailAddress(randomEmail()), randomNotes());
	}

	public static String randomFirst() {
		Random rand = new Random();
		String[] list = { "Alex", "Charlie", "Dennis", "Eve", "Francine",
				"Gabrielle", "Harold" };
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
		String[] list = { "Lutz", "Miller", "Nester", "Ortega", "Simpson",
				"Mendez", "Anderson", null };
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
