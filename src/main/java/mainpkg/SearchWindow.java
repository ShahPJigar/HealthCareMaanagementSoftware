package mainpkg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridLayout;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToggleButton;

public class SearchWindow {

	JFrame frame;
	private JTextField FnameText;
	private JTextField LnameText;
	private JTextField AgeText;
	private JTextField EmailText;
	private JTextField pidText;
	JComboBox<String> comboBox;
	Controller c;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void SearchWindow() {
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
	public SearchWindow() {
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

		JLabel lblPatientId = new JLabel("Patient Id");
		frame.getContentPane().add(lblPatientId, "6, 4");

		JLabel lblLastName = new JLabel("Last Name");
		frame.getContentPane().add(lblLastName, "10, 4");

		pidText = new JTextField();
		pidText.setColumns(10);
		frame.getContentPane().add(pidText, "6, 6, fill, default");

		LnameText = new JTextField();
		frame.getContentPane().add(LnameText, "10, 6, 5, 1, fill, default");
		LnameText.setColumns(10);

		JLabel lblPatientName = new JLabel("First Name");
		frame.getContentPane().add(lblPatientName, "6, 10");

		JLabel lblNewLabel = new JLabel("Gender");
		frame.getContentPane().add(lblNewLabel, "10, 10");

		FnameText = new JTextField();
		frame.getContentPane().add(FnameText, "6, 12, 3, 1, fill, default");
		FnameText.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male",
				"Female" }));
		frame.getContentPane().add(comboBox, "10, 12, fill, default");

		JLabel lblAge = new JLabel("Age");
		frame.getContentPane().add(lblAge, "6, 16");

		JLabel lblEmail = new JLabel("Email");
		frame.getContentPane().add(lblEmail, "10, 16");

		AgeText = new JTextField();
		AgeText.setColumns(10);
		frame.getContentPane().add(AgeText, "6, 18, fill, default");

		EmailText = new JTextField();
		EmailText.setColumns(10);
		frame.getContentPane().add(EmailText, "10, 18, 5, 1, fill, default");
		c = new Controller();
		JButton btnSearch_1 = new JButton("Search Patient");

		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				int age = 0;
				String ageStr = AgeText.getText();
				if (comboBox.getSelectedIndex() == 0)
					gender = "M";
				else
					gender = "F";
				if (!ageStr.equals(""))
					age = Integer.parseInt(ageStr);
				Patient p = new Patient(pidText.getText(), FnameText.getText(),
						LnameText.getText(), age, EmailText.getText(), gender);

				TableModel pData = c.getPatientData(p);

				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(pData);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));
			}
		});
		frame.getContentPane().add(btnSearch_1, "8, 22");

	}

}
