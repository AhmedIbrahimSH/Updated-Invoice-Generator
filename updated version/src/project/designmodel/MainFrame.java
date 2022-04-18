package project.designmodel;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
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
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controler.*;
public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable linestable;
	private JTextField textField0;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JLabel label2;
	

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
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
	private JTable table_2;
	private JTable table;
	private JTable table_3;
	
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
		lblNewLabel.setBounds(411, 32, 95, 14);
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
		scrollPane_1.setBounds(441, 204, 473, 123);
		contentPane.add(scrollPane_1);
		
		linestable = new JTable();
		scrollPane_1.setViewportView(linestable);
		linestable.setModel(new DefaultTableModel(
			new Object[][] {
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
		
		textField0 = new JTextField();
		textField0.setBounds(513, 29, 31, 20);
		contentPane.add(textField0);
		textField0.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(513, 136, 76, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JLabel label1 = new JLabel();
		label1.setBounds(511, 66, 114, 14);
	    
	    textField1 = new JTextField();
	    textField1.setBounds(512, 63, 145, 20);
	    contentPane.add(textField1);
	    textField1.setColumns(10);
	    
	    textField2 = new JTextField();
	    textField2.setBounds(513, 101, 171, 20);
	    contentPane.add(textField2);
	    textField2.setColumns(10);
	    
	    table_2 = new JTable();
	    table_2.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Number", "Date", "Customer", "Total"
	    	}
	    ));
	    table_2.setBounds(10, 33, 380, 305);
	    contentPane.add(new JScrollPane(table_2));
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 33, 363, 295);
	    contentPane.add(scrollPane);
	    
	    table_3 = new JTable();
	    scrollPane.setViewportView(table_3);
	    table_3.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Number", "Date", "Customer", "Total"
	    	}
	    ));
	    
	    

	}
	
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
				createnewInvoice();
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

	public void createnewInvoice() {
		  JTextField customer = new JTextField(25);
	      JTextField date = new JTextField(25);

	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("Customer"));
	      myPanel.add(customer);
	      myPanel.add(Box.createVerticalStrut(30)); // a spacer
	      myPanel.add(new JLabel("Date"));
	      myPanel.add(date);

	      JOptionPane.showConfirmDialog(null, myPanel,"Please Name of the Customer and Date of invoice in the form dd-mm-yyyy", JOptionPane.OK_CANCEL_OPTION);
	      String newcustomername = customer.getText();
	      String newinvoicedate = date.getText();
	      textField1.setText(newinvoicedate);
	      textField2.setText(newcustomername);
		  JOptionPane.showMessageDialog(this,"Please enter the remaining data in table below ", "Attention", JOptionPane.WARNING_MESSAGE);

	      
	}



	private void savefile() {
		// TODO Auto-generated method stub
		 
		
	}
	
	
	
	//public InvoiceHeader findinvoiceheader(int x) {
			
	//}

	private void openfile() throws Exception {
		JOptionPane.showMessageDialog(this,"Choose Header File AND Make sure it is CSV file", "Attention", JOptionPane.WARNING_MESSAGE);
		JFileChooser filechooser = new JFileChooser();
		int result = filechooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File headerreadingfile = filechooser.getSelectedFile();
			if(checkfiletype(headerreadingfile)) {
			try {
				FileReader header_reader = new FileReader(headerreadingfile);
				BufferedReader headbr = new BufferedReader(header_reader);
				String headertext = null;
				while((headertext = headbr.readLine()) != null) {
					String[] headerwords = headertext.split(",");
					String Number = headerwords[0]; // int number
					String Date = headerwords[1]; //string date  "I made here the date as a string as i had problems changing from date to string"
					String CustomerName = headerwords[2]; // string customer
					int number = Integer.parseInt(Number);
					InvoiceHeader item = new InvoiceHeader(number, Date, CustomerName);
					
				}
				
				JOptionPane.showMessageDialog(this, "Enter the invoiceline file ");
				result = filechooser.showOpenDialog(this);
				if(result == JFileChooser.APPROVE_OPTION) {
					File linesreadingfile = filechooser.getSelectedFile();
					if(!checkfiletype(linesreadingfile)) {
						JOptionPane.showMessageDialog(this,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);
					}
					else {
					BufferedReader linesbr = new BufferedReader(new FileReader(linesreadingfile));
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
				}}
				
			
			}
				
			
				
				
				
			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"FILE NOT FOUND", "Attention", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				JOptionPane.showMessageDialog(this,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);

			}
		}
		// TODO Auto-generated method stub
		
	}

	public boolean checkfiletype(File X) {
		String extension = null;
		String fileName = X.toString();
	    int index = fileName.lastIndexOf('.');
	    if(index > 0) 
	       extension = fileName.substring(index + 1);
	    	if(extension.equals("csv")) {
	    		return true;
	    		}
	    		else
	    			return false;
	    
	    
		// TODO Auto-generated method stub
		
	}
}








	