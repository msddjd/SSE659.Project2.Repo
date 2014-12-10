import java.util.Map;

class Product {
	
	boolean is_marked = false;
	Map<String, String> properties;
	
	public Product(Map<String, String> properties) {
		this.properties = (Map<String, String>) properties;
	}
	
	public void mark() {
		is_marked = true;
	}
	
	public void unmark() {
		is_marked = false;
	}
	
	public boolean isMarked(){
		return this.is_marked;
	}
	
	public Map<?, ?> getProperties() {
		return this.properties;
	}	
	
}
