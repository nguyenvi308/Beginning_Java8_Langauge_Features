package Chapter5_Lambda_Expression.Part3;

import java.util.function.Function;
import java.util.function.ToIntFunction;

// Method Reference
//1. What is it ?
//2. General Syntax
/*
- The general syntax for a method reference is
<Qualifier>::<MethodName>
- a method reference does not call the method when it is declared. the method is called later when the method
of its target type is called.
Syntax                          Meaning
TypeName::staticMethod          A method reference to a static method of a class, an interface, or an enum
objectRef::instanceMethod       A method reference to an instance method of the specified object
ClassName::instanceMethod       A method reference to an instance method of an arbitrary object of the specified class
TypeName.super::instanceMethod  A method reference to an instance method of the supertype of a particular object
ClassName::new                  A constructor reference to the constructor of the specified class
ArrayTypeName::new              An array constructor reference to the constructor of the specified array type


Static Method References
    static String toBinaryString(int i)
    Example 2
    Let’s try using a method reference of the overloaded static method valueOf() of the Integer class. The method
    has three versions:
    •	 static Integer valueOf(int i)
    •	 static Integer valueOf(String s)
    •	 static Integer valueOf(String s, int radix)






 */
public class Main {

    public static void main(String[] args) {

        // Example 1 Using Lambda Expression
        ToIntFunction<String> lengthFunction = str -> str.length();
        String myName = "Nguyen Vi";
        System.out.println(lengthFunction.applyAsInt(myName));
        // Example 1 Using Method Reference
        ToIntFunction<String> lengthFunctionMethodReference = String::length;
        System.out.println(lengthFunctionMethodReference.applyAsInt(myName));
        // Example 2: Static Method Reference
        Function<Integer, String> function1 = x -> Integer.toBinaryString(x);
        System.out.println(function1.apply(17));



    }


}
