public class NewProduct extends Command {
	@Override
	public String toString() {
	    String result = "";
	    result += "Name: " + name + "\n";
	    result += "Product: " + product.getName() + "\n";
	    result += "Status: " + status + "\n";
	    return result;
	}
}