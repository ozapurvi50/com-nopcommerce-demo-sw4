package com.nopcommerce.demo.sw4.testsuite;

import com.nopcommerce.demo.sw4.basetest.BaseTest;
import com.nopcommerce.demo.sw4.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    HomePage homepage=new HomePage();
    RegisterPage registerPage=new RegisterPage();
    ComputerPage computerPage=new ComputerPage();
    DesktopPage desktopPage=new DesktopPage();
    BuildYourOwnComputer buildYourOwnComputer=new BuildYourOwnComputer();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();
    CheckOutPage checkoutpage = new CheckOutPage();
    ElectronicsPage electronicsPage=new ElectronicsPage();
    CellPhonePage cellPhonesPage=new CellPhonePage();
    NokiaLumia1020Page nokiaLumia1020Page=new NokiaLumia1020Page();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        homepage.selectMenu("Computers");                                                                                //Click on Computer Menu.
        computerPage.clickOnDesktopCategory();                                                                           //Click on Desktop Category
        desktopPage.clickOnSortByNameZToA();                                                                            //Select Sort By position "Name: Z to A"
        desktopPage.verifyProductsArrangedInAlphabeticallyDescendingOrder();                                             //Verify the Product will arrange in Descending order.
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        homepage.selectMenu("Computers");                                                                               //Click on Computer Menu.
        computerPage.clickOnDesktopCategory();                                                                          //Click on Desktop
        desktopPage.clickOnSortByNameAToZ();                                                                            //Select Sort By position "Name: A to Z"
        Thread.sleep(3000);                                                                                       //Click on "Add To Cart"
        desktopPage.clickOnAddToCartButton();                                                                           
        String actualText=buildYourOwnComputer.getTextFromBuildYourComputer();                                          //Verify the Text "Build your own computer"
        Assert.assertEquals(actualText,"Build your own computer","Text not Displayed");
        buildYourOwnComputer.selectProcessor();                                                                         //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputer.selectRAM();                                                                               //Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputer.selectHDDRadio();                                                                          // Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputer.selectOSRadio();                                                                           //Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputer.selectTotalCommander();                                                                    // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(5000);                                                                                        //buildYourOwnComputer.selectSoftwareMS();
        String actualPriceText=buildYourOwnComputer.getTextFromPrice();                                                 //Verify the price "$1,475.00"
        Assert.assertEquals(actualPriceText,"$1,475.00","Text not Displayed");
        buildYourOwnComputer.clickOnAddToCartButton();                                                                   //Click on "ADD TO CARD" Button.
        buildYourOwnComputer.verifyTheProductHasBeenAddedToYourShoppingCart();                                           //Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        buildYourOwnComputer.closeTheBarByClickingOnTheCrossButton();
        buildYourOwnComputer.mouseHoverOnShoppingCartButton();                                                          //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputer.clickOnGoToCartButton();
        String actualShoppingCartMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage,"Shopping cart","error");                         //Verify the message "Shopping cart"
        Thread.sleep(2000);
        shoppingCartPage.changeQuantity();                                                                              //Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.clickOnUpdateCartButton();
        String actualTotalMessage = shoppingCartPage.getTotalText();
        Assert.assertEquals(actualTotalMessage,"$2,950.00","error");                                    //Verify the Total"$2,950.00
        shoppingCartPage.clickOnTermsOfServiceCheckBox();                                                               //click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckOutButton();                                                                       //Click on “CHECKOUT”
        String actualWelcomeSignInText = loginPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeSignInText,"Welcome, Please Sign In!","error");                //Verify the Text “Welcome, Please Sign In!”
        loginPage.clickOnCheckoutAsGuestButton();                                                                       //Click on “CHECKOUT AS GUEST” Tab
        checkoutpage.inputFirstname("Pinks");                                                                           //Fill the all mandatoryfield
        checkoutpage.inputLastname("Shah");                                                                             //Fill the all mandatoryfield
        checkoutpage.inputEmail("Pinkshah123@gmail.com");                                                               //Fill the all mandatoryfield
        checkoutpage.selectCountry("United Kingdom");                                                        //Fill the all mandatoryfield
        checkoutpage.inputCity("London");                                                                       //Fill the all mandatoryfield
        checkoutpage.inputAddress1("14A High Street");
        checkoutpage.inputPostalCode("EC1Y 7ED");
        checkoutpage.inputPhoneNumber("12345678");
        checkoutpage.clickOnContinueButton();                                                                           //Click on “CONTINUE”
        checkoutpage.clickOnNextDayAirRadioButton();                                                                    //Click on Radio Button “Next Day Air($0.00)”
        checkoutpage.clickOnContinueButton1();                                                                          // Click on “CONTINUE”
        checkoutpage.clickOnCreditCard();                                                                                //Select Radio Button “Credit Card”
        checkoutpage.clickOnPaymentContinueButton();
        checkoutpage.selectCreditCard("Master card");                                                                   //Select “Master card” From Select credit card dropdown
        checkoutpage.inputCardHolderName("Mrs Pinks Shah");                                                             //Fill all the details
        checkoutpage.inputCardNumber("5459 0008 0408 5000");
        checkoutpage.selectExpireMonth("04");
        checkoutpage.selectExpireYear("2027");
        checkoutpage.inputCardCode("606");
        checkoutpage.clickOnContinueButton2();                                                                          //Click on “CONTINUE”
        String actualCardMessage = checkoutpage.getCreditCardText();                                                    //Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(actualCardMessage,"Credit Card","error");
        String actualShippingMessage = checkoutpage.getNextDayAirText();                                                //Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(actualShippingMessage,"Next Day Air","error");
        String actualTotalAmountMessage = checkoutpage.getTotalAmountText();                                            //Verify Total is “$2,950.00”
        Assert.assertEquals(actualTotalAmountMessage,"$2,950.00","error");
        checkoutpage.clickOnConfirmButton();                                                                            //Click on “CONFIRM”
        String actualThankYouText = checkoutpage.getThankYouText();                                                     //Verify the Text “Thank You”
        Assert.assertEquals(actualThankYouText,"Thank you","error");
        String actualOrderSuccessText = checkoutpage.getOrderSuccessProcessText();                                      //Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(actualOrderSuccessText,"Your order has been successfully processed!","error");
        checkoutpage.clickOnContinueButton3();                                                                          //Click on “CONTINUE”
        String actualWelcomeStoreText = homepage.getWelcomeOurStoreText();                                              //Verify the text “Welcome to our store”
        Assert.assertEquals(actualWelcomeStoreText,"Welcome to our store","error");
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        electronicsPage.hoverOnElectronics();                                                                           //Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnCellPhoneAndClick();                                                                     // Mouse Hover on “Cell phones” and click
        String actualText= cellPhonesPage.getCellPhoneText();                                                           //Verify the text “Cell phones”
        Assert.assertEquals(actualText,"Cell phones","Text not Displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        electronicsPage.hoverOnElectronics();                                                                           //Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnCellPhoneAndClick();                                                                     //Mouse Hover on “Cell phones” and click
        String actualText= cellPhonesPage.getCellPhoneText();                                                           //Verify the text “Cell phones”
        Assert.assertEquals(actualText,"Cell phones","Text not Displayed");
        cellPhonesPage.clickOnListViewTab();                                                                            //Click on List View Tab
        Thread.sleep(1000);
        cellPhonesPage.clickOnNokiaLumia1020();                                                                         //Click on product name “Nokia Lumia 1020” link
        String actualNokiaLumiaText=nokiaLumia1020Page.getNokiaLumiaText();                                             //Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(actualNokiaLumiaText,"Nokia Lumia 1020","Text not Displayed");
        String actualNokiaPriceText=nokiaLumia1020Page.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText,"$349.00","Text not Displayed");                       //Verify the price “$349.00”
        nokiaLumia1020Page.changeQuantity();                                                                            //Change quantity to 2
        nokiaLumia1020Page.clickOnAddToCartButton();                                                                    // Click on “ADD TO CART” tab
        String actualTextShoppingCart=nokiaLumia1020Page.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart,"The product has been added to your shopping cart","Text not Displayed");        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar  After that close the bar clicking on the cross button.
        nokiaLumia1020Page.closeTheBarByClickingOnTheCrossButton();
        nokiaLumia1020Page.mouseHoverOnShoppingCart();                                                                  //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia1020Page.clickOnShoppingCart();
        String actualShoppingCartMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage,"Shopping cart","error");                          //Verify the message "Shopping cart"
        Thread.sleep(2000);
        String actualQuantity=shoppingCartPage.getVerifyQuantity();
        Assert.assertEquals(actualQuantity,"(2)","Error");                                               //Verify the quantity is 2
        String actualTotal=shoppingCartPage.getVerifyTotal();
        Assert.assertEquals(actualTotal,"$698.00","Error");                                              //Verify the Total $698.00
        shoppingCartPage.clickOnTermsOfServiceCheckBox();                                                                //click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnCheckOutButton();                                                                        //Click on “CHECKOUT”
        String actualWelcomeText=loginPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText,"Welcome, Please Sign In!","Error");                       // Verify the Text “Welcome, Please Sign In!”
        loginPage.clickOnRegisterButton();                                                                               //Click on “REGISTER” tab
        String actualRegisterText=registerPage.getRegisterText();
        Assert.assertEquals(actualRegisterText,"Register","Error");                                      //Verify the text “Register”
        registerPage.inputFirstname("Pinks");                                                                            //Fill the mandatory fields
        registerPage.inputLastname("Shah");
        registerPage.inputEmail("ShahPinks@gmail.com");
        registerPage.inputPassword("Pink123");
        registerPage.inputConfirmPassword("Pink123");
        registerPage.clickOnRegisterButton();                                                                           //Click on “REGISTER” Button
        String actualRegisterSuccessMessage = registerPage.getRegisterSuccessText();                                    //Verify the message “Your registration completed”
        Assert.assertEquals(actualRegisterSuccessMessage,"Your registration completed","error");
        registerPage.clickOnContinueButton();                                                                           //Click on “CONTINUE” tab
        shoppingCartPage.getShoppingCartText();                                                                         //Verify the text “Shopping card”
    }
}

