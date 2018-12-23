package math.problems;

import org.testng.Assert;

public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.

        try {//unit testing
            Assert.assertEquals(Factorial.fact(5), 120);
            System.out.println("Unit testing passed");
        }catch (AssertionError ar){
            System.out.println("Unit testing failed");
        }

    }
}
