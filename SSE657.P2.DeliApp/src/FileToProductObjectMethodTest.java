import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class FileToProductObjectMethodTest {
	
	//Create a Product object for each file found, the filename is the name of the file, the type is the name of the file's directory

	@Test
	public void testBeefFileToBeefObject() {
		File beefFile = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/Beef/BLondonBroilTopRound.jpg").getPath());
		testing tst = new testing();
		Product bLondonBroil = tst.fileToProductObject(beefFile);
		assertEquals( bLondonBroil.properties.get("name"), "BLondonBroilTopRound.jpg" ); 
		assertEquals( bLondonBroil.properties.get("type"), "Beef" );
	}
	
	@Test
	public void testBolognaFileToBolognaObject() {
		File bolognaFile = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/Bologna/BBeefBologna.jpg").getPath());
		testing tst = new testing();
		Product bBeefBologna = tst.fileToProductObject(bolognaFile);
		assertEquals( bBeefBologna.properties.get("name"), "BBeefBologna.jpg" ); 
		assertEquals( bBeefBologna.properties.get("type"), "Bologna" );
	}

}
