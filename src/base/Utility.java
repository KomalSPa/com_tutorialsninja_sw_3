package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    //********************************* Alert Methods *********************************************//

    public void switchToAlert() {
        driver.switchTo().alert();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
    public void sendKeysToAlert(String keys) {
        driver.switchTo().alert().sendKeys(keys);
    }

    //********************************* Select Class Methods **************************************//


    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public void selectByIndexFromDropDown(By by, String index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(index);
    }

    /**
     * This method for verify text
     */
    public void verifyText(String text,By by){
        String expectedText = text;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText,actualText);
    }

    /**
     * This Method will mouse hover
     */

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement desktopsTab = driver.findElement(by);
        actions.moveToElement(desktopsTab).click().perform();
    }
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This Method will find element from webpage
     */

    public WebElement findElementFromWebPage(By by) {
        return driver.findElement(by);
    }
    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().build().perform();
    }
}