package com.htc.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.htc.constants.GlobalVariables;

public class MadsionDataProvider {
	@DataProvider(name = "MadisonRegisterAndLogin")
	public Object[][] madisonValidAndInvalidRegisterAndLoginData(Method m) {
		Object[][] loginDataSet = null;
		ExcelReader ref = new ExcelReader(GlobalVariables.EXCEL_DATA_PATH);
		if (m.getName().equals("testRegistrationPage_successMessage_enterValidDetails")) {
			loginDataSet = ref.getDataUsingMap(GlobalVariables.REGISTRATION_SHEET);
		} 
		else if (m.getName().equals("testLoginAndCheckOutPage_shouldDisplayValidInvalidMessage_enterValidAndInvalidDetails")) {
			loginDataSet = ref.getDataUsingMap(GlobalVariables.LOGIN_PURCHASE_SHEET);
		}

		return loginDataSet;

	}
}
