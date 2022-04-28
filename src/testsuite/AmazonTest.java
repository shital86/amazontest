package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {
    String baseUrl = " https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void searchBox() {
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//span[@class='a-list-item']//a[@class='a-link-normal s-navigation-item']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//label//i[@class='a-icon a-icon-checkbox']"));
        // List<WebElement> number= driver.findElements(By.className("sg-col-inner"));
        List<WebElement> number = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualnumber = number.size();
        System.out.println("===========================");
        System.out.println("Number of Items on the Page:"+actualnumber);
        int expected = 30;
        Assert.assertEquals(30, actualnumber);
        getTextFromElement(By.xpath("//div[@data-component-type='s-search-result']"));

        {
            for (WebElement tabledata : driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"))) {
                System.out.println("============================");
                System.out.println("List of the Product Name:" +tabledata.getText());
                System.out.println("============================");


            }
        }
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}


