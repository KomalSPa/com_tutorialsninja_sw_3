package myaccounts;

import base.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }


    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equals("Register")) {
                names.click();
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        //selectMyAccountOptions("Register");
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Register']"));

        //1.3 Verify the text “Register Account”.
        verifyText("Register Account", By.xpath("//h1[normalize-space()='Register Account']"));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        // 2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        //selectMyAccountOptions("Login");
        mouseHoverAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        //2.3 Verify the text “Returning Customer”.
        verifyText("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        //selectMyAccountOptions("Register");
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Register']"));

        // 3.3 Enter First Name
        //3.4 Enter Last Name
        //3.5 Enter Email
        //3.6 Enter Telephone
        //3.7 Enter Password
        //3.8 Enter Password Confirm
        //3.9 Select Subscribe Yes radio button
        //3.10 Click on Privacy Policy check box
        //3.11 Click on Continue button

        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Patel");
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Prime1222@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "12345678");
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Prime1234");
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Prime1234");
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!
        verifyText("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[@class='caret']"));

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //selectMyAccountOptions("Logout");
        mouseHoverAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        //3.16 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[text()='Account Logout']"));

        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        // 4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        //selectMyAccountOptions("Login");
        mouseHoverAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        // 4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"Prime102@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Prime1234");

        // 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        // 4.7 Verify text “My Account”
        verifyText("My Account",By.xpath("//h2[normalize-space()='My Account']"));

        //4.8  Click on My Account Link.
        clickOnElement(By.xpath("//span[@class='caret']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //selectMyAccountOptions("Logout");
        mouseHoverAndClick(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        //4.10 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[text()='Account Logout']"));

        // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }

}