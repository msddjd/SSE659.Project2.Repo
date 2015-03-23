import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class contentsMethodShouldListContentsOfDirectory {
	
	//1. GetListofFolders within a Folder, those names represent types

	@Test
	public void testCorrectNumberOfMeatFolders() {
		testing tst = new testing();
		File path = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/").getPath());
		File[] contents = tst.contents(path);
		assertEquals(7,contents.length);
	}
	
	@Test
	public void testCorrectNameAndOrderOfMeatFolders() {
		testing tst = new testing();
		File path = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/").getPath());
		File[] contents = tst.contents(path);			
		assertEquals(contents[0].getName(),"Beef");
		assertEquals(contents[1].getName(),"Bologna");
		assertEquals(contents[2].getName(),"Chicken");
		assertEquals(contents[3].getName(),"Ham");
		assertEquals(contents[4].getName(),"Italian");
		assertEquals(contents[5].getName(),"Turkey");
		assertEquals(contents[6].getName(),"Wurst");
	}
	
	//2. Visit each type folder and get name of all the files, those files are also name of all the products
	
	@Test
	public void testCorrectNumberOfBeefFiles() {
		testing tst = new testing();
		File path = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/Beef/").getPath());
		File[] contents = tst.contents(path);
		assertEquals(8,contents.length);		
	}
	
	@Test
	public void testCorrectNameAndOrderOfBeefs() {
		testing tst = new testing();
		File path = new File(testing.class.getResource("/ProductImages/CensoredImages/Meats/Beef/").getPath());
		File[] contents = tst.contents(path);
		assertEquals(contents[0].getName(),"BLondonBroilTopRound.jpg");
		assertEquals(contents[1].getName(),"BLondonportRoastBeef.jpg");
		assertEquals(contents[2].getName(),"BOvenRoastedTopRoundBeefLowSodium.jpg");
		assertEquals(contents[3].getName(),"BOvenRoastedTopRoundBeefNoSalt.jpg");
		assertEquals(contents[4].getName(),"BTopRoundCornedBeef.jpg");
		assertEquals(contents[5].getName(),"BTopRoundPastrami.jpg");
		assertEquals(contents[6].getName(),"PBottomRoundRoastBeef.jpg");
		assertEquals(contents[7].getName(),"PTopRoundRoastBeef.jpg");		
	}
	
	
}
