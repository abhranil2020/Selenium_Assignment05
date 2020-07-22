package com.testcase;
import org.testng.annotations.Test;
import com.testingbase.Testbase;


public class Hyperlinkverify extends Testbase {
	
	
	@Test
	public void verifylinks() throws Exception  {		
	
		objpages.verifyhyperLinks();

}
}