package addressBook;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 * Implements an address book application that presents the user with a list of
 * contacts. Contact details are updated when a contact is clicked. The user may
 * add, edit, or delete a contact by clicking the appropriate button.
 * 
 * @author Jeremiah Reynolds
 *
 */
@SuppressWarnings("serial")
public class ContactList extends JFrame {

	private JPanel contentPane;
	private JList<String> contactList;
	private JLabel lblType;
	private JLabel lblTitle;
	private JLabel lblCompany;
	private JLabel lblFirstName;
	private JLabel lblMiddleName;
	private JLabel lblLastName;
	private JLabel lblAddress1;
	private JLabel lblAddress2;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblHomePhone;
	private JLabel lblMobilePhone;
	private JLabel lblOfficePhone;
	private JLabel lblEmail;
	private JLabel lblNotes;
	private JLabel lblTotalContacts;
	private DefaultListModel<String> listModel;
	private int id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ContactList frame = new ContactList();
					Crud.setContactList(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame and adds components.
	 */
	public ContactList() {
		this.setTitle("Contact List");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(300, 100, 750, 600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contactListPanel = newContactListPanel();
		contentPane.add(contactListPanel);

		JPanel contactDetailsPanel = newContactDetailsPanel();
		contentPane.add(contactDetailsPanel);
		List<Contact> contacts = Crud.retrieveContacts();
		contacts.forEach(el -> addNewContact(el));
	}

	private JPanel newContactListPanel() {
		JPanel contactPanel = new JPanel();
		contactPanel.setBounds(5, 5, 309, 561);
		contactPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		contactPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contactPanel.setLayout(null);

		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacts.setBounds(10, 0, 289, 34);
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContacts.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblContacts.setAlignmentX(Component.CENTER_ALIGNMENT);
		contactPanel.add(lblContacts);

		JPanel contactListPanel = new JPanel();
		contactListPanel.setBounds(10, 34, 289, 426);
		contactListPanel
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contactPanel.add(contactListPanel);
		contactListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		contactList = newContactList();
		contactListPanel.add(contactList);

		JLabel lblTotalContacts = newTotalContacts();
		contactPanel.add(lblTotalContacts);

		JPanel buttonsPanel = newButtonsPanel();
		contactPanel.add(buttonsPanel);

		return contactPanel;
	}

	private JList<String> newContactList() {
		listModel = new DefaultListModel<String>();
		contactList = new JList<String>(listModel);
		contactList.addMouseListener(new MouseAdapter() {

			/**
			 * Updates the labels in <code>contactDetailsPanel</code> when the
			 * user clicks on a contact.
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				updateContactDetails();
			}
		});

		contactList.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				updateContactDetails();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				updateContactDetails();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				updateContactDetails();
			}
		});

		return contactList;
	}

	private JLabel newTotalContacts() {
		lblTotalContacts = new JLabel(
				"Total Contacts: " + contactList.getModel().getSize());
		lblTotalContacts.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalContacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalContacts.setBounds(10, 471, 289, 34);
		lblTotalContacts.setBorder(new EmptyBorder(5, 0, 10, 0));
		lblTotalContacts.setAlignmentX(Component.CENTER_ALIGNMENT);
		return lblTotalContacts;
	}

	private JPanel newButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		buttonsPanel.setBounds(10, 505, 289, 45);
		buttonsPanel.setLayout(new GridLayout(0, 3, 10, 0));

		JButton btnAddContact = newBtnAddContact();
		buttonsPanel.add(btnAddContact);

		JButton btnEditContact = newBtnEditContact();
		buttonsPanel.add(btnEditContact);

		JButton btnDeleteContact = newBtnDeleteContact();
		buttonsPanel.add(btnDeleteContact);

		return buttonsPanel;
	}

	private JButton newBtnAddContact() {
		JButton btnAddContact = new JButton("Add");
		btnAddContact.addActionListener(new ActionListener() {

			/**
			 * Opens a contact entry form that allows the user to add a new
			 * contact.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEntry addContactFrame = new ContactEntry(0);
				addContactFrame.setVisible(true);
			}
		});
		return btnAddContact;
	}

	private JButton newBtnEditContact() {
		JButton btnEditContact = new JButton("Edit");
		btnEditContact.addActionListener(new ActionListener() {

			/**
			 * Opens a contact entry form that allows the user to edit a
			 * contact.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEntry editContactFrame = new ContactEntry(id);
				editContactFrame.setVisible(true);
			}
		});
		return btnEditContact;
	}

	private JButton newBtnDeleteContact() {
		JButton btnDeleteContact = new JButton("Delete");
		btnDeleteContact.addActionListener(new ActionListener() {

			/**
			 * Deletes a contact.<br>
			 * The contact is removed from <code>listModel</code>,
			 * <code>contactList</code>, and the <code>ArrayList</code> in the
			 * <code>Contacts</code> class.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contactList.getModel().getSize() > 0) {
					if (JOptionPane.showConfirmDialog(null,
							"Delete this contact?", "Delete Contact",
							JOptionPane.OK_CANCEL_OPTION) == 0) {
						int selectedIndex = contactList.getSelectedIndex();
						if (contactList.getModel().getSize() > 0) {
							if (selectedIndex == 0) {
								Crud.deleteContact(id);
								contactList.setSelectedIndex(selectedIndex + 1);
								lblFirstName.setText(listModel
										.getElementAt(
												contactList.getSelectedIndex())
										.toString());
							} else {
								Crud.deleteContact(id);
								contactList.setSelectedIndex(selectedIndex - 1);
								lblFirstName.setText(listModel
										.getElementAt(
												contactList.getSelectedIndex())
										.toString());
							}
						}
						listModel.remove(selectedIndex);
						lblTotalContacts.setText("Total Contacts: "
								+ contactList.getModel().getSize());
					}
					updateContactDetails();
				}
			}
		});
		return btnDeleteContact;
	}

	/**
	 * Updates the contact details based on the contact selected.
	 */
	public void updateContactDetails() {
		String zip = null;

		if (contactList.getModel().getSize() != 0) {
			listModel.setElementAt(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getFirstName()
							+ " "
							+ Crud.retrieveContacts()
									.get(contactList.getSelectedIndex())
									.getPerson().getLastName(),
					contactList.getSelectedIndex());
		}

		if (contactList.getModel().getSize() == 0) {
			lblType.setText("");
			lblTitle.setText("");
			lblCompany.setText("");
			lblFirstName.setText("");
			lblMiddleName.setText("");
			lblLastName.setText("");
			lblAddress1.setText("");
			lblAddress2.setText("");
			lblCity.setText("");
			lblState.setText("");
			lblZip.setText("");
			lblCity.setText("");
			lblHomePhone.setText("");
			lblMobilePhone.setText("");
			lblOfficePhone.setText("");
			lblEmail.setText("");
			lblNotes.setText("");
		} else {
			id = Crud.retrieveContacts().get(contactList.getSelectedIndex())
					.getId();

			if (Crud.retrieveContacts().get(contactList.getSelectedIndex())
					.getAddress().getZip() == 0) {
				zip = "";
			} else {
				zip = String.valueOf(Crud.retrieveContacts()
						.get(contactList.getSelectedIndex()).getAddress()
						.getZip());
			}

			lblType.setText(Crud.retrieveContacts()
					.get(contactList.getSelectedIndex()).getType().toString());
			lblTitle.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getTitle().toString());
			lblCompany.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getCompany());
			lblFirstName.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getFirstName());
			lblMiddleName.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getMiddleName());
			lblLastName.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getPerson().getLastName());
			lblAddress1.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getAddress().getAddress1());
			lblAddress2.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getAddress().getAddress2());
			lblCity.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getAddress().getCity());
			lblState.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getAddress().getState().toString());
			lblZip.setText(zip);
			lblCity.setText(
					Crud.retrieveContacts().get(contactList.getSelectedIndex())
							.getAddress().getCity());

			if (Crud.retrieveContacts().get(contactList.getSelectedIndex())
					.getPhone().getPhoneHome().isEmpty())
				lblHomePhone.setText("");
			else
				lblHomePhone.setText(toPhoneNumber(Crud.retrieveContacts()
						.get(contactList.getSelectedIndex()).getPhone()
						.getPhoneHome()));
			if (Crud.retrieveContacts().get(contactList.getSelectedIndex())
					.getPhone().getPhoneMobile().isEmpty())
				lblMobilePhone.setText("");
			else
				lblMobilePhone.setText(toPhoneNumber(Crud.retrieveContacts()
						.get(contactList.getSelectedIndex()).getPhone()
						.getPhoneMobile()));
			if (Crud.retrieveContacts().get(contactList.getSelectedIndex())
					.getPhone().getPhoneOffice().isEmpty())
				lblOfficePhone.setText("");
			else
				lblOfficePhone.setText(toPhoneNumber(Crud.retrieveContacts()
						.get(contactList.getSelectedIndex()).getPhone()
						.getPhoneOffice()));
			lblEmail.setText(Crud.retrieveContacts()
					.get(contactList.getSelectedIndex()).getEmail().getEmail());
			lblNotes.setText("<html><p>" + Crud.retrieveContacts()
					.get(contactList.getSelectedIndex()).getNotes() + "</p></html>");
		}
	}

	private JPanel newContactDetailsPanel() {
		final int PADDING = 10;
		JLabel lblTypeLabel;
		JLabel lblTitleLabel;
		JLabel lblCompanyLabel;
		JLabel lblFirstNameLabel;
		JLabel lblMiddleNameLabel;
		JLabel lblLastNameLabel;
		JLabel lblAddress1Label;
		JLabel lblAddress2Label;
		JLabel lblCityLabel;
		JLabel lblStateLabel;
		JLabel lblZipLabel;
		JLabel lblHomePhoneLabel;
		JLabel lblMobilePhoneLabel;
		JLabel lblOfficePhoneLabel;
		JLabel lblEmailLabel;
		JLabel lblNotesLabel;

		JPanel contactDetailsPanel = new JPanel();
		contactDetailsPanel.setBounds(339, 5, 400, 561);
		contactDetailsPanel.setBorder(new EmptyBorder(0, 0, 0, 400));
		SpringLayout sl_contactDetailsPanel = new SpringLayout();
		contactDetailsPanel.setLayout(sl_contactDetailsPanel);

//		lblTypeLabel = new JLabel("Type:");
//		lblTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblTitleLabel = new JLabel("Title:");
//		lblTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblCompanyLabel = new JLabel("Company:");
//		lblCompanyLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblFirstNameLabel = new JLabel("First Name:");
//		lblFirstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblMiddleNameLabel = new JLabel("Middle Name:");
//		lblMiddleNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblLastNameLabel = new JLabel("Last Name:");
//		lblLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblAddress1Label = new JLabel("Address 1:");
//		lblAddress1Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblAddress2Label = new JLabel("Address 2:");
//		lblAddress2Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblCityLabel = new JLabel("City:");
//		lblCityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblStateLabel = new JLabel("State:");
//		lblStateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblZipLabel = new JLabel("Zip:");
//		lblZipLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblHomePhoneLabel = new JLabel("Home Phone:");
//		lblHomePhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblMobilePhoneLabel = new JLabel("Mobile Phone:");
//		lblMobilePhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblOfficePhoneLabel = new JLabel("Office Phone:");
//		lblOfficePhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblEmailLabel = new JLabel("Email:");
//		lblEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblNotesLabel = new JLabel("Notes:");
//		lblNotesLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblTypeLabel = new JLabel("Type: ");
		lblTitleLabel = new JLabel("Title:");
		lblCompanyLabel = new JLabel("Company:");
		lblFirstNameLabel = new JLabel("First Name:");
		lblMiddleNameLabel = new JLabel("Middle Name:");
		lblLastNameLabel = new JLabel("Last Name:");
		lblAddress1Label = new JLabel("Address 1:");
		lblAddress2Label = new JLabel("Address 2:");
		lblCityLabel = new JLabel("City:");
		lblStateLabel = new JLabel("State:");
		lblZipLabel = new JLabel("Zip:");
		lblHomePhoneLabel = new JLabel("Home Phone:");
		lblMobilePhoneLabel = new JLabel("Mobile Phone:");
		lblOfficePhoneLabel = new JLabel("Office Phone:");
		lblEmailLabel = new JLabel("Email:");
		lblNotesLabel = new JLabel("Notes:");

		createPlaceholders();
		
//		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblAddress1.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblAddress2.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblState.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblHomePhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblMobilePhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblOfficePhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblTotalContacts.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel[] labels = { lblTitleLabel, lblCompanyLabel, lblFirstNameLabel,
				lblMiddleNameLabel, lblLastNameLabel, lblAddress1Label,
				lblAddress2Label, lblCityLabel, lblHomePhoneLabel,
				lblMobilePhoneLabel, lblOfficePhoneLabel, lblEmailLabel,
				lblNotesLabel };

		JLabel[] placeholders = { lblType, lblTitle, lblCompany, lblFirstName,
				lblMiddleName, lblLastName, lblAddress1, lblAddress2, lblCity,
				lblHomePhone, lblMobilePhone, lblOfficePhone, lblEmail,
				lblNotes };

		// Positions and adds lblTypeLabel
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblTypeLabel,
				35, SpringLayout.NORTH, contactDetailsPanel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblTypeLabel,
				10, SpringLayout.WEST, contactDetailsPanel);
		contactDetailsPanel.add(lblTypeLabel);

		// Positions and adds labels
		for (int i = 0; i < labels.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, labels[i],
					0, SpringLayout.WEST, contactDetailsPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, labels[i],
					PADDING, SpringLayout.SOUTH,
					contactDetailsPanel.getComponent(i));
			contactDetailsPanel.add(labels[i]);
		}

		// Positions and adds placeholders
		for (int i = 0; i < placeholders.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST,
					placeholders[i], 100, SpringLayout.WEST,
					contactDetailsPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH,
					placeholders[i], 0, SpringLayout.NORTH,
					contactDetailsPanel.getComponent(i));
			contactDetailsPanel.add(placeholders[i]);
		}

		// Positions and adds lblStateLabel
		sl_contactDetailsPanel.putConstraint(SpringLayout.SOUTH, lblStateLabel,
				0, SpringLayout.SOUTH, lblCityLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblStateLabel,
				200, SpringLayout.WEST, lblCityLabel);
		contactDetailsPanel.add(lblStateLabel);

		// Positions and adds lblState
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblState, 0,
				SpringLayout.NORTH, lblStateLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblState, 10,
				SpringLayout.EAST, lblStateLabel);
		contactDetailsPanel.add(lblState);

		// Positions and adds lblZipLabel
		sl_contactDetailsPanel.putConstraint(SpringLayout.SOUTH, lblZipLabel, 0,
				SpringLayout.SOUTH, lblStateLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblZipLabel, 75,
				SpringLayout.WEST, lblStateLabel);
		contactDetailsPanel.add(lblZipLabel);

		// Positions and adds lblZip
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblZip, 0,
				SpringLayout.NORTH, lblZipLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblZip, 10,
				SpringLayout.EAST, lblZipLabel);
		contactDetailsPanel.add(lblZip);

		lblNotes.setVerticalAlignment(SwingConstants.TOP);
		lblNotes.setPreferredSize(new Dimension(275, 200));

		return contactDetailsPanel;
	}

	private void createPlaceholders() {
		lblType = new JLabel("");
		lblTitle = new JLabel("");
		lblCompany = new JLabel("");
		lblFirstName = new JLabel("");
		lblMiddleName = new JLabel("");
		lblLastName = new JLabel("");
		lblAddress1 = new JLabel("");
		lblAddress2 = new JLabel("");
		lblCity = new JLabel("");
		lblState = new JLabel("");
		lblZip = new JLabel("");
		lblHomePhone = new JLabel("");
		lblMobilePhone = new JLabel("");
		lblOfficePhone = new JLabel("");
		lblEmail = new JLabel("");
		lblNotes = new JLabel("");
	}

	/**
	 * Adds a new contact to <code>contactList</code> and updates
	 * <code>lblTotalContacts</code> with the new contact count.
	 * 
	 * @param contact the contact to add to <code>contactList</code>
	 */
	public void addNewContact(Contact contact) {
		listModel.addElement(contact.getPerson().getFirstName() + " "
				+ contact.getPerson().getLastName());
		contactList.setSelectedIndex(listModel.getSize() - 1);
		updateContactDetails();
		lblTotalContacts
				.setText("Total Contacts: " + contactList.getModel().getSize());
	}

	private String toPhoneNumber(String number) {
		number = "(" + number.substring(0, 3) + ")" + number.substring(3, 6)
				+ "-" + number.substring(6);

		return number;
	}
}