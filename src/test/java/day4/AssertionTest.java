package day4;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssertionTest {

    @Test
    public void thisCanPass() throws FileNotFoundException {
        Assert.assertEquals(1, 2);

        String expectedText="asd"; // dla np sdfg bedzie false
        Assert.assertEquals("asd", expectedText);
        Assert.assertTrue(true);
    }

    @Test
    public void youShallNotPass() throws FileNotFoundException{

    }
 //test
    @BeforeClass
    public void executeBeforeClass(){
        System.out.println("to się wykona przed wszystkim");
    }

    @BeforeMethod
    public void executeBeforeMethod(){
        System.out.println("to sie wykona przed kazdym testem");
    }

    @Test
    public void myFirstTest(){
        System.out.println("to jest pierwszy test");
    }
    @AfterMethod
    public void executeAfterMethod(){
        System.out.println("to sie wykona po kazdym tescie");
    }

    @AfterClass
    public void executeAfterClass(){
        System.out.println(" to się wykona po wszystkim");

    }
}
