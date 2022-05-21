package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.channels.WritableByteChannel;

public class ProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Plan')]")
    WebElement planTab;
    @FindBy(name = "inviteCode")
    WebElement inviteCodeTextBox;
    @FindBy(xpath = "//button[@class='ck-primary md-button md-ink-ripple']")
    WebElement submitCodeButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pastingCode(String code) throws InterruptedException {
        Thread.sleep(2000);
        planTab.click();
        Thread.sleep(2000);
        inviteCodeTextBox.sendKeys(code);
        Thread.sleep(2000);
        submitCodeButton.click();
        Thread.sleep(2000);
    }
}
