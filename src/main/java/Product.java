public class Product {
	private String name;
	private int amount;

	Product(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getAmount() {
		return amount;
	}
	public void setName(String name) {
		this.name = name.toLowerCase();
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
    public int hashCode() { 
        return name.hashCode(); 
    }
    @Override
    public boolean equals(Object obj) {
        return name.equals(((Product) obj).name);
    }
}