package controler;
import model.*;
import project.designmodel.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controllers implements ActionListener{
	private MainFrame frame;
	public Controllers(MainFrame frame) {
        this.frame = frame;
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
		  JOptionPane.showMessageDialog(frame,"Please Name of the Customer and Date of invoice in the form dd-mm-yyyy", "Take Care !", JOptionPane.WARNING_MESSAGE);
	      JOptionPane.showConfirmDialog(null, myPanel,"New Invoice", JOptionPane.OK_CANCEL_OPTION);
	      String newcustomername = customer.getText();
	      String newinvoicedate = date.getText();
	      frame.textField1.setText(newinvoicedate);
	      frame.textField2.setText(newcustomername);
		  JOptionPane.showMessageDialog(frame,"Please enter the remaining data in table in the lower right ", "Attention", JOptionPane.WARNING_MESSAGE);

	      
	}



	public void savefile() {
		// TODO Auto-generated method stub
		 
		
	}
	
	
	
	//public InvoiceHeader findinvoiceheader(int x) {
			
	//}
	
	public void openfile() throws Exception {
		JOptionPane.showMessageDialog(frame,"Choose Header File AND Make sure it is CSV file", "Attention", JOptionPane.WARNING_MESSAGE);
		ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
		JFileChooser filechooser = new JFileChooser();
		int result = filechooser.showOpenDialog(frame);
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
					String Date = headerwords[1]; //Date date 
					String CustomerName = headerwords[2]; // string customer
					int number = Integer.parseInt(Number);
					Date dateofinvoice = frame.dateFormat.parse(Date);
					InvoiceHeader header = new InvoiceHeader(number, dateofinvoice, CustomerName);
                    invoiceHeaders.add(header);
				}
				frame.setInvoicesArray(invoiceHeaders);
				JOptionPane.showMessageDialog(frame, "Enter the invoiceline file ");
				result = filechooser.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION) {
					File linesreadingfile = filechooser.getSelectedFile();
					if(!checkfiletype(linesreadingfile)) {
						JOptionPane.showMessageDialog(frame,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);
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
						InvoiceHeader inv = frame.getInvoiceObj(invoicenum);
                        InvoiceLine line = new InvoiceLine(invoicenum, name , itemprice, itemcount, inv);
                        inv.getlineslist().add(line);
					}
					Invoiceheadertablemodel headerTableModel = new Invoiceheadertablemodel(invoiceHeaders);
	                frame.setHeaderTableModel(headerTableModel);
	                frame.getHeadertable().setModel(headerTableModel);
	                System.out.println("files read");
				}
					
					}
				
			
			}
				
			
				
				
				
			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame,"FILE NOT FOUND", "Attention", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				JOptionPane.showMessageDialog(frame,"Wrong File Format ", "Attention", JOptionPane.WARNING_MESSAGE);

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
