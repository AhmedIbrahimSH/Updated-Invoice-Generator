package project.designmodel;
import project.designmodel.*;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.InvoiceHeader;
import model.InvoiceLine;

import javax.swing.table.AbstractTableModel;

public class Invoiceheadertablemodel extends AbstractTableModel {

    private ArrayList<InvoiceHeader> invoicesheaderArray;
    private String[] columns = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    
   

    public Invoiceheadertablemodel(ArrayList<InvoiceHeader> invoicesArray) {
		this.invoicesheaderArray = invoicesArray;
	}

	@Override
    public int getRowCount() {
        return invoicesheaderArray == null ? 0 :invoicesheaderArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	if(invoicesheaderArray == null) {return "";}
    	else {
        InvoiceHeader inv = invoicesheaderArray.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getNumber();
            case 1: return MainFrame.dateFormat.format(inv.getDateofinvoice());
            case 2: return inv.getCustomer();
            case 3: return inv.getinvoicetotal();
        }}
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
