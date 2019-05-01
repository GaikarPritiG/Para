import org.testng.annotations.Test;

import com.eppm.qa.common.MainDriver;
import com.prit.pageobject.LoginPage;

public class LoginPageTest {
	
	LoginPage L = new LoginPage();
	MainDriver m = new MainDriver();
	@Test(priority=1)
	public void driver() throws Exception {
		
		m.initialioseBrowser();
	}
	
	@Test(priority=2)
	public void USer1(){
		
		L.Loginop();
	}
}
