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
    private JLabel namelabel;
    private JLabel datelabel;
    private JButton okBtn;
    private JButton cancelBtn;

    public HeaderDialog(MainFrame frame) {
		namelabel = new JLabel("Customer Name:");
        newname = new JTextField(20);
        datelabel = new JLabel("Invoice Date:");
        newdate = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        okBtn.setActionCommand("newInvoiceOKbutton");
        cancelBtn.setActionCommand("newInvoiceCancelbutton");
        okBtn.addActionListener(frame.getActlistener());
        cancelBtn.addActionListener(frame.getActlistener());
        setLayout(new GridLayout(8, 4));
        
        add(datelabel);
        add(newdate);
        add(namelabel);
        add(newname);
        add(okBtn);
        add(cancelBtn);
        
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
