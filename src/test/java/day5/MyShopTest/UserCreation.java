package day5.MyShopTest;

import day4.testBase;
import day5.MyStore.CreateAccountPO;
import day5.MyStore.HomepagePO;
import day5.MyStore.LogInPO;
import day5.MyStore.MenuPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreation extends testBase {

   @Test
   public void successfulUserRegistrationTest(){
      //given
      String firstName = "Bogdan";
      String lastname = "Wiadro";
      String email = "test"+System.currentTimeMillis()+"@test.com";
      HomepagePO homepagePO = new HomepagePO(driver);
      homepagePO.openMe();
      MenuPO menuPO = new MenuPO(driver);
      //when
      menuPO.clickSignInOutButton();
      LogInPO loginPO = new LogInPO(driver);
      loginPO.clickCreateAccountLink();
      CreateAccountPO createAccountPO = new CreateAccountPO(driver);
      createAccountPO.fillFormAndSubmit(true,
              firstName,
              lastname,
              email,
              "AAAABBBB",
              "05/08/2000");
      //then
      Assert.assertTrue(menuPO.logoutVisible());
      Assert.assertEquals(menuPO.getUserName(),firstName+" "+lastname);
   }

   @Test
   public void userRegistrationShouldFailWhenSameEmailIsUsedMoreThanOnceTest(){
      //given
      String firstName = "Bogdan";
      String lastname = "Wiadro";
      String email = "test@test.com";
      HomepagePO homepagePO = new HomepagePO(driver);
      MenuPO menuPO = new MenuPO(driver);
      LogInPO loginPO = new LogInPO(driver);
      CreateAccountPO createAccountPO = new CreateAccountPO(driver);



      //when
      homepagePO.openMe();
      menuPO.clickSignInOutButton();
      loginPO.clickCreateAccountLink();
      createAccountPO.fillFormAndSubmit(true,
              firstName,
              lastname,
              email,
              "AAAABBBB",
              "05/08/2000");
      //then
      Assert.assertTrue(createAccountPO.getAlertText().contains("already used"));
   }

}