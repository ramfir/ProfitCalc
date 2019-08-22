import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class SalesReport extends Command {
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		try {
			this.date = new SimpleDateFormat("dd.MM.yyyy").parse(date);	
		} catch (ParseException ex) {
			System.out.println("Error: wrong date input");
		}
		
	}

	@Override
	public String toString() {
	    String result = "";
	    result += "Name: " + name + "\n";
	    if (product != null)
	    	result += "Product: " + product.getName() + "\n";
	    if (date != null)
	    	result += "Date: " + new SimpleDateFormat("dd.MM.yyyy").format(date) + "\n";
	    result += "Status: " + status + "\n";
	    return result;
	}
}