import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class LoadProductsRecursivelyTest {
	@Test
	public void testCorrectNumberOfTotalProducts() {
		testing tst = new testing();
		GameEngine engine = new GameEngine();
		int numb_of_products = 84;
		File path = new File(testing.class.getResource("/ProductImages/CensoredImages/").getPath());		
		tst.refactored_loadProducts(path,engine);
		assertEquals(engine.getProducts().size(),numb_of_products);		
	}
}
