package design;

public abstract class AbstractClass implements Employee{

    final String empName = "John Smith";
    static String resignationDate = "01/01/2010";

    public void performance (){}

    public void performance(String rating) {
        System.out.println("Employee performance is "+rating);
    }
    public void farewell(){}

    public void farewell(int date) {
        System.out.println(empName+"'s last day was"+resignationDate);

    }

}