package desktops;

import base.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DesktopsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeBrowser() {
        //closeBrowser();
    }

    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().perform();
    }

    @Test
    public void verifyProductArrangeInAlphabaticalOrder() {

        //1.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 Click on “Show All Desktops
        selectMenu("Show AllDesktops");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1.3 Select Sort By position "Name: Z to A"
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (Z - A)");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2.3 Select Sort By position "Name: A to Z"
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        mouseHoverAndClick(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals("Matched", "HP LP3065", getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));

        //2.6 Select Delivery Date "2022-11-30"
        WebElement dateTextField = findElementFromWebPage(By.cssSelector("#input-option225"));
        dateTextField.click();
        dateTextField.sendKeys(Keys.CONTROL, "a");
        dateTextField.sendKeys(Keys.DELETE);
        dateTextField.sendKeys("2022-11-30");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 2.10 Click on link “shopping cart” display into success message
        //mouseHoverAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // 2.11 Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart  (1.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));

        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.linkText("HP LP3065")));

        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals("Delivery Date:2022-11-30", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']")));

        //2.14 Verify the Model "Product21"
        Assert.assertEquals("Product 21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));

        //2.15 Verify the Total "$122.00"
        Assert.assertEquals("$122.00", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));
    }

}