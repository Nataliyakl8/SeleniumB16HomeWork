package TestNg;

import org.testng.annotations.Test;

public class TestNgIntro {
    @Test(priority = 1,invocationCount = 10)
    public void test1(){
        System.out.println("I'm test one ");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("I'm test two ");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("I'm test three");
    }
}
