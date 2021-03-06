package day5.MyShopTest;

import day4.testBase;
import day5.MyStore.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopProcessTests extends testBase {

    @Test
    public void shouldCorrectlyAddMultipleItemsToCartTest(){
        // 3 razy wylosuj produkt i ilosc -> dodaj do koszyka
        // przejdz do koszyka
        // sprawdz wartosc i prawidlowosc sumy itemow w koszyku
        HomepagePO homepagePO = new HomepagePO(driver);
        MenuPO menuPO = new MenuPO(driver);
        ShoppingCartPO shoppingCartPO = new ShoppingCartPO(driver);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        ProductAddedToCartPO productAddedToCartPO = new ProductAddedToCartPO(driver);
        homepagePO.openMe();

        //podpowiedz:
        int totalQuantity = 0;
        double value = 0;

        for (int i=0;i<3;i++){
            int numberOfRandomMiniature = getRandomNumber(homepagePO.miniaturesNumber() - 1);
            double price = homepagePO.getPriceOfNthMiniature(numberOfRandomMiniature);
            int quantity = getRandomNumber(10);
            value += price*quantity;
            totalQuantity += quantity;
            homepagePO.openQuickViewOfNthMiniature(numberOfRandomMiniature);
            quickViewPO.setQuantity(quantity);
            quickViewPO.addToCart();
            productAddedToCartPO.clickContinueShoping();
        }
        menuPO.openCart();

        Assert.assertEquals(totalQuantity,shoppingCartPO.getTotalNumberofItemsInTheCart());
        Assert.assertEquals(value,shoppingCartPO.getSubtotal(),0.001);
    }
}