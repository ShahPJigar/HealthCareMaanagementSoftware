package mainpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainWindow {

	private JFrame frame;
	private JLabel initializationResult;
	JPanel panel;

	Controller c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
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
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "2, 2, fill, fill");

		 panel = new JPanel();
		tabbedPane.addTab("Initializations", null, panel, null);
		initializationResult = new JLabel("Result");
		initializationResult.setVisible(false);
		JButton btnInitializeDatabase = new JButton("Initialize Database");
		c=new Controller();
		btnInitializeDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.initialize("initialize.sql");
				initializationResult.setText("Database Initialized");
				initializationResult.setVisible(true);

			}
		});


		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInitializeDatabase))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(initializationResult, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addComponent(btnInitializeDatabase)
					.addGap(34)
					.addComponent(initializationResult, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New Patient", null, panel_2, null);
		// panel2.setLayout();

		JButton btnNewButton_2 = new JButton("Add new Patient");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPatients npw = new NewPatients();
				npw.frame.setVisible(true);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnNewButton_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Search", null, panel_3, null);
		// panel2.setLayout();

		JButton btnNewButton_3 = new JButton("Search All Patients");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWindow childwindow = new SearchWindow();
				childwindow.frame.setVisible(true);
			}
		});
		JButton btnNewButton_4 = new JButton("Custom Searches");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomSearchWindow win = new CustomSearchWindow();
				win.frame.setVisible(true);
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(btnNewButton_3);
		panel_3.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Edit", null, panel_4, null);
		// panel2.setLayout();

		JButton btnNewButton_5 = new JButton("Edit Patient Details");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPatients epw = new EditPatients();
				epw.frame.setVisible(true);
			}
		});
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(btnNewButton_5);

	}
}
