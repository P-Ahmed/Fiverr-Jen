package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageUsersPage{
    WebDriver driver;
    String copiedCode = "";

    @FindBy(xpath = "//button[@class='md-fab md-button md-ink-ripple']")
    WebElement addUserIcon;
    @FindBy(xpath = "//button[contains(text(),'New Teachers')]")
    WebElement addNewTeachers;
    @FindBy(xpath = "//button[contains(text(),'New Students')]")
    WebElement addNewStudents;
    @FindBy(xpath = "//div[contains(text(),'Add Manually')]")
    WebElement addManually;
    @FindBy(name = "emailOrUsernameInput")
    WebElement studentUserName;
    @FindBy(name = "firstNameInput")
    WebElement studentFirstName;
    @FindBy(name = "lastNameInput")
    WebElement studentLastName;
    @FindBy(xpath = "//div[contains(text(),'add student')]")
    WebElement addStudentButton;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement closeButton;
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

    public void addNewStudent(String randomUserName) throws InterruptedException {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        addUserIcon.click();
        Thread.sleep(2000);
        addNewStudents.click();
        addManually.click();
        studentUserName.sendKeys(randomUserName);
        studentFirstName.sendKeys(firstName);
        studentLastName.sendKeys(lastName);
        addStudentButton.click();
        continueButton.click();
        closeButton.click();
        Thread.sleep(2000);
    }

    public void newlyAddedStudentVerification(String randomUserName){
        String newlyAddedStudent = driver.findElement(By.xpath("//div[contains(text(),'"+randomUserName+"')]")).getText();
        Assert.assertEquals(newlyAddedStudent,randomUserName);
    }
}
