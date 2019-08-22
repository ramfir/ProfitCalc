import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class PurchaseDemand extends Command {
	private int amount;
	private long cost;
	private Date date;

	public int getAmount() {
		return amount;
	}
	public long getCost() {
		return cost;
	}
	public Date getDate() {
		return date;
	}
	public void setAmount(String amount) {
		try {
			this.amount = Integer.parseInt(amount);	
		} catch (NumberFormatException ex) {
			System.out.println("Error: wrong amount input");
		}
	}
	public void setCost(String cost) {
		try {
			long c = Long.parseLong(cost);
			if (c > 0)
				this.cost = c;
		} catch (NumberFormatException ex) {
			System.out.println("Error: wrong cost input");
		}
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
	    result += "Amount: " + amount + "\n";
	    result += "Cost: " + cost + "\n";
	    if (date != null) {
	    	result += "Date: " + new SimpleDateFormat("dd.MM.yyyy").format(date) + "\n";
	    }
	    result += "Status: " + status + "\n";
	    return result;
	}
}