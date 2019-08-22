import java.util.Set;
import java.util.HashSet;

public class ProductsSet {
	private static ProductsSet singleton;
	private Set<Product> set;

	private ProductsSet() {
		set = new HashSet<Product>();
	}
	public static synchronized ProductsSet getInstance() {
		if (singleton == null) {
			singleton = new ProductsSet();
		}
		return singleton;
	}
	public Set<Product> getSet() {
		return set;
	}
	public void setSetnull() { singleton = null; }
}