package parser;

import org.testng.Assert;

public class UnitTestingStudentProfile {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

        Student st = new Student ("shagria","kabir",95,101);

        Assert.assertEquals(st.getFirstName(),"shagria");
        Assert.assertEquals(st.getLastName(),"kabir");
        Assert.assertEquals(st.getScore(),90);
        Assert.assertEquals(st.getId(),101);

    }
}