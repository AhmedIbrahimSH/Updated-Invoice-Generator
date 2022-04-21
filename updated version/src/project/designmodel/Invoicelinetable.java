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

public class Invoicelinetable  extends AbstractTableModel  {

	private ArrayList<InvoiceLine> linesArray;
    private String[] columns = {"Number" ,"Item Name", "Unit Price", "Count", "Line Total"};

    public Invoicelinetable(ArrayList<InvoiceLine> linesArray) {
        this.linesArray = linesArray;
    }
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		 return linesArray.size();
		 }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		  InvoiceLine inv = linesArray.get(rowIndex);
	        switch (columnIndex) {
	            case 0: return inv.getNumber();
	            case 1: return inv.getItemName();
	            case 2: return inv.getItemPrice();
	            case 3: return inv.getCount();
	            case 4 : return inv.getItemTotal();
	        }
	        return "";
	}
	
	@Override
    public String getColumnName(int column) {
        return columns[column];
    }

}

