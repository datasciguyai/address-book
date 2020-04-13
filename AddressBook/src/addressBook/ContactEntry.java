package addressBook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactEntry frame = new ContactEntry();
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
	public ContactEntry() {
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

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacts.createContact((ContactType) comboBoxType.getSelectedItem(),
						(Title) comboBoxTitle.getSelectedItem(), textFieldCompany.getText(),
						textFieldFirstName.getText(), textFieldMiddleName.getText(), textFieldLastName.getText(),
						textFieldAddress1.getText(), textFieldAddress2.getText(), textFieldCity.getText(),
						(State) comboBoxState.getSelectedItem(), Integer.valueOf(textFieldZip.getText()),
						textFieldHomePhone.getText(), textFieldMobilePhone.getText(), textFieldOfficePhone.getText(),
						textFieldEmail.getText(), textAreaNotes.getText());
				Contacts.updateContact();
				closeContactEntry();
			}
		});
		buttonPanel.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeContactEntry();
			}
		});
		buttonPanel.add(btnCancel);
	}

	private void closeContactEntry() {
		this.dispose();
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
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, lblTypeLabel, 36, SpringLayout.NORTH,
				contactEntryPanel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, lblTypeLabel, 44, SpringLayout.WEST, contactEntryPanel);
		contactEntryPanel.add(lblTypeLabel);

		for (int i = 0; i < labels.length; i++) {
			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, labels[i], 0, SpringLayout.WEST,
					contactEntryPanel.getComponent(i));
			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, labels[i], PADDING, SpringLayout.SOUTH,
					contactEntryPanel.getComponent(i));
			contactEntryPanel.add(labels[i]);
		}

		comboBoxType = new JComboBox();
		comboBoxType.setModel(new DefaultComboBoxModel(ContactType.values()));
		sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, comboBoxType, 0, SpringLayout.NORTH, lblTypeLabel);
		sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, comboBoxType, 100, SpringLayout.WEST, lblTypeLabel);
		contactEntryPanel.add(comboBoxType);

		comboBoxTitle = new JComboBox();
		comboBoxTitle.setModel(new DefaultComboBoxModel(Title.values()));
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

		comboBoxState = new JComboBox();
		comboBoxState.setModel(new DefaultComboBoxModel(State.values()));
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

//		for (int i = 0; i < values.length; i++) {
//			sl_contactDetailsPanel.putConstraint(SpringLayout.WEST, values[i], 100, SpringLayout.WEST,
//					contactEntryPanel.getComponent(i));
//			sl_contactDetailsPanel.putConstraint(SpringLayout.NORTH, values[i], 0, SpringLayout.NORTH,
//					contactEntryPanel.getComponent(i));
//			values[i].setColumns(35);
//			contactEntryPanel.add(values[i]);
//		}

		return contactEntryPanel;
	}

	/**
	 * @param textFieldCompany the textFieldCompany to set
	 */
	public void setTextFieldCompany(String text) {
		this.textFieldCompany.setText(text);
	}

	/**
	 * @param textFieldFirstName the textFieldFirstName to set
	 */
	public void setTextFieldFirstName(String text) {
		this.textFieldFirstName.setText(text);
	}

	/**
	 * @param textFieldMiddleName the textFieldMiddleName to set
	 */
	public void setTextFieldMiddleName(String text) {
		this.textFieldMiddleName.setText(text);
	}

	/**
	 * @param textFieldLastName the textFieldLastName to set
	 */
	public void setTextFieldLastName(String text) {
		this.textFieldLastName.setText(text);
	}

	/**
	 * @param textFieldAddress1 the textFieldAddress1 to set
	 */
	public void setTextFieldAddress1(String text) {
		this.textFieldAddress1.setText(text);
	}

	/**
	 * @param textFieldAddress2 the textFieldAddress2 to set
	 */
	public void setTextFieldAddress2(String text) {
		this.textFieldAddress2.setText(text);
	}

	/**
	 * @param textFieldCity the textFieldCity to set
	 */
	public void setTextFieldCity(String text) {
		this.textFieldCity.setText(text);
	}

	/**
	 * @param textFieldZip the textFieldZip to set
	 */
	public void setTextFieldZip(String text) {
		this.textFieldZip.setText(text);
	}

	/**
	 * @param textFieldHomePhone the textFieldHomePhone to set
	 */
	public void setTextFieldHomePhone(String text) {
		this.textFieldHomePhone.setText(text);
	}

	/**
	 * @param textFieldMobilePhone the textFieldMobilePhone to set
	 */
	public void setTextFieldMobilePhone(String text) {
		this.textFieldMobilePhone.setText(text);
	}

	/**
	 * @param textFieldOfficePhone the textFieldOfficePhone to set
	 */
	public void setTextFieldOfficePhone(String text) {
		this.textFieldOfficePhone.setText(text);
	}

	/**
	 * @param textFieldEmail the textFieldEmail to set
	 */
	public void setTextFieldEmail(String text) {
		this.textFieldEmail.setText(text);
	}

	/**
	 * @param textAreaNotes the textAreaNotes to set
	 */
	public void setTextAreaNotes(String text) {
		this.textAreaNotes.setText(text);
	}

	/**
	 * @param comboBoxType the comboBoxType to set
	 */
	public void setComboBoxType(JComboBox<ContactType> comboBoxType) {
		this.comboBoxType = comboBoxType;
	}

	/**
	 * @param comboBoxTitle the comboBoxTitle to set
	 */
	public void setComboBoxTitle(JComboBox<Title> comboBoxTitle) {
		this.comboBoxTitle = comboBoxTitle;
	}

	/**
	 * @param comboBoxState the comboBoxState to set
	 */
	public void setComboBoxState(JComboBox<State> comboBoxState) {
		this.comboBoxState = comboBoxState;
	}

}
