package Chapter5_Lambda_Expression.Part1;

public class LambdaUtils {

    // Example 2
    public void testAdder(Adder adder)
    {
        double x = 90.0;
        double y = 10.0;
        double sum = adder.sum(x,y);
        System.out.println(sum);
    }
    public void testJoiner(Joiner joiner)
    {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = joiner.join(s1,s2);
        System.out.print("Using a Joiner:");
        System.out.println("\"" + s1 + "\" + \"" + s2 + "\" = \"" + s3 + "\"");;
    }

    // Example 3
    public void test(Adder adder) {
        double x = 190.90;
        double y = 8.50;
        double sum = adder.sum(x, y);
        System.out.print("Using an Adder:");
        System.out.println(x + " + " + y + " = " + sum);
    }
    public void test(Joiner joiner) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = joiner.join(s1,s2);
        System.out.print("Using a Joiner:");
        System.out.println("\"" + s1 + "\" + \"" + s2 + "\" = \"" + s3 + "\"");;
    }


}
