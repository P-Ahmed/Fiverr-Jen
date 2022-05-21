package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Manage Users')]")
    WebElement manageUsersLink;
    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement profileLink;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    WebElement signOutLink;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void manageUser(){
        manageUsersLink.click();
    }
    public void profile(){
        profileLink.click();
    }
    public void signOut(){
        signOutLink.click();
    }
}

