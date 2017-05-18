package mainpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.table.TableModel;

import java.awt.ScrollPane;

import javax.swing.SwingConstants;

public class EditPatients {

	JFrame frame;
	private JTable table;
	private Controller c;
	private JTextField idF1;
	private JTextField idF2;
	private JTextField idF3;
	private JTextField idF4;
	private JButton btnAddSymptom;
	private JButton btnAddCondition;
	private JButton btnAddTreatment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatients window = new EditPatients();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditPatients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		c = new Controller();
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 384);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
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
						RowSpec.decode("default:grow"), }));
		
		JButton btnNewButton_1 = new JButton(
				"Edit patient details with ID ");
		frame.getContentPane().add(btnNewButton_1, "4, 6");

		idF1 = new JTextField();
		idF1.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(idF1, "6, 6,fill, default");
		idF1.setColumns(3);

		btnNewButton_1.addActionListener(new ActionListener() {
			int idInput = 0;

			public void actionPerformed(ActionEvent e) {
				String value1 = idF1.getText();
				if (value1.equals("")) {

					JOptionPane.showMessageDialog(null, "Please supply Patient Id.");

				} else {
					System.out.println(value1);
					idInput = Integer.parseInt(value1);
					TableModel p = c.editPatientData(idInput);

					EditTable window = new EditTable();
					window.frame.setVisible(true);

					table = new JTable(p);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					window.frame.getContentPane().add(new JScrollPane(table));
				}
			}
		});
		
		btnAddSymptom = new JButton("Add Symptom");
		frame.getContentPane().add(btnAddSymptom, "2, 8");
		btnAddSymptom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSymptoms nsw = new NewSymptoms();
				nsw.frame.setVisible(true);
			}
		});
		//btnAddSymptom.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnNewButton_2 = new JButton(
				"Edit Symptom of patient with ID ");
		frame.getContentPane().add(btnNewButton_2, "4, 8");

		idF2 = new JTextField();
		idF2.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(idF2, "6, 8,fill, default");
		idF2.setColumns(4);

		btnNewButton_2.addActionListener(new ActionListener() {
			int idInput = 0;

			public void actionPerformed(ActionEvent e) {
				String value2 = idF2.getText();
				if (value2.equals("")) {

					JOptionPane.showMessageDialog(null, "Please supply Patient Id.");

				} else {
					System.out.println(value2);
					idInput = Integer.parseInt(value2);
					TableModel p = c.editSymptomData(idInput);

					EditTable window = new EditTable();
					window.frame.setVisible(true);

					table = new JTable(p);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					window.frame.getContentPane().add(new JScrollPane(table));
				}
			}
		});
		
		btnAddCondition = new JButton("Add Condition");
		frame.getContentPane().add(btnAddCondition, "2, 10");
		btnAddCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewConditions nsw = new NewConditions();
				nsw.frame.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_3 = new JButton(
				"Edit Condition of patient with ID ");
		frame.getContentPane().add(btnNewButton_3, "4, 10");

		idF3 = new JTextField();
		idF3.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(idF3, "6, 10,fill, default");
		idF3.setColumns(4);

		btnNewButton_3.addActionListener(new ActionListener() {
			int idInput = 0;

			public void actionPerformed(ActionEvent e) {
				String value3 = idF3.getText();
				if (value3.equals("")) {

					JOptionPane.showMessageDialog(null, "Please supply Patient Id.");

				} else {
					System.out.println(value3);
					idInput = Integer.parseInt(value3);
					TableModel p = c.editConditionData(idInput);

					EditTable window = new EditTable();
					window.frame.setVisible(true);

					table = new JTable(p);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					window.frame.getContentPane().add(new JScrollPane(table));
				}
			}
		});
		
		btnAddTreatment = new JButton("Add Treatment");
		frame.getContentPane().add(btnAddTreatment, "2, 12");
		btnAddTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTreatments nsw = new NewTreatments();
				nsw.frame.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_4 = new JButton(
				"Edit Treatment of patient with ID ");
		frame.getContentPane().add(btnNewButton_4, "4, 12");

		idF4 = new JTextField();
		idF4.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(idF4, "6, 12,fill, default");
		idF4.setColumns(4);

		btnNewButton_4.addActionListener(new ActionListener() {
			int idInput = 0;

			public void actionPerformed(ActionEvent e) {
				String value4 = idF4.getText();
				if (value4.equals("")) {

					JOptionPane.showMessageDialog(null, "Please supply Patient Id.");

				} else {
					System.out.println(value4);
					idInput = Integer.parseInt(value4);
					TableModel p = c.editTreatmentData(idInput);

					EditTable window = new EditTable();
					window.frame.setVisible(true);

					table = new JTable(p);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					window.frame.getContentPane().add(new JScrollPane(table));
				}
			}
		});
		
	}

}
