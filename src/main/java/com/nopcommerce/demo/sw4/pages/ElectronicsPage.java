package com.nopcommerce.demo.sw4.pages;

import com.nopcommerce.demo.sw4.utilites.Utility;
import org.openqa.selenium.By;

public class ElectronicsPage extends Utility {


    By electronicsCategory = By.xpath("//a[text()='Electronics ']");
    By cellPhone = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");

    public void hoverOnElectronics() {
        mouseHoverToElement(electronicsCategory);
    }

    public void hoverOnCellPhoneAndClick() {
        mouseHoverToElementAndClick(cellPhone);
    }

}
