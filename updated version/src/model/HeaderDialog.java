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

	public HeaderDialog(MainFrame frame) {
		namelabel = new JLabel("Customer Name:");
        newname = new JTextField(20);
        datelabel = new JLabel("Invoice Date:");
        newdate = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("newInvoiceOK");
        cancelBtn.setActionCommand("newInvoiceCancel");
        
        okBtn.addActionListener(frame.getActlistener());
        cancelBtn.addActionListener(frame.getActlistener());
        setLayout(new GridLayout(3, 2));
        
        add(datelabel);
        add(newdate);
       add(namelabel);
       add(newname);
        add(okBtn);
        add(cancelBtn);
        
        pack();
    }

    private void setLayout(GridLayout gridLayout) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getCustNameField() {
        return newname;
    }

    public JTextField getInvDateField() {
        return newdate;
    }
	
	
	
}
