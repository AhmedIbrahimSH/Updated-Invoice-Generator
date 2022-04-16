package project.designmodel;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable invoicesheadertbl;
	private JTable table;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField0;
	private JTextField textField;

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
		
		JMenuItem openfile = new JMenuItem("load file");
		
		openfile.addActionListener(this);
		openfile.setActionCommand("O");
		
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		openfile.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu.add(openfile);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(this);
		exit.setActionCommand("X");
		
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mnNewMenu.add(exit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 33, 401, 305);
		contentPane.add(scrollPane);
		
		invoicesheadertbl = new JTable();
		invoicesheadertbl.setColumnSelectionAllowed(true);
		invoicesheadertbl.setCellSelectionEnabled(true);
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
				"Number", "Date", "Customer", "Total"
			}
		));
		
		JButton btnNewButton = new JButton("Create New Invoice");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("Create New Invoice");
		
		btnNewButton.setBounds(41, 354, 160, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Invoice");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("Delete Invoice");
		
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
				"Number", "Item Name", "Item Price", "Count", "Item Total"
			}
		));
		
		JLabel lblNewLabel_4 = new JLabel(" Invoice Items :");
		lblNewLabel_4.setBounds(441, 186, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setActionCommand("Save");
		btnNewButton_2.setBounds(536, 354, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setActionCommand("Cancel");
		btnNewButton_3.setBounds(701, 354, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(503, 139, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField1 = new JTextField();
		textField1.setBounds(503, 63, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(503, 101, 122, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField0 = new JTextField();
		textField0.setBounds(503, 29, 31, 20);
		contentPane.add(textField0);
		textField0.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(503, 136, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case"O":
			try {
				openfile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
				
			case "S":
				savefile();
				break;
			
				
				
			case "Create New Invoice":
			
		    
				//createnew();
				break;
			
			
			
			case "Delete Invoice":
				
				break;
			case "Save":
	
				break;
			case "Cancel":
				System.exit(0);
				break;
				
			case "X":
				System.exit(0);
				break;
				}
		
		
	}

	//private void createnew() {
		//Date date1 = null;
	//	String Number = JOptionPane.showInputDialog("Enter Number of Invoice : ");
	//	/String date =  JOptionPane.showInputDialog("Enter Date in format dd/mm/yyyy");
	//	String Name = JOptionPane.showInputDialog("Enter Name of customer : ");
		//int x = Integer.parseInt(Number);
		//try {
		//	date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		//} catch (ParseException e1) {
		//	// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		// TODO Auto-generated method stub
		
	//}

	private void savefile() {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	//public InvoiceHeader findinvoiceheader(int x) {
			
	//}

	private void openfile() throws Exception {
		JOptionPane.showMessageDialog(this,"Choose Header File", "Attention", JOptionPane.WARNING_MESSAGE);
		JFileChooser file1 = new JFileChooser();
		int result = file1.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File readingfile = file1.getSelectedFile();
			try {
				FileReader head = new FileReader(readingfile);
				BufferedReader headbr = new BufferedReader(head);
				String text1 = null;
				while((text1 = headbr.readLine()) != null) {
					String[] words = text1.split(",");
					String Number = words[0];
					String Date = words[1]; // 12-03-2002
					String Customer = words[2];
					JOptionPane.showMessageDialog(this, Date);
					int number = Integer.parseInt(Number);
					InvoiceHeader item = new InvoiceHeader(number, Date, Customer);
				}
				
				JOptionPane.showMessageDialog(this, "Enter the invoiceline file ");
				result = file1.showOpenDialog(this);
				if(result == JFileChooser.APPROVE_OPTION) {
					File fileline = file1.getSelectedFile();
					BufferedReader linesbr = new BufferedReader(new FileReader(fileline));
					String linesfile = null;
					while((linesfile = linesbr.readLine()) != null) {
						String[] lineswords = linesfile.split(",");
						String number = lineswords[0];
						String name = lineswords[1];
						String price = lineswords[2];
						String count = lineswords[3];
						int invoicenum = Integer.parseInt(number);
						double itemprice = Double.parseDouble(price);
						int itemcount = Integer.parseInt(count);
						

					

					}
				}
				
				
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"FILE NOT FOUND", "Attention", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		
	}
}
