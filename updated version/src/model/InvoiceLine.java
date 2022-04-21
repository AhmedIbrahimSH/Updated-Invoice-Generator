package model;

public class InvoiceLine {
		private int Number;
		private String ItemName;
		private double ItemPrice;
		private int count;
		private InvoiceHeader header;
		
		public InvoiceLine(int number, String itemName, double itemPrice, int count,InvoiceHeader header ) {
			this.Number = number;
			this.ItemName = itemName;
			this.ItemPrice = itemPrice;
			this.count = count;
			this.header = header; 
			
		}

		public int getNumber() {
			return Number;
		}

		public InvoiceHeader getHeader() {
			return header;
		}

		public void setHeader(InvoiceHeader header) {
			this.header = header;
		}

		public void setNumber(int number) {
			Number = number;
		}

		public String getItemName() {
			return ItemName;
		}

		public void setItemName(String itemName) {
			ItemName = itemName;
		}

		public double getItemPrice() {
			return ItemPrice;
		}

		public void setItemPrice(double itemPrice) {
			ItemPrice = itemPrice;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public double getItemTotal() {
			return ItemPrice * count;
		}

		@Override
		public String toString() {
			return "InvoiceLine [Number=" + Number + ", ItemName=" + ItemName + ", ItemPrice=" + ItemPrice + ", count="
					+ count + ", header=" + header + "]";
		}

		
		
		
		
}
