package com.htc.testCases;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.htc.base.TestBase;
import com.htc.utilities.MadsionDataProvider;
import com.htc.utilities.Screenshot;

public class RegistrationTest extends TestBase{
	Screenshot screenshot = new Screenshot();

	@Test(dataProviderClass = MadsionDataProvider.class, dataProvider = "MadisonRegisterAndLogin")
	public void testRegistrationPage_shouldShowDashboardAndErrorMessage_enterValidDetails(Map<String, String> mapData)
	{
        register.performRegistration(mapData.get("firstName"), mapData.get("middleName"), mapData.get("lastName"),
				mapData.get("emailid"), mapData.get("password"), mapData.get("confirmpassword"));
        register.assertSuccessMessage();
		Assert.assertEquals(register.assertSuccessMessage(), "Thank you for registering with Madison Island.");
    }
}
