package com.nopcommerce.demo.sw4.basetest;

import com.nopcommerce.demo.sw4.propertyreader.PropertyReader;
import com.nopcommerce.demo.sw4.utilites.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {


    String browser = PropertyReader.getInstance().getProperty("browser");;

    @BeforeMethod
    public void setup() {

        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown() {

        closeBrowser();
    }
}
