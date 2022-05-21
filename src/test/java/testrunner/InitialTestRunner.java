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
    public void testingTheIssue() throws InterruptedException {
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
}
