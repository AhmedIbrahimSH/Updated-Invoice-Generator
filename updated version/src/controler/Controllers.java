package controler;
import model.*;
import project.designmodel.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Controllers implements ActionListener{

	public static void main (String[] args) throws ParseException {
		String Date = "12-03-2005";
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(Date);
		System.out.print(date1);

		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
	}

}
