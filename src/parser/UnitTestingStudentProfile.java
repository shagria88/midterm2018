package parser;

import org.testng.Assert;

public class UnitTestingStudentProfile {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

        Student student = new Student("Amir", "Khalid", "Golden", "007");

        try{//method getFirst name
            Assert.assertEquals(student.getFirstName(),"Amir");
            System.out.println("Test Passed getFirstName");
        }catch ( AssertionError as){
            System.out.println("Test Failed getFirstName");
            System.out.println(as.getMessage());
            System.out.println(as.getStackTrace());
        }

        try{//method last name
            Assert.assertEquals(student.getLastName(),"Khalid");
            System.out.println("Test passed lastName");
        }catch (AssertionError as){
            System.out.println("Test Failed lastName");
            System.out.println(as.getMessage());
            System.out.println(as.getStackTrace());
        }

        try{//method get id
            Assert.assertEquals(student.getId(),"017");
            System.out.println("Test passed getId");
        }catch (AssertionError as){
            System.out.println("Test Failed getId");
            System.out.println(as.getMessage());
            System.out.println(as.getStackTrace());
        }

        try{//method get score
            Assert.assertEquals(student.getScore(),"Golden");
            System.out.println("Test passed getScore");
        }catch (AssertionError as){
            System.out.println("Test Failed getScore");
            System.out.println(as.getMessage());
            System.out.println(as.getStackTrace());
        }

        try{//method toString
            Assert.assertEquals(student.toString(),"Student(id= 007)Amir Khalid  Grade = Golden");
            System.out.println("Test passed toString");
        }catch (AssertionError as){
            System.out.println("Test Failed toString");
            System.out.println(as.getMessage());
            System.out.println(as.getStackTrace());
        }
    }
}