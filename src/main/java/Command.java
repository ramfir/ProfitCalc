public abstract class Command {
	protected String name;
	protected Product product;
	protected String status;

	public Product getProduct() {
		return product;
	}
	public String getName() {
		return name;
	}
	public String getStatus() {
		return status;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}