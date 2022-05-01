package model;

import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import project.designmodel.MainFrame;


public class LineDialog extends JDialog {
	private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemName;
    private JLabel itemCount;
    private JLabel itemPrice;
    private JButton ok;
    private JButton cancel;
    
    public LineDialog(MainFrame frame) {
        itemNameField = new JTextField(20);
        itemName = new JLabel("Item Name");
        
        itemCountField = new JTextField(20);
        itemCount = new JLabel("Item Count");
        
        itemPriceField = new JTextField(20);
        itemPrice = new JLabel("Item Price");
        
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("okbutton_newline");
        cancel.setActionCommand("cancelbutton_newline");
        
        ok.addActionListener(frame.getActlistener());
        cancel.addActionListener(frame.getActlistener());
        setLayout(new GridLayout(4, 2));
        
        add(itemName);
        add(itemNameField);
        add(itemCount);
        add(itemCountField);
        add(itemPrice);
        add(itemPriceField);
        add(ok);
        add(cancel);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}


