package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
	private int Number;
	private Date dateofinvoice;
	private String Customer;
	private ArrayList<InvoiceLine> list;
	
	public InvoiceHeader(int number, Date dateofinvoice, String customer) {
		this.Number = number;
		this.dateofinvoice = dateofinvoice;
		this.Customer = customer;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public Date getDateofinvoice() {
		return dateofinvoice;
	}

	public void setDateofinvoice(Date dateofinvoice) {
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