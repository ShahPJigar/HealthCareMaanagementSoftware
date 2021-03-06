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

public class NewConditions {

	JFrame frame;
	private JTextField ConditionText;
	private JTextField StartDate;
	private JTextField EndDate;
	private JTextField EmailText;
	private JComboBox<String> comboBox;
	JLabel lblResult;
	private Controller c;
	private JLabel lblWarning;
	private JLabel lblConditions;

	/**
	 * Launch the application.
	 */
	public void NewConditions() {
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
	public NewConditions() {
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
										
										lblConditions = new JLabel("Conditions");
										frame.getContentPane().add(lblConditions, "6, 4");
										
										ConditionText = new JTextField();
										frame.getContentPane().add(ConditionText, "6, 6, fill, default");
										ConditionText.setColumns(10);
				
						JLabel lblStartDate = new JLabel("Start Date");
						frame.getContentPane().add(lblStartDate, "6, 10");
		
				JLabel lblEndDate = new JLabel("End Date");
				frame.getContentPane().add(lblEndDate, "10, 10");
				
						StartDate = new JTextField();
						frame.getContentPane().add(StartDate, "6, 12, fill, default");
						StartDate.setColumns(10);
		
				//JLabel lblNewLabel = new JLabel("Gender");
				//frame.getContentPane().add(lblNewLabel, "10, 10");
		
				EndDate = new JTextField();
				EndDate.setColumns(10);
				frame.getContentPane().add(EndDate, "10, 12, fill, default");

		// spinner = new JSpinner();
		// spinner.setModel(new SpinnerNumberModel(new Short((short) 45), new
		// Short((short) 0), new Short((short) 150), new Short((short) 1)));
		// frame.getContentPane().add(spinner, "6, 14");
		lblResult = new JLabel("Result");
		frame.getContentPane().add(lblResult, "6, 24");

		lblResult.setVisible(false);

		//comboBox = new JComboBox<String>();
		//comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
		//		"Male", "Female" }));
		//frame.getContentPane().add(comboBox, "10, 12, fill, default");

		//JLabel lblEmail = new JLabel("Email");
		//frame.getContentPane().add(lblEmail, "6, 16");

		JButton btnSearch_1 = new JButton("Add Condition");

		lblWarning = new JLabel("Warning");
		frame.getContentPane().add(lblWarning, "8, 26");
		lblWarning.setVisible(false);
		c = new Controller();
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWarning.setVisible(false);
				lblWarning.setText("");
				//String gender = null;// '\u0000';
				//int age = -1;
				String cond = ConditionText.getText();
				String sdate = StartDate.getText();
				String edate = EndDate.getText();
				//String email = EmailText.getText();
				//int index = comboBox.getSelectedIndex();
				System.out.println(cond);
				if ((cond.equals("")) || (sdate.equals(""))) {
					lblWarning
							.setText("Add Condition and Start Date.");
					lblWarning.setVisible(true);
				} else {
					//age = Integer.parseInt(edate);
					Condition cd = new Condition("", "", cond, sdate,edate);
					int nid = c.newConditionData(cd);
					String restext = "Added New Condition- " + nid;
					lblResult.setText(restext);
					lblResult.setVisible(true);
				}
			}
		});

		frame.getContentPane().add(btnSearch_1, "8, 22");

	}

}
