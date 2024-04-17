package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageFactory1 {

	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	Robot robot;
	WebDriverWait wait;

	public PageFactory1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//======================================XPATH===========================================================================

	@FindBy(xpath = "//a[@data-target=\"#HOMEDECOR\"]/span[1]")
	WebElement homeDecor;

	@FindBy(xpath = "//a[@href=\"https://www.asianpaints.com/home-decor/furniture.html\"]")
	WebElement furniture;

	@FindBy(id = "prod-catagory")
	WebElement prod_dropdown;

	@FindBy(id = "citylist")
	WebElement city_dropdown;

	@FindBy(xpath = "//ul[@class=\"form-dropdown__list\"]/child::li[2]/child::a[1]")
	WebElement sofa;

	@FindBy(xpath = "//a[text()=\"Jaipur\"]")
	WebElement jaipur;

	@FindBy(xpath = "//a[@data-href=\"navigateTo_Citylist\"]")
	WebElement find_store;

	@FindBy(xpath = "//div[@class=\"cityStore-title padding45\"]//child::h2")
	WebElement title;
	
	
	
	@FindBy(xpath = "//ul[@id=\"DECOR\"]/li[1]/a[1]")
	WebElement wallpapers;

	@FindBy(id = "enquire-name")
	WebElement name;

	@FindBy(id = "enquire-email")
	WebElement email;

	@FindBy(id = "enquire-mobile")
	WebElement mobile;

	@FindBy(id = "enquire-pincode")
	WebElement pincode;

	@FindBy(xpath="//form[@id=\"pdp-request-call-back-form\"]/div[2]/div[2]/button")
	WebElement button;

	@FindBy(xpath = "//h2[@class=\"thankYouTitle\"]")
	WebElement msg;
	
	
	
	@FindBy(xpath = "//ul[@id=\"DECOR\"]/li[1]/a[1]")
	WebElement wallpaper;

	@FindBy(xpath = "//div[@id=\"slick-slide40\"]/div[1]/div[3]/div[1]/a[1]")
	WebElement know_more;

	@FindBy(xpath = "//span[text()=\"Red\"]")
	WebElement red;

	@FindBy(xpath = "//img[@src=\"/content/dam/asian_paints/wall-coverings/indie-boho/roomshots/W173XU17N75_02.jpg.transform/cc-width-302-height-302/image.jpg\"]")
	WebElement product;

	@FindBy(id = "checkPincode")
	WebElement pincode1;

	@FindBy(xpath = "//button[text()=\"CHECK\"]")
//	@FindBy(xpath="//button[@class=\"ctaText js-checkBtn check-pin-code-click\"]")
	WebElement check;

	@FindBy(id = "pinCodeServiceMsg")
	WebElement pinmsg;

	@FindBy(xpath = "//span[@id=\"pinCodeServiceMsg\"]/child::span[1]")
	WebElement pinmsg1;

	@FindBy(xpath = "//button[@id=\"add-to-cart-click\"]/parent::div")
	WebElement cart;

	@FindBy(xpath = "//div[@class=\"addToCartMessageFail\"]/descendant::span")
	WebElement cartMsg;

//=======================================================================================================

	public void homepage() {
		action = new Actions(driver);
		action.moveToElement(homeDecor).build().perform();
	}

	public void furniture() {
		furniture.click();
	}

	public void scrolldown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,300)");
	}

	public void select_dropdown() {
		prod_dropdown.click();
		sofa.click();
//	    js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", city_dropdown);
		js.executeScript("arguments[0].click();", jaipur);
	}

	public void find_store() {
		find_store.click();
	}

	public String title() {
		return title.getText();
	}

// ================================================================================================================

	

	public void wallpapers() {
		wallpapers.click();

	}

	public void scrolldown2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,400)");
	}

	public void fill_details(String name1, String email1, String mobile1, String pincode1) {
		name.sendKeys(name1);
		email.sendKeys(email1);
		mobile.sendKeys(mobile1);
		pincode.sendKeys(pincode1);

	}

	public void enquiry_btn() {
		button.click();

	}

	public String getmsg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(msg));
		String mesg = msg.getText();
		System.out.println(mesg);
		return mesg;
	}
	
// =====================================================================================================================

	
	public void wallpaper() {
		wallpaper.click();
	}

	public void Know() {
		know_more.click();
	}

	public void Red() {
		red.click();
	}

	public void product() {
		product.click();
	}

	public void window_handle() {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public void enter_valid_pincode(String pincode){
		pincode1.sendKeys(pincode);
		
	}

	public void check() throws AWTException {
//		check.click();
		robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public String service_msg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pinmsg));
		String msg = pinmsg.getText();
//		System.out.println(msg);
		return msg;
	}

	public void enter_invalid_pincode() throws IOException {
		File file = new File("C:\\Users\\IBHAWSAR\\Desktop\\pincode_excel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		double pincodeValue = s.getRow(0).getCell(0).getNumericCellValue();
		String pincodeString = String.valueOf((int) pincodeValue);
		pincode1.sendKeys(pincodeString);
	}

	public String not_service_msg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pinmsg1));
		String msg = pinmsg1.getText();
//		System.out.println(msg);
		return msg;
	}

	public void enter_pincode() throws IOException {
		File file = new File("C:\\Users\\IBHAWSAR\\Desktop\\pincode_excel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		double pincodeValue = s.getRow(1).getCell(0).getNumericCellValue();
		String pincodeString = String.valueOf((int) pincodeValue);
		pincode1.sendKeys(pincodeString);
	}

	public void cart() throws InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scroll(0,300)");

//		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
		
	}

	public String msgCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cartMsg));
		String msg = cartMsg.getText();
//		System.out.println(msg);
		return msg;
	}
	
	
}
