package controler;

import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.InvoiceHeader;
import model.InvoiceLine;
import project.designmodel.Invoicelinetable;
import project.designmodel.MainFrame;

public class TableListener implements ListSelectionListener {
	
	
	private MainFrame frame;
	public TableListener(MainFrame frame) {
		this.frame = frame;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int selected = frame.getHeadertable().getSelectedRow();
		InvoiceHeader inv = frame.getInvoicesArray().get(selected);
		ArrayList<InvoiceLine> lines = inv.getlineslist();
		Invoicelinetable model = new Invoicelinetable(lines);
		frame.getLinestable().setModel(model);
	
	}

	
	
}
