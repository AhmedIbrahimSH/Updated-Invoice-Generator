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
public class MainFrame extends JFrame {

	public JPanel contentPane;
	public JLabel label2;
	private JTable headertable;
	private JTable linestable;
	private JLabel numberlabel; 
	private JLabel datelabel; 
	private JLabel namelabel; 
	private JLabel totallabel; 

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
	
	
	private JTable table_2;
	private JTable table;
	
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
		
		openfile.addActionListener(actlistener);
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
		
		exit.addActionListener(actlistener);
		exit.setActionCommand("X");
		
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mnNewMenu.add(exit);
		
		JButton btnNewButton = new JButton("Create New Invoice");
		btnNewButton.addActionListener(actlistener);
		btnNewButton.setActionCommand("Create New Invoice");
		
		btnNewButton.setBounds(41, 354, 160, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Invoice");
		btnNewButton_1.addActionListener(actlistener);
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
		
		JLabel lblNewLabel_4 = new JLabel(" Invoice Items :");
		lblNewLabel_4.setBounds(441, 186, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("New Line");
		btnNewButton_2.addActionListener(actlistener);
		btnNewButton_2.setActionCommand("New Line");
		btnNewButton_2.setBounds(536, 354, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Line");
		btnNewButton_3.addActionListener(actlistener);
		btnNewButton_3.setActionCommand("Delete Line");
		btnNewButton_3.setBounds(701, 354, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel label1 = new JLabel();
		label1.setBounds(511, 66, 114, 14);
	    
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
	    scrollPane.setBounds(10, 33, 382, 293);
	    contentPane.add(scrollPane);
	    
	    headertable = new JTable();
	    headertable.getSelectionModel().addListSelectionListener(tablelistener);
	    scrollPane.setViewportView(headertable);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(445, 213, 460, 113);
	    contentPane.add(scrollPane_1);
	    
	    linestable = new JTable();
	    scrollPane_1.setViewportView(linestable);
	    
	    numberlabel = new JLabel("");
	    numberlabel.setBounds(516, 32, 82, 14);
	    contentPane.add(numberlabel);
	    
	    datelabel = new JLabel("");
	    datelabel.setBounds(516, 66, 82, 14);
	    contentPane.add(datelabel);
	    
	    namelabel = new JLabel("");
	    namelabel.setBounds(515, 104, 125, 14);
	    contentPane.add(namelabel);
	    
	    totallabel = new JLabel("");
	    totallabel.setBounds(516, 139, 58, 14);
	    contentPane.add(totallabel);
	    
	    

	}
	
	private Invoiceheadertablemodel HeaderTableModel;
	private ArrayList<InvoiceHeader> invoicesArray;
	private Controllers actlistener = new Controllers(this);
	private ArrayList<InvoiceLine> linesArray;
	public ArrayList<InvoiceLine> getLinesArray() {
		return linesArray;
	}

	public void setLinesArray(ArrayList<InvoiceLine> linesArray) {
		this.linesArray = linesArray;
	}

	public Controllers getActlistener() {
		return actlistener;
	}

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private TableListener tablelistener = new TableListener(this);

	
	

	public ArrayList<InvoiceHeader> getInvoicesArray() {
		return invoicesArray;
	}

	public void setInvoicesArray(ArrayList<InvoiceHeader> invoicesArray) {
		this.invoicesArray = invoicesArray;
	}
	
	
	
	public JLabel getNumberlabel() {
		return numberlabel;
	}

	public JLabel getDatelabel() {
		return datelabel;
	}
	public JLabel getNamelabel() {
		return namelabel;
	}
	public JLabel getTotallabel() {
		return totallabel;
	}

	

	public void setActlistener(Controllers actlistener) {
		this.actlistener = actlistener;
	}

	public static void setDateFormat(SimpleDateFormat dateFormat) {
		MainFrame.dateFormat = dateFormat;
	}

	public JTable getHeadertable() {
		return headertable;
	}

	public void setHeadertable(JTable headertable) {
		this.headertable = headertable;
	}

	public JTable getLinestable() {
		return linestable;
	}

	public void setLinestable(JTable linestable) {
		this.linestable = linestable;
	}

	public InvoiceHeader getInvoiceObj(int code) {
		for(InvoiceHeader x : invoicesArray) {
			if(x.getNumber() == code)
				return x;
		}
		return null;
	}
	public Invoiceheadertablemodel getHeaderTableModel() {
		return HeaderTableModel;
	}

	public void setHeaderTableModel(Invoiceheadertablemodel headerTableModel) {
		HeaderTableModel = headerTableModel;
	}
}








	