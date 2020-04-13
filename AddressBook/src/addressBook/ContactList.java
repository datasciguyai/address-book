package addressBook;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Jeremiah Reynolds
 *
 */
public class ContactList extends JFrame {

	private JPanel contentPane;
	private JList contactList;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ContactList frame = new ContactList();
					Contacts.setCl(frame);
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
	public ContactList() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel contactListPanel = newContactListPanel();
		contentPane.add(contactListPanel, BorderLayout.WEST);

		JPanel contactDetailsPanel = newContactDetailsPanel();
		contentPane.add(contactDetailsPanel, BorderLayout.EAST);
	}


	public void updateContactList(ContactJeremy c) {
		listModel.addElement(c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName());
		lblTotalContacts.setText("Total Contacts: " + contactList.getModel().getSize());
	}

	private JPanel newContactListPanel() {
		JPanel contactPanel = new JPanel();
		contactPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		contactPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.PAGE_AXIS));

		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContacts.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblContacts.setAlignmentX(Component.CENTER_ALIGNMENT);
		contactPanel.add(lblContacts);

		JPanel contactListPanel = new JPanel();
		contactListPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contactPanel.add(contactListPanel);
		contactListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		contactList = newContactList();
		contactListPanel.add(contactList);
		contactList.setSelectedIndex(0);

		JLabel lblTotalContacts = newTotalContacts();
		contactPanel.add(lblTotalContacts);

		JPanel buttonsPanel = newButtonsPanel();
		contactPanel.add(buttonsPanel);

		return contactPanel;
	}

	private JPanel newButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(0, 50, 10, 50));
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

		JButton btnAddContact = new JButton("Add");
		btnAddContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEntry c = new ContactEntry();
				c.setVisible(true);
			}
		});
		buttonsPanel.add(btnAddContact);

		JButton btnEditContact = new JButton("Edit");
		btnEditContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactEntry c = new ContactEntry();
				c.setVisible(true);

			}
		});

		buttonsPanel.add(btnEditContact);

		JButton btnDeleteContact = new JButton("Delete");
		btnDeleteContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Contacts.deleteContact(listModel.getElementAt(contactList.getSelectedIndex()).toString());
				
				if (contactList.getModel().getSize() > 0) {
					if (contactList.getSelectedIndex() >= 0) {
						int selectedIndex;

						selectedIndex = contactList.getSelectedIndex();
						listModel.remove(selectedIndex);
						lblTotalContacts.setText("Total Contacts: " + contactList.getModel().getSize());

						contactList.setSelectedIndex(selectedIndex - 1);
						lblFirstName.setText(listModel.getElementAt(contactList.getSelectedIndex()).toString());

					}
				}
			}
		});
		buttonsPanel.add(btnDeleteContact);

		return buttonsPanel;
	}

	private JList newContactList() {
		listModel = new DefaultListModel<String>();
		
//		Contacts.createContact("Jeremy", "D", "Reynolds");
//		Contacts.createContact("Adam", "X", "Ross");
//		Contacts.createContact("Professor","", "Posch");
//		Contacts.createContact("Someone","", "Somewhere");
		
//		Contacts.retrieveContact().forEach(c -> listModel.addElement(c.getFirstName() + " " + c.getLastName()));
		contactList = new JList(listModel);
		contactList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblFirstName.setText(Contacts.retrieveContact().get(contactList.getSelectedIndex()).getPerson().getCompany());
				lblMiddleName.setText(Contacts.retrieveContact().get(contactList.getSelectedIndex()).getPerson().getMiddleName());
				lblLastName.setText(Contacts.retrieveContact().get(contactList.getSelectedIndex()).getPerson().getLastName());
			}
		});

		return contactList;
	}

	private JLabel newTotalContacts() {
		lblTotalContacts = new JLabel("Total Contacts: " + contactList.getModel().getSize());
		lblTotalContacts.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblTotalContacts.setAlignmentX(Component.CENTER_ALIGNMENT);
		return lblTotalContacts;
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
		contactDetailsPanel.setBorder(new EmptyBorder(0, 0, 0, 400));
		SpringLayout sl_contactDetailsPanel = new SpringLayout();
		contactDetailsPanel.setLayout(sl_contactDetailsPanel);
		
		lblTypeLabel = new JLabel("Type:");
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

		lblType = new JLabel("Type");
		lblTitle = new JLabel("Title");
		lblCompany = new JLabel("Company");
		lblFirstName = new JLabel("First");
		lblMiddleName = new JLabel("Middle");
		lblLastName = new JLabel("Last");
		lblAddress1 = new JLabel("Address1");
		lblAddress2 = new JLabel("Address2");
		lblCity = new JLabel("Salt Lake City");
		lblState = new JLabel("UT");
		lblZip = new JLabel("84123");
		lblHomePhone = new JLabel("Home Phone");
		lblMobilePhone = new JLabel("Mobile Phone");
		lblOfficePhone = new JLabel("Office Phone");
		lblEmail = new JLabel("jeremy@reynolds.com");
		lblNotes = new JLabel("<html><p>Lorem ipsum dolor sit amet consectetur adipisicing elit."
				+ "Eligendi perspiciatis nobis ut cupiditate rerum necessitatibus minus sint"
				+ "laboriosam placeat alias distinctio nostrum, assumenda sunt, vero quis, dicta repudiandae deserunt beatae!</p><html>");
		
		JLabel[] labels = { lblTitleLabel, lblCompanyLabel, lblFirstNameLabel, lblMiddleNameLabel, lblLastNameLabel,
				lblAddress1Label, lblAddress2Label, lblCityLabel, lblHomePhoneLabel, lblMobilePhoneLabel,
				lblOfficePhoneLabel, lblEmailLabel, lblNotesLabel };

		JLabel[] placeholders = { lblType, lblTitle, lblCompany, lblFirstName, lblMiddleName, lblLastName, lblAddress1,
				lblAddress2, lblCity, lblHomePhone, lblMobilePhone, lblOfficePhone, lblEmail, lblNotes };

		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblTypeLabel, 35, SpringLayout.NORTH,
				contactDetailsPanel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblTypeLabel, 10, SpringLayout.WEST,
				contactDetailsPanel);
		contactDetailsPanel.add(lblTypeLabel);

		for (int i = 0; i < labels.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, labels[i], 0, SpringLayout.WEST,
					contactDetailsPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, labels[i], PADDING, SpringLayout.SOUTH,
					contactDetailsPanel.getComponent(i));
			contactDetailsPanel.add(labels[i]);
		}

		for (int i = 0; i < placeholders.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, placeholders[i], 100, SpringLayout.WEST,
					contactDetailsPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, placeholders[i], 0, SpringLayout.NORTH,
					contactDetailsPanel.getComponent(i));
			contactDetailsPanel.add(placeholders[i]);
		}

		sl_contactDetailsPanel.putConstraint(SpringLayout.SOUTH, lblStateLabel, 0, SpringLayout.SOUTH, lblCityLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblStateLabel, 200, SpringLayout.WEST, lblCityLabel);
		contactDetailsPanel.add(lblStateLabel);

		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblState, 0, SpringLayout.NORTH, lblStateLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblState, 10, SpringLayout.EAST, lblStateLabel);
		contactDetailsPanel.add(lblState);

		sl_contactDetailsPanel.putConstraint(SpringLayout.SOUTH, lblZipLabel, 0, SpringLayout.SOUTH, lblStateLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblZipLabel, 75, SpringLayout.WEST, lblStateLabel);
		contactDetailsPanel.add(lblZipLabel);

		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblZip, 0, SpringLayout.NORTH, lblZipLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblZip, 10, SpringLayout.EAST, lblZipLabel);
		contactDetailsPanel.add(lblZip);

		lblNotes.setVerticalAlignment(SwingConstants.TOP);
		lblNotes.setPreferredSize(new Dimension(275, 200));

		return contactDetailsPanel;
	}
}