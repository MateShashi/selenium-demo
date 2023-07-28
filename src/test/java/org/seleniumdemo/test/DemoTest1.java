package org.seleniumdemo.test;
import org.junit.Assert;
import org.junit.Test;
import org.seleniumdemo.common.Base;
import org.seleniumdemo.pageobject.DemoPage;

public class DemoTest1 extends Base{
    @Test
    public void registerUser() throws InterruptedException{
        DemoPage demoPage = new DemoPage(driver);
        demoPage.loadHomePage();
        Thread.sleep(2000);
        demoPage.getStarted();
        Thread.sleep(3000);
        demoPage.verifyUserRegistration();
        Thread.sleep(1000);
    }

}
