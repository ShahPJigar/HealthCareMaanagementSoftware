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

public class CustomSearchWindow {

	JFrame frame;
	private JTable table;
	private Controller c;
	private JTextField idF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomSearchWindow window = new CustomSearchWindow();
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
	public CustomSearchWindow() {
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

		JButton btnSearchPatientsHaving = new JButton(
				"Search Patients having Cough and Diabetes now");

		frame.getContentPane().add(btnSearchPatientsHaving, "4, 2");

		JButton btnNewButton = new JButton(
				"Search patients had who had Diabetes and not now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel p = c.getPrevDiabetesPatients();

				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(p);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));
			}
		});

		frame.getContentPane().add(btnNewButton, "4, 4");

		JButton btnNewButton_1 = new JButton(
				"Sender who sent most number of messages to patient with ID ");
		frame.getContentPane().add(btnNewButton_1, "4, 6");

		idF = new JTextField();
		idF.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(idF, "6, 6,fill, default");
		idF.setColumns(3);

		btnNewButton_1.addActionListener(new ActionListener() {
			int idInput = 0;

			public void actionPerformed(ActionEvent e) {
				String value = idF.getText();
				if (value.equals("")) {

					JOptionPane.showMessageDialog(null, "Please supply Patient Id.");

				} else {
					System.out.println(value);
					idInput = Integer.parseInt(value);
					TableModel p = c.getMaxSenderToId(idInput);

					ResultTable window = new ResultTable();
					window.frame.setVisible(true);

					table = new JTable(p);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					window.frame.getContentPane().add(new JScrollPane(table));
				}
			}
		});

		JButton btnNewButton_2 = new JButton(
				"Physical Therapy patients who did not send any messages");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel p = c.nonSendendingPTPatients();
				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(p);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));

			}
		});

		frame.getContentPane().add(btnNewButton_2, "4, 8");

		JButton btnNewButton_3 = new JButton("Find Second Oldest Patients");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel p = c.getSecondOldestPatients();

				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(p);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));
			}
		});
		frame.getContentPane().add(btnNewButton_3, "4, 10");

		JButton btnFemalePatientsWho = new JButton(
				"Female Patients who sent messages to diabetic patient");
		btnFemalePatientsWho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel p = c.FemaleSendersToDiabetic();

				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(p);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));

			}
		});
		frame.getContentPane().add(btnFemalePatientsWho, "4, 12");

		/*JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnSearch, "4, 16");*/

		btnSearchPatientsHaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel p = c.getCandFPatients();

				ResultTable window = new ResultTable();
				window.frame.setVisible(true);

				table = new JTable(p);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				window.frame.getContentPane().add(new JScrollPane(table));
			}
		});

	}

}
