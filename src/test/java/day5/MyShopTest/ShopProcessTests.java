package day5.MyShopTest;

import day4.testBase;
import day5.MyStore.HomepagePO;
import day5.MyStore.MenuPO;
import day5.MyStore.QuickViewPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopProcessTests extends testBase {

        @Test
        public void shouldCorrectlyAddMultipleItemsToCartTest(){
            // 3 razy wylosuj produkt i ilosc -> dodaj do koszyka
            // przejdz do koszyka
            // sprawdz wartosc i prawislowos (istnienie) dobrych obiektow w koszyku

            HomepagePO homepagePO = new HomepagePO(driver);
            MenuPO menuPO= new MenuPO(driver);
            homepagePO.openMe();

            int totalQuantity=0;
            //double price;
            double Value =0;

                    for(int i=0;i<3;i++){
                        for(int j=0;j<10;j++){
                            System.out.println();
                        }
                    }
                    menuPO.openCart();

        }
Assert.assertEquals(totalQuantity, shoppingCart)
}
