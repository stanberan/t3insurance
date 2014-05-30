import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Testing {

	
	
	public void test(){
		
		
Date date;
try {
	date = new SimpleDateFormat("dd-mm-yy hh:mm:ss").parse("03-05-14 13:22:33");
	System.out.println(new SimpleDateFormat("yyyy-mm-dd").format(date));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
		
	}
	
	
	public static void main (String args[]){
	new Testing().test();
	}
}
