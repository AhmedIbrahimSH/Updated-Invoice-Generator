package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
	private int Number;
	private String dateofinvoice;
	private String Customer;
	private ArrayList<InvoiceLine> list;
	
	public InvoiceHeader(int number, String dateofinvoice, String customer) {
		this.Number = number;
		this.dateofinvoice = dateofinvoice;
		this.Customer = customer;
		list = null;
	}
	
	public InvoiceLine setinvoice(InvoiceLine x) {
		return x;
		
		
	}
	
	

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public String getDateofinvoice() {
		return dateofinvoice;
	}

	public void setDateofinvoice(String dateofinvoice) {
		this.dateofinvoice = dateofinvoice;
	}

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String customer) {
		Customer = customer;
	}

	public double getinvoicetotal() {
		double total = 0;
		for(int i = 0; i < list.size(); i++) {
			total += list.get(i).getItemTotal();
		}
		return total;
	}
	
	
	
	
	
	
}
