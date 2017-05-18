package mainpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPatients {

	JFrame frame;
	private JTextField FnameText;
	private JTextField LnameText;
	private JTextField AgeText;
	private JTextField EmailText;
	private JComboBox<String> comboBox;
	JLabel lblResult;
	private Controller c;
	private JLabel lblWarning;

	/**
	 * Launch the application.
	 */
	public void NewPatients() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewPatients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 438);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(41dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("63dlu:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblPatientName = new JLabel("First Name");
		frame.getContentPane().add(lblPatientName, "6, 4");

		JLabel lblLastName = new JLabel("Last Name");
		frame.getContentPane().add(lblLastName, "10, 4");

		FnameText = new JTextField();
		frame.getContentPane().add(FnameText, "6, 6, fill, default");
		FnameText.setColumns(10);

		LnameText = new JTextField();
		frame.getContentPane().add(LnameText, "10, 6, 5, 1, fill, default");
		LnameText.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		frame.getContentPane().add(lblAge, "6, 10");

		JLabel lblNewLabel = new JLabel("Gender");
		frame.getContentPane().add(lblNewLabel, "10, 10");

		AgeText = new JTextField();
		AgeText.setColumns(10);
		frame.getContentPane().add(AgeText, "6, 12, fill, default");

		// spinner = new JSpinner();
		// spinner.setModel(new SpinnerNumberModel(new Short((short) 45), new
		// Short((short) 0), new Short((short) 150), new Short((short) 1)));
		// frame.getContentPane().add(spinner, "6, 14");
		lblResult = new JLabel("Result");
		frame.getContentPane().add(lblResult, "6, 24");

		lblResult.setVisible(false);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Male", "Female" }));
		frame.getContentPane().add(comboBox, "10, 12, fill, default");

		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail, "6, 16");

		JButton btnSearch_1 = new JButton("Add Patient");

		lblWarning = new JLabel("Warning");
		frame.getContentPane().add(lblWarning, "8, 26");
		lblWarning.setVisible(false);
		c = new Controller();
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWarning.setVisible(false);
				lblWarning.setText("");
				String gender = null;// '\u0000';
				int age = -1;
				String fnme = FnameText.getText();
				String lnme = LnameText.getText();
				String ageStr = AgeText.getText();
				String email = EmailText.getText();
				int index = comboBox.getSelectedIndex();
				System.out.println(lnme);
				if ((index == -1) || (ageStr.equals("")) || (fnme.equals(""))
						|| (lnme == null) || (email == null)) {
					lblWarning
							.setText("All Fields are mandatory.Please supply values");
					lblWarning.setVisible(true);
				} else {
					if (index == 0)
						gender = "M";
					else if (index == 1)
						gender = "F";
					age = Integer.parseInt(ageStr);
					Patient p = new Patient("", fnme, lnme, age, email, gender);
					int nid = c.newPatientData(p);
					String restext = "Added New Patient- " + nid;
					lblResult.setText(restext);
					lblResult.setVisible(true);
				}
			}
		});

		EmailText = new JTextField();
		EmailText.setColumns(10);
		frame.getContentPane().add(EmailText, "6, 18, fill, default");
		frame.getContentPane().add(btnSearch_1, "8, 22");

	}

}
