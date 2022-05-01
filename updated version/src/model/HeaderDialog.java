package model;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.designmodel.MainFrame;

public class HeaderDialog extends JDialog {
    private JTextField newname;
    private JTextField newdate;
    private JLabel name;
    private JLabel date;
    private JButton ok;
    private JButton cancel;
    public HeaderDialog(MainFrame frame) {
    	name = new JLabel("Customer Name:");
        newname = new JTextField(20);
        date = new JLabel("Invoice Date:");
        newdate = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        ok.setActionCommand("newInvoiceOKbutton");
        cancel.setActionCommand("newInvoiceCancelbutton");
        ok.addActionListener(frame.getActlistener());
        cancel.addActionListener(frame.getActlistener());
        setLayout(new GridLayout(8, 4));
        add(date);
        add(newdate);
        add(name);
        add(newname);
        add(ok);
        add(cancel);
        pack();
    }
    public JTextField getNewname() {
		return newname;
	}

	public void setNewname(JTextField newname) {
		this.newname = newname;
	}

	public JTextField getNewdate() {
		return newdate;
	}

	public void setNewdate(JTextField newdate) {
		this.newdate = newdate;
	}

	



	public JTextField getCustNameField() {
        return newname;
    }

    public JTextField getInvDateField() {
        return newdate;
    }
	
	
	
}
