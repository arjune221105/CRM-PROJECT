package GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaFileUtility {
	

	
	
	public int toGetRandonNumber() {
		Random r=new Random();
		int ranmdom=r.nextInt(1000);
		return ranmdom;
	}
	
	
	public String toGetSystemDateandStringTime() {
		Date d = new Date();
		System.out.println(d);

		String Date[] = d.toString().split(" ");
		String day = Date[0];
		String month = Date[1];
		String date1 = Date[2];
		String time = Date[3].replace(":", "-");
		String year = Date[5];
		String actualDate = day+" "+month+" "+date1+" "+time+" "+year;
		
		return actualDate;
		
		

	}

}
