package project.designmodel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable invoicesheadertbl;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Design Preview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mainMenuBar = new JMenuBar();
		mainMenuBar.setToolTipText("");
		mainMenuBar.setBounds(0, 0, 31, 22);
		contentPane.add(mainMenuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 33, 401, 305);
		contentPane.add(scrollPane);
		
		invoicesheadertbl = new JTable();
		scrollPane.setViewportView(invoicesheadertbl);
		invoicesheadertbl.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Total", "Customer", "Date", "Number"
			}
		));
		
		JButton btnNewButton = new JButton("Create New Invoice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(41, 354, 160, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Invoice");
		btnNewButton_1.setBounds(228, 354, 125, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Invoice Number :");
		lblNewLabel.setBounds(411, 32, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Invoice Date :");
		lblNewLabel_1.setBounds(411, 66, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name :");
		lblNewLabel_2.setBounds(411, 104, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Invoice Total :");
		lblNewLabel_3.setBounds(411, 139, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(441, 204, 473, 134);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Item Total", "Count", "Item Price", "Item Name", "Number"
			}
		));
		
		JLabel lblNewLabel_4 = new JLabel(" Invoice Items :");
		lblNewLabel_4.setBounds(441, 186, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(536, 354, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.setBounds(701, 354, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(503, 32, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(503, 139, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(503, 66, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(503, 104, 46, 14);
		contentPane.add(lblNewLabel_8);
	}
}
