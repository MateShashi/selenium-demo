package org.seleniumdemo.test;
import org.junit.Assert;
import org.junit.Test;
import org.seleniumdemo.common.Base;
import org.seleniumdemo.pageobject.DemoPage;

public class DemoTest2 extends Base{
    @Test
    public void verifyApplicationMenus() throws InterruptedException {
        DemoPage demoPage = new DemoPage(driver);
        demoPage.loadHomePage();
        Thread.sleep(3000);

        String menuName1 = demoPage.getMenuName("home");
        System.out.println("menuName1-"+menuName1);
        Assert.assertTrue(menuName1.contains("HOME"));

        String menuName2 = demoPage.getMenuName("contact");
        System.out.println("menuName2-"+menuName2);
        Assert.assertTrue(menuName2.contains("CONTACT US"));

        String menuName3 = demoPage.getMenuName("aboutus");
        System.out.println("menuName3-"+menuName3);
        Assert.assertTrue(menuName3.contains("ABOUT US"));

        String menuName4 = demoPage.getMenuName("signup");
        System.out.println("menuName4-"+menuName4);
        Assert.assertTrue(menuName4.contains("SIGNUP"));

        System.out.println("Following Menus are displayed on the application: "+menuName1+", "+menuName2+", "+menuName3+", "+menuName4);
    }

}
