import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameEngine {
	
	private	List<Product> Products = new ArrayList<Product>();
	private int state; //0 - Not all products have been picked, 1 - All products have been picked
	private Random generator;
	private int rand_product;
	
	public GameEngine(){
		generator = new Random(System.currentTimeMillis());
	}
	
	public GameEngine(List<Product> Products) {
		this.Products = Products;
		generator = new Random(System.currentTimeMillis());
	}
	
	public Product getUnpicked() {//Get random product that has not been picked before			
		checkState();
		
		if(state == 0){
			do
			rand_product = generator.nextInt(( (Products.size()-1) -0) + 1);			
			while( Products.get(rand_product).hasBeenPicked() );
			
			Products.get(rand_product).markPicked();		
			return Products.get(rand_product);
		}
		else
			return null; //In the even that their are no more un picked products
	}
	
	public Product getUnpicked(String type) { //Get random product of a certain type that has not been picked before
		checkState();		
		if(state == 0) {
			do
			rand_product = generator.nextInt(( (Products.size()-1) -0) + 1);		
			while( Products.get(rand_product).hasBeenPicked() && !Products.get(rand_product).isOfType(type) );
			
			Products.get(rand_product).markPicked();		
			return Products.get(rand_product);
		}
		else
			return null; 		
	}
	
	public Product getProduct(int other_product_index) {//Pick a unique random product		
		do
		rand_product = generator.nextInt(( (Products.size()-1) -0) + 1);
		while(rand_product == other_product_index);
		return Products.get(rand_product);		
	}
	
	public Product getProduct(String type, int other_product_index) {//Pick a unique random product of a certain type
		do
		rand_product = generator.nextInt(( (Products.size()-1) -0) + 1);		
		while( (!Products.get(rand_product).isOfType(type)) || (rand_product == other_product_index) );
		return Products.get(rand_product);		
	}
	
	//Need to make sure second product does not equal first product as well.
	
	public void unMarkAll(){		
		for(int i = 0; i < Products.size(); i++)
		Products.get(i).unmark();				
	}
	
	public void resetPicked(){
		for(int i = 0; i < Products.size(); i++)
		Products.get(i).markUnPicked();				
	}
	
	private void checkState(){ //State Pattern
		for(int i = 0; i < Products.size(); i++)
		{
			if( !Products.get(i).hasBeenPicked() )
				{
					this.state = 0;
					i = Products.size();//terminate				
				}				
			else
				this.state = 1;
		}		
	}
	
	public int getState() {
		return this.state;
	}
	
	public List<Product> getProducts(){
		return this.Products;
	}
}
