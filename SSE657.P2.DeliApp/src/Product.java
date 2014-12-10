import java.util.Map;

class Product {
	
	private boolean is_marked = false, has_been_picked = false;
	public Map<String, String> properties;
	
	public Product(Map<String, String> properties) {
		this.properties = (Map<String, String>) properties;
	}
	
	public void mark() {
		this.is_marked = true;
	}
	
	public void unmark() {
		this.is_marked = false;
	}
	
	public void markPicked() {
		this.has_been_picked = true;
	}
	
	public void markUnPicked() {
		this.has_been_picked = false;
	}
	
	public boolean isMarked(){
		return this.is_marked;
	}
	
	public boolean hasBeenPicked(){
		return this.has_been_picked;
	}
	
	public Map<?, ?> getProperties() {
		return this.properties;
	}
	
	public boolean isOfType(String type) { //Delegation
		return this.properties.get("type") == type;
	}
	
}
