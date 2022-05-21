package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class ManageUsersPage{
    WebDriver driver;
    String copiedCode = "";

    @FindBy(xpath = "//button[@class='md-fab md-button md-ink-ripple']")
    WebElement addUserIcon;
    @FindBy(xpath = "//button[contains(text(),'New Teachers')]")
    WebElement addNewTeachers;
    @FindBy(xpath = "//span[@class='ng-binding']")
    WebElement copyingCode;
    @FindBy(xpath = "//i[@class='fa ck ck-close']")
    WebElement closingProInvitationCode;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchBar;
    @FindBy(xpath = "//md-select[@aria-label='Filter by type: All']")
    WebElement clickingOnRole;
    @FindBy(xpath = "//div[@class='md-text ng-binding'][contains(text(),'Admin')]")
    WebElement selectingAdminFromRole;

    public ManageUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String gettingInvitationCode() throws InterruptedException {
        addUserIcon.click();
        addNewTeachers.click();
        Thread.sleep(2000);
        return copyingCode.getText();
    }

    public void adminRoleFilter(){
        clickingOnRole.click();
        selectingAdminFromRole.click();
    }
    public void searching(String searchItem){
        searchBar.sendKeys(searchItem);
    }

    public void closingInvitationCodeWindow(){
        closingProInvitationCode.click();
    }
}
