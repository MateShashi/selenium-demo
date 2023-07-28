package org.seleniumdemo.pageobject;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class DemoPage {
    String emailId = "abc@mail.com";
    String passwd = "abc@123";
    String confirmPwd = "abc@123";
    @FindBy(name = "user-email")
    private WebElement emailField;

    @FindBy(name = "user-password")
    private WebElement passwdField;

    @FindBy(name = "confirm-password")
    private WebElement confirmPasswdField;

    @FindBy(name = "button")
    private WebElement getStartedBtn;

    @FindBy(xpath = "//*[@class='menu uppercase']/li[1]/a")
    private WebElement homeMenu;

    @FindBy(xpath = "//*[@class='menu uppercase']/li[2]/a")
    private WebElement contactMenu;

    @FindBy(xpath = "//*[@class='menu uppercase']/li[3]/a")
    private WebElement aboutUsMenu;

    @FindBy(xpath = "//*[@class='menu uppercase']/li[4]/a")
    private WebElement signUpMenu;

    private final WebDriver driver;

    public DemoPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterEmailId() {
        emailField.sendKeys(emailId);
    }
    public void enterPassword() {
        passwdField.sendKeys(passwd);
    }
    public void enterConfirmPassword() {
        confirmPasswdField.sendKeys(confirmPwd);
    }

    public void loadHomePage() {
        driver.get("http://18.212.63.55/");
    }

    public void getStarted() {
        enterEmailId();
        enterPassword();
        enterConfirmPassword();
        getStartedBtn.click();
    }

    public void verifyUserRegistration(){
        String actEmail = emailField.getAttribute("placeholder");
        String actPasswd = passwdField.getAttribute("placeholder");

        Assert.assertTrue(actEmail.equalsIgnoreCase("Email"));
        Assert.assertTrue(actPasswd.equalsIgnoreCase("Password"));
        System.out.println("User Details entered successfully");
    }

    public String getMenuName(String menu){
        String name = "";
        switch (menu){
            case "home":
                name = homeMenu.getText();
                break;
            case "contact":
                name = contactMenu.getText();
                break;
            case "aboutus":
                name = aboutUsMenu.getText();
                break;
            case "signup":
                name = signUpMenu.getText();
        }
        return name;
    }
}
