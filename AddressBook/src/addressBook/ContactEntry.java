package addressBook;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Implements a GUI form that allows the user to add a new contact or to update
 * an existing contact.
 * 
 * @author Jeremiah Reynolds
 *
 */
public class ContactEntry extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCompany;
	private JTextField textFieldFirstName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress1;
	private JTextField textFieldAddress2;
	private JTextField textFieldCity;
	private JTextField textFieldZip;
	private JTextField textFieldHomePhone;
	private JTextField textFieldMobilePhone;
	private JTextField textFieldOfficePhone;
	private JTextField textFieldEmail;
	private JTextArea textAreaNotes;
	private JComboBox<ContactType> comboBoxType;
	private JComboBox<Title> comboBoxTitle;
	private JComboBox<State> comboBoxState;
	int id;
	Contact contact;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactEntry frame = new ContactEntry(0);
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
	public ContactEntry(int id) {
		this.id = id;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel contactEntryPanel = newContactEntryPanel();
		contentPane.add(contactEntryPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton btnSave = newBtnSave();
		buttonPanel.add(btnSave);

		JButton btnCancel = newBtnCancel();
		buttonPanel.add(btnCancel);

		if (id != 0) {
			Crud.retrieveContacts().forEach(c -> {
				if (c.getId() == id) {
					contact = c;
				}
			});
			populateForm();
		}
	}

	private void populateForm() {
		comboBoxType.setSelectedItem(contact.getType());
		comboBoxTitle.setSelectedItem(contact.getPerson().getTitle());
		textFieldCompany.setText(contact.getPerson().getCompany());
		textFieldFirstName.setText(contact.getPerson().getFirstName());
		textFieldMiddleName.setText(contact.getPerson().getMiddleName());
		textFieldLastName.setText(contact.getPerson().getLastName());
		textFieldAddress1.setText(contact.getAddress().getAddress1());
		textFieldAddress2.setText(contact.getAddress().getAddress2());
		textFieldCity.setText(contact.getAddress().getCity());
		comboBoxState.setSelectedItem(contact.getAddress().getState());
		textFieldZip.setText(String.valueOf(contact.getAddress().getZip()));
		textFieldHomePhone.setText(contact.getPhone().getPhoneHome());
		textFieldMobilePhone.setText(contact.getPhone().getPhoneMobile());
		textFieldOfficePhone.setText(contact.getPhone().getPhoneOffice());
		textFieldEmail.setText(contact.getEmail().getEmail());
		textAreaNotes.setText(contact.getNotes());
	}

	private JPanel newContactEntryPanel() {
		final int PADDING = 15;

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

		JPanel contactEntryPanel = new JPanel();
		SpringLayout sl_contactDetailsPanel = new SpringLayout();
		contactEntryPanel.setLayout(sl_contactDetailsPanel);

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

		JLabel[] labels = { lblTitleLabel, lblCompanyLabel, lblFirstNameLabel, lblMiddleNameLabel, lblLastNameLabel,
				lblAddress1Label, lblAddress2Label, lblCityLabel, lblHomePhoneLabel, lblMobilePhoneLabel,
				lblOfficePhoneLabel, lblEmailLabel, lblNotesLabel };

//		JTextField[] values = { textFieldCompany, textFieldFirstName, textFieldMiddleName, textFieldLastName };

		// Positions and adds lblTypeLabel
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblTypeLabel, 36, SpringLayout.NORTH,
				contactEntryPanel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblTypeLabel, 44, SpringLayout.WEST, contactEntryPanel);
		contactEntryPanel.add(lblTypeLabel);

		// Positions and adds labels
		for (int i = 0; i < labels.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, labels[i], 0, SpringLayout.WEST,
					contactEntryPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, labels[i], PADDING, SpringLayout.SOUTH,
					contactEntryPanel.getComponent(i));
			contactEntryPanel.add(labels[i]);
		}

		comboBoxType = new JComboBox<ContactType>();
		comboBoxType.setModel(new DefaultComboBoxModel<ContactType>(ContactType.values()));
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, comboBoxType, 0, SpringLayout.NORTH, lblTypeLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, comboBoxType, 100, SpringLayout.WEST, lblTypeLabel);
		contactEntryPanel.add(comboBoxType);

		comboBoxTitle = new JComboBox<Title>();
		comboBoxTitle.setModel(new DefaultComboBoxModel<Title>(Title.values()));
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, comboBoxTitle, 0, SpringLayout.NORTH, lblTitleLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, comboBoxTitle, 100, SpringLayout.WEST, lblTitleLabel);
		contactEntryPanel.add(comboBoxTitle);

		textFieldCompany = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldCompany, 0, SpringLayout.NORTH,
				lblCompanyLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldCompany, 100, SpringLayout.WEST,
				lblCompanyLabel);
		contactEntryPanel.add(textFieldCompany);
		textFieldCompany.setColumns(35);

		textFieldFirstName = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldFirstName, 0, SpringLayout.NORTH,
				lblFirstNameLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldFirstName, 100, SpringLayout.WEST,
				lblFirstNameLabel);
		contactEntryPanel.add(textFieldFirstName);
		textFieldFirstName.setColumns(35);

		textFieldMiddleName = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldMiddleName, 0, SpringLayout.NORTH,
				lblMiddleNameLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldMiddleName, 100, SpringLayout.WEST,
				lblMiddleNameLabel);
		contactEntryPanel.add(textFieldMiddleName);
		textFieldMiddleName.setColumns(35);

		textFieldLastName = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldLastName, 0, SpringLayout.NORTH,
				lblLastNameLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldLastName, 100, SpringLayout.WEST,
				lblLastNameLabel);
		contactEntryPanel.add(textFieldLastName);
		textFieldLastName.setColumns(35);

		textFieldAddress1 = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldAddress1, 0, SpringLayout.NORTH,
				lblAddress1Label);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldAddress1, 100, SpringLayout.WEST,
				lblAddress1Label);
		contactEntryPanel.add(textFieldAddress1);
		textFieldAddress1.setColumns(35);

		textFieldAddress2 = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldAddress2, 0, SpringLayout.NORTH,
				lblAddress2Label);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldAddress2, 100, SpringLayout.WEST,
				lblAddress2Label);
		contactEntryPanel.add(textFieldAddress2);
		textFieldAddress2.setColumns(35);

		textFieldCity = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldCity, 0, SpringLayout.NORTH, lblCityLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldCity, 100, SpringLayout.WEST, lblCityLabel);
		contactEntryPanel.add(textFieldCity);
		textFieldCity.setColumns(10);

		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblStateLabel, 0, SpringLayout.NORTH, textFieldCity);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblStateLabel, 125, SpringLayout.WEST, textFieldCity);
		contactEntryPanel.add(lblStateLabel);

		comboBoxState = new JComboBox<State>();
		comboBoxState.setModel(new DefaultComboBoxModel<State>(State.values()));
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, comboBoxState, 0, SpringLayout.NORTH, lblStateLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, comboBoxState, 50, SpringLayout.WEST, lblStateLabel);
		contactEntryPanel.add(comboBoxState);

		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblZipLabel, 0, SpringLayout.NORTH, comboBoxState);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblZipLabel, 60, SpringLayout.WEST, comboBoxState);
		contactEntryPanel.add(lblZipLabel);

		textFieldZip = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldZip, 0, SpringLayout.NORTH, lblZipLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldZip, 30, SpringLayout.WEST, lblZipLabel);
		contactEntryPanel.add(textFieldZip);
		textFieldZip.setColumns(10);

		textFieldHomePhone = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldHomePhone, 0, SpringLayout.NORTH,
				lblHomePhoneLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldHomePhone, 100, SpringLayout.WEST,
				lblHomePhoneLabel);
		contactEntryPanel.add(textFieldHomePhone);
		textFieldHomePhone.setColumns(10);

		textFieldMobilePhone = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldMobilePhone, 0, SpringLayout.NORTH,
				lblMobilePhoneLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldMobilePhone, 100, SpringLayout.WEST,
				lblMobilePhoneLabel);
		contactEntryPanel.add(textFieldMobilePhone);
		textFieldMobilePhone.setColumns(10);

		textFieldOfficePhone = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldOfficePhone, 0, SpringLayout.NORTH,
				lblOfficePhoneLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldOfficePhone, 100, SpringLayout.WEST,
				lblOfficePhoneLabel);
		contactEntryPanel.add(textFieldOfficePhone);
		textFieldOfficePhone.setColumns(10);

		textFieldEmail = new JTextField();
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textFieldEmail, 0, SpringLayout.NORTH, lblEmailLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textFieldEmail, 100, SpringLayout.WEST, lblEmailLabel);
		contactEntryPanel.add(textFieldEmail);
		textFieldEmail.setColumns(35);

		textAreaNotes = new JTextArea();
		textAreaNotes.setRows(10);
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, textAreaNotes, 0, SpringLayout.NORTH, lblNotesLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, textAreaNotes, 100, SpringLayout.WEST, lblNotesLabel);
		contactEntryPanel.add(textAreaNotes);
		textAreaNotes.setColumns(35);

		return contactEntryPanel;
	}

	private JButton newBtnSave() {
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {

			/**
			 * Saves a new contact.
			 */
			public void actionPerformed(ActionEvent e) {
				int zip = 0;

				if (id == 0) {
					if (textFieldFirstName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter a minimum of a first name.");
					} else {
						if (!textFieldZip.getText().isEmpty()) {
							zip = Integer.valueOf(textFieldZip.getText());
						}
						Crud.createContact((ContactType) comboBoxType.getSelectedItem(),
								(Title) comboBoxTitle.getSelectedItem(), textFieldCompany.getText(),
								textFieldFirstName.getText(), textFieldMiddleName.getText(),
								textFieldLastName.getText(), textFieldAddress1.getText(), textFieldAddress2.getText(),
								textFieldCity.getText(), (State) comboBoxState.getSelectedItem(), zip,
								textFieldHomePhone.getText(), textFieldMobilePhone.getText(),
								textFieldOfficePhone.getText(), textFieldEmail.getText(), textAreaNotes.getText());
						closeContactEntry();
					}
				} else {
					if (textFieldFirstName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter a minimum of a first name.");
					} else {
						if (!textFieldZip.getText().isEmpty()) {
							zip = Integer.valueOf(textFieldZip.getText());
						}
						Crud.updateContact(id, (ContactType) comboBoxType.getSelectedItem(),
								(Title) comboBoxTitle.getSelectedItem(), textFieldCompany.getText(),
								textFieldFirstName.getText(), textFieldMiddleName.getText(),
								textFieldLastName.getText(), textFieldAddress1.getText(), textFieldAddress2.getText(),
								textFieldCity.getText(), (State) comboBoxState.getSelectedItem(), zip,
								textFieldHomePhone.getText(), textFieldMobilePhone.getText(),
								textFieldOfficePhone.getText(), textFieldEmail.getText(), textAreaNotes.getText());
						closeContactEntry();
					}
				}
			}
		});
		return btnSave;
	}

	private JButton newBtnCancel() {
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			/**
			 * Closes this frame.
			 */
			public void actionPerformed(ActionEvent e) {
				closeContactEntry();
			}
		});
		return btnCancel;
	}

	private void closeContactEntry() {
		this.dispose();
	}
}
