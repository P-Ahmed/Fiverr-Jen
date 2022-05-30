package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageUsersPage;
import pages.ProfilePage;
import setup.Setup;

public class InitialTestRunner extends Setup {
    DashboardPage dashboardPage;
    LoginPage loginPage;
    ManageUsersPage manageUsersPage;
    ProfilePage profilePage;

    @Test
    public void testingProInviteCode() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        loginPage = new LoginPage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        profilePage = new ProfilePage(driver);

        loginPage.doLogin("coffee@cktest.com", "test");

//        Thread.sleep(7000);
        dashboardPage = new DashboardPage(driver);
        dashboardPage.manageUser();


        String code = manageUsersPage.gettingInvitationCode();
        Thread.sleep(2000);
        manageUsersPage.closingInvitationCodeWindow();

        dashboardPage.signOut();
        loginPage.doLogin("jquery@cktest.com","test");

        dashboardPage.profile();
        profilePage.pastingCode(code);
        Thread.sleep(2000);
        dashboardPage.signOut();

        loginPage.doLogin("coffee@cktest.com", "test");
        dashboardPage.manageUser();
        manageUsersPage.adminRoleFilter();
        manageUsersPage.searching("jquery@cktest.com");

        String text = driver.findElement(By.xpath("//div[contains(text(),'coffee@cktest.com')]")).getText();
        Assert.assertEquals(text, "coffee@cktest.com");
    }

    @Test
    public void testingHandRaise() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("bbbb@cktest.com","t");

        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div/md-content/div[2]/div/div/md-list/md-list-item[1]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/div/assignment-toolbar/div[1]/div[3]/div[35]/assignment-toolbar-item/button/div[1]/clone/div/i")).click();
        boolean pleaseCheck = driver.findElements(By.xpath("//div[contains(text(),'please check')]")).size()>0;

        if(pleaseCheck == true){
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[contains(text(),'please check')]")).click();
            Thread.sleep(2000);
        }else {
            driver.findElement(By.name("chatMessageInput")).click();

            Thread.sleep(5000);
        }
    }

    @Test
    public void verifyingNewlyAddedStudentsExistence() throws InterruptedException {
        String randomNumber = String.valueOf((int)(Math.random() * (9999999 - 1000000 + 1) + 1000000));
        loginPage = new LoginPage(driver);
        loginPage.doLogin("coffee@cktest.com","test");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.manageUser();

        manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.addNewStudent(randomNumber);
        manageUsersPage.searching(randomNumber);
        manageUsersPage.newlyAddedStudentVerification(randomNumber);



    }
}
