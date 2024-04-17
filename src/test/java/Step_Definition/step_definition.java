package Step_Definition;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverSetUp.SetUpDriver;
import Pages.PageFactory1;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class step_definition {

	WebDriver driver;
	PageFactory1 p1;


	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: It is a mandatory step to navigate to the homepage page for all scenarios
	 */

	@Given("user is on homepage and User hover on HomeDecor")
	public void user_is_on_homepage_and_user_hover_on_home_decor() {
		driver = SetUpDriver.chromedriver();
		p1 = new PageFactory1(driver);
		p1.homepage();
	}

//==================================================FOR VIEW STORES===============================================================
	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: It will display stores according to selected furniture type and city.
	 */

	@When("Click on furniture option")
	public void click_on_furniture_option() {
		p1.furniture();
	}

	@And("Scroll downward")
	public void scroll_downward() {
		p1.scrolldown();
	}

	@And("Select furniture type as Sofa and city as Jaipur from given dropdown list")
	public void select_furniture_type_as_sofa_and_city_as_jaipur_from_given_dropdown_list() {
		p1.select_dropdown();
	}

	@And("Click on find store")
	public void click_on_find_store() {
		p1.find_store();

	}

	@Then("It should  display stores")
	public void it_should_display_stores() {
		String verifyTitle = "Locate your nearest Beautiful Home Stores";
		String title = p1.title();
		Assert.assertEquals(verifyTitle, title);
	}
//==============================================FOR ENQUIRE NOW=========================================================================
	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: It will display Thank you message after clicking on enquire now
	 */

	@When("Click on Wallpapers")
	public void click_on_wallpapers() {
		p1.wallpapers();
	}

	@When("Scroll downwards")
	public void scroll_downwards() {
		p1.scrolldown();
	}

	@And("^Enter (.*) , (.*) , (.*) , (.*)$")
	public void enter(String Name, String Email, String Mobile, String Pincode) throws InterruptedException {
		p1.fill_details(Name, Email, Mobile, Pincode);

	}

	@And("Click Enquiry Now")
	public void click_enquiry_now() throws InterruptedException {

		p1.enquiry_btn();
//	    wait.until(ExpectedConditions.elementToBeClickable(p1.getMsg1()));

	}

	@Then("User is able to Enquire successfully")
	public void user_is_able_to_enquire_successfully() throws InterruptedException {

		String Title = "Thank you!";
		//Thread.sleep(2000);
		String verifyTitle = p1.getmsg();
		Assert.assertEquals(verifyTitle, Title);
	}

//===============================================FOR SERVICEABLE PINCODE====================================================================================
	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: It is display "This pin Code is Serviceable" after entering serviceable pincode.
	 */

	@When("Click on Wallpaper")
	public void click_on_wallpaper() {
		p1.wallpaper();
	}

	@And("Click on Know more")
	public void click_on_know_more() {
		p1.Know();
	}

	@And("Choose Red as filter")
	public void choose_blue_as_filter() {
		p1.Red();
	}

	@And("Click on product")
	public void click_on_product() {
		p1.product();
	}

	@When("scroll down")
	public void scroll_down() {
		p1.window_handle();
		p1.scrolldown2();
	}

	@And("Enter serviceable {string}")
	public void enter(String string, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> cells = dataTable.cells();
		p1.enter_valid_pincode(cells.get(0).get(0));
	}

	@And("Click on check")
	public void click_on_check() throws AWTException {
		p1.check();
	}

	@Then("It will display THIS PIN CODE IS SERVICEABLE")
	public void it_will_display_this_pin_code_is_serviceable() throws InterruptedException {
//		Thread.sleep(3000);
		String msg = p1.service_msg();
		String verifyMsg = "This pin Code is Serviceable";
		Assert.assertEquals(verifyMsg, msg);
	}

//=================================================FOR NOT SERVICEABLE PINCODE=========================================================================

	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: It is display "This pin Code is not Serviceable" after entering non serviceable pincode.
	 */

	@When("Enter non serviceable pincode")
	public void enter_non_serviceable_pincode() throws IOException, InterruptedException {
		p1.enter_invalid_pincode();
//	    Thread.sleep(2000);
	}

	@Then("It will display THIS PIN CODE IS NOT SERVICEABLE")
	public void it_will_display_this_pin_code_is_not_serviceable() throws InterruptedException {
//		Thread.sleep(3000);
		String msg = p1.not_service_msg();
		String verifyMsg = "This Pin Code is not Serviceable.";
		Assert.assertEquals(verifyMsg, msg);
	}

//============================================FOR ADD TO CART============================================================
	/*
	 * Created By: Ishika Bhawsar 
	 * Reviewed By: 
	 * Motive: This scenerio will add products to Cart
	 */

	@When("Enter serviceable pincode")
	public void enter_serviceable_pincode() throws IOException {
		p1.enter_pincode();
	}

	@When("Click on ADD TO CART")
	public void click_on_add_to_cart() throws InterruptedException {

		p1.cart();
	}

	@Then("It will navigate to the Cart")
	public void it_will_navigate_to_the_cart() throws InterruptedException {
//		Thread.sleep(3000);
		String title = p1.msgCart();
		String VerifyTitle = "Product successfully added to cart.";
		Assert.assertEquals(title, VerifyTitle);

	}

//==========================================SCREENSHOT===================================================================

	@AfterStep
	public void takeScreendown(Scenario scenerio) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());
	}

}
