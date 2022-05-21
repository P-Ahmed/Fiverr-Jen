package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@class='login-button ck-secondary md-button md-ink-ripple']")
    WebElement loginLink;
    @FindBy(name = "emailOrUsername")
    WebElement emailTextBox;
    @FindBy(name = "password")
    WebElement passwordTextBox;
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password){
//        loginLink.click();
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }
}

