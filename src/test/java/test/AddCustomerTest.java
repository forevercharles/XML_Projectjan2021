package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	WebDriver driver;
//	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_login TestData data.xlsx");

//	String userName = null;
//	String password = null;
//	String fullName = null;
//	String companyname = null;
//	String email = null;
//	String phone = null;
//	String address = null;
//	String city = null;
//	String country = null;
//	String state = null;
//	String zip = null;

	//@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToCreateCustomer(String userName, String password, String fullName, String companyname, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterusername(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();

		dashboardPage.clickCustomersButton();

		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyname);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.entercity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.ClickSaveButtonOnAddContact();
		
		
//  this is supposed to have come from summary page so we should have created an object with the help of pageFactory.		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
//		BrowserFactory.teardown();
	}
	
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToUseAddCustomerOnListCustomerPage(String userName, String password, String fullName, String companyname, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterusername(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();

		dashboardPage.clickCustomersButton();

//		dashboardPage.clickAddCustomerButton();
		
		dashboardPage.clickListCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomerPage();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyname);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.entercity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.ClickSaveButtonOnAddContact();
		
		
//  this is supposed to have come from summary page so we should have created an object with the help of pageFactory.		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		addCustomerPage.insertNameOnSearchBarOnListCustomer();
		addCustomerPage.verifySearchBarAndSummaryButtonOnListCustomer();
		addCustomerPage.verifySummaryPage();
//		addCustomerPage.verifyEnteredNameAndDelete();

        BrowserFactory.teardown();
	}	
}
