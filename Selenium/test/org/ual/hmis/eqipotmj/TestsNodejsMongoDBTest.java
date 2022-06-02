package org.ual.hmis.eqipotmj;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
// Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestsNodejsMongoDBTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	  public void setUp() {
	    // Browser selector
	    int browser= 1; // 0: firefox, 1: chrome,...
	    Boolean headless = false;

	    switch (browser) {
	    case 0:  // firefox
	    	// Firefox
	    	// Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
	    	// Descomprimir el archivo geckodriver.exe en la carpeta drivers

	    	System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
	    	FirefoxOptions firefoxOptions = new FirefoxOptions();
	    	if (headless) firefoxOptions.setHeadless(headless);
	    	driver = new FirefoxDriver(firefoxOptions);

	    	break;
	    case 1: // chrome
	    	// Chrome
	    	// Descargar Chromedriver de https://chromedriver.chromium.org/downloads
	    	// Descomprimir el archivo chromedriver.exe en la carpeta drivers

	    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    	ChromeOptions chromeOptions = new ChromeOptions();
	    	if (headless) chromeOptions.setHeadless(headless);
	    	chromeOptions.addArguments("window-size=1920,1080");
	    	driver = new ChromeDriver(chromeOptions);

	    	break;

	    default:
	    	fail("Please select a browser");
	    	break;
	    }
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testAddTask() {
		// Test name: TestAddTask
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://msdocs-node-mongo-2022-fml200.azurewebsites.net/");
		// 2 | setWindowSize | 1552x840 |
		driver.manage().window().setSize(new Dimension(1552, 840));
		// 3 | click | name=taskName |
		driver.findElement(By.name("taskName")).click();
		// 4 | executeScript | return "Tarea"+Math.floor(Math.random()*10) | TaskName
		vars.put("TaskName", js.executeScript("return \"Tarea\"+Math.floor(Math.random()*10)"));
		// 5 | type | name=taskName | ${TaskName}
		driver.findElement(By.name("taskName")).sendKeys(vars.get("TaskName").toString());
		// 6 | assertElementPresent | css=.btn-success |
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".btn-success"));
			assert (elements.size() > 0);
		}
		// 7 | click | css=.btn-success |
		driver.findElement(By.cssSelector(".btn-success")).click();
		// 8 | pause | 5000 |
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 9 | assertElementPresent | xpath=//div[contains(div,'${TaskName}')]/div |
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void testDeleteTask() {
		// Test name: TestDeleteTask
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://msdocs-node-mongo-2022-fml200.azurewebsites.net/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		// 3 | click | name=taskName |
		driver.findElement(By.name("taskName")).click();
		// 4 | executeScript | return "Tarea"+Math.floor(Math.random()*10) | TaskName
		vars.put("TaskName", js.executeScript("return \"Tarea\"+Math.floor(Math.random()*10)"));
		// 5 | type | name=taskName | ${TaskName}
		driver.findElement(By.name("taskName")).sendKeys(vars.get("TaskName").toString());
		// 6 | click | css=.btn-success |
		driver.findElement(By.cssSelector(".btn-success")).click();
		// 7 | pause | 5000 |
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 8 | assertElementPresent | xpath=//div[contains(div,'${TaskName}')]/div |
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div"));
			assert (elements.size() > 0);
		}
		// 9 | assertElementPresent |
		// xpath=//div[contains(div,'${TaskName}')]/div[3]/form/button |
		{
			List<WebElement> elements = driver.findElements(
					By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div[3]/form/button"));
			assert (elements.size() > 0);
		}
		// 10 | click | xpath=//div[contains(div,'${TaskName}')]/div[4]/form/button |
		driver.findElement(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div[4]/form/button"))
				.click();
		// 11 | verifyElementNotPresent | xpath=//div[contains(div,'${TaskName}')] |
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]"));
			assert (elements.size() == 0);
		}
	}

	@Test
	public void testTaskCompleted() {
		// Test name: TestTaskCompleted
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://msdocs-node-mongo-2022-fml200.azurewebsites.net/");
		// 2 | setWindowSize | 1552x840 |
		driver.manage().window().setSize(new Dimension(1552, 840));
		// 3 | click | name=taskName |
		driver.findElement(By.name("taskName")).click();
		// 4 | executeScript | return "Tarea"+Math.floor(Math.random()*10) | TaskName
		vars.put("TaskName", js.executeScript("return \"Tarea\"+Math.floor(Math.random()*10)"));
		// 5 | type | name=taskName | ${TaskName}
		driver.findElement(By.name("taskName")).sendKeys(vars.get("TaskName").toString());
		// 6 | assertElementPresent | css=.btn-success |
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".btn-success"));
			assert (elements.size() > 0);
		}
		// 7 | click | css=.btn-success |
		driver.findElement(By.cssSelector(".btn-success")).click();
		// 8 | pause | 5000 |
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 9 | assertElementPresent | xpath=//div[contains(div,'${TaskName}')]/div |
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div"));
			assert (elements.size() > 0);
		}
		// 10 | assertElementPresent |
		// xpath=//div[contains(div,'${TaskName}')]/div[3]/form/button |
		{
			List<WebElement> elements = driver.findElements(
					By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div[3]/form/button"));
			assert (elements.size() > 0);
		}
		// 11 | click | xpath=//div[contains(div,'${TaskName}')]/div[3]/form/button |
		driver.findElement(By.xpath("//div[contains(div,\'vars.get(TaskName).toString()\')]/div[3]/form/button"))
				.click();
		// 12 | assertElementPresent | xpath=//div[5]/div/div[contains(.,'${TaskName}')]
		// |
		{
			List<WebElement> elements = driver
					.findElements(By.xpath("//div[5]/div/div[contains(.,\'vars.get(TaskName).toString()\')]"));
			assert (elements.size() > 0);
		}
	}
}
