package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.loginPage;
import resource.base;

public class stepDefination extends base

{

@Given("Initialize the browser with chrome")
public void initialize_the_browser_with_chrome() throws IOException 
{
    // Write code here that turns the phrase above into concrete actions
	
      driver = initializeDriver();   
    
}
@Given("Navigate to {string} site")
public void navigate_to_site(String string) {
    // Write code here that turns the phrase above into concrete actions
	
	driver.get(string);  

    
}
@Given("Click on Login link in home page to loand on secure sign in page")
public void click_on_login_link_in_home_page_to_loand_on_secure_sign_in_page() {
    // Write code here that turns the phrase above into concrete actions
	
	LandingPage lp = new LandingPage(driver);
	 
	if(lp.getpopupsize().size()>0)
	{
		lp.popup().click();
	}
	
	loginPage lop = lp.getlogin();  
	
    
}


@When("^user enter (.+) and (.+) and logs in$")
public void user_enter_and_and_logs_in(String username, String password) throws Throwable {
loginPage lop = new loginPage(driver);

	
    lop.getemail().sendKeys(username);
	
	lop.getpassword().sendKeys(password);
	
	lop.getlogin().click();
}
@Then("verify that user is successfully logged in")
public void verify_that_user_is_successfully_logged_in() 
{
    // Write code here that turns the phrase above into concrete actions
	
	System.out.println("unable to login");
    
}

@And("^close browsers$")
public void close_browsers() throws Throwable {
	driver.quit();
}

}