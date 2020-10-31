package Chapter5_Lambda_Expression.Part1;


//1. What is lambda expression ?
/*
- A lambda expression is an unnamed block of code (or an unnamed function) with a list of formal parameters and a
body. Sometimes a lambda expression is simply called a lambda.
- The body of a lambda expression can be a block
statement or an expression.
-  An arrow (->) is used to separate the list of parameters and the body


- a lambda expression is not a method, although its declaration looks similar to a method. as the name suggests,
a lambda expression is an expression that represents an instance of a functional interface.
- Every expression in Java has a type; so does a lambda expression. The type of a lambda expression is a functional
interface type. When the abstract method of the functional interface is called, the body of the lambda expression is
executed.
- Java is a strongly-typed language, which means that the compiler must know the type of all expressions used
in a Java program. a lambda expression by itself does not have a type, and therefore, it cannot be used as a standalone
expression. the type of a lambda expression is always inferred by the compiler by the context in which it is used.

 */
//2.  Why Do We Need Lambda Expressions?

//3. Syntax for Lambda Expression
/*
•	 A lambda expression does not have a name.
•	 A lambda expression does not have a return type. It is inferred by the compiler from the
     context of its use and from its body.
•	 A lambda expression does not have a throws clause. It is inferred from the context of its use
     and its body.
•	 A lambda expression cannot declare type parameters. That is, a lambda expression
     cannot be generic
     3.1 Omitting Parameter Types
         // Types of parameters are declared
                (int x, int y) -> { return x + y; }
         // Types of parameters are omitted
                (x, y) -> { return x + y; }
         // A compile-time error
                (int x, y) -> { return x + y; }
      3.2 Declaring a Single Parameter
            // Declares the parameter type
                (String msg) -> { System.out.println(msg); }
            // Omits the parameter type
                (msg) -> { System.out.println(msg); }
            // Omits the parameter type and parentheses
                msg -> { System.out.println(msg); }
            // Omits parentheses, but not the parameter type, which is not allowed.
                String msg -> { System.out.println(msg); }
      3.3 Declaring No Parameters
            // Takes no parameters
                () -> { System.out.println("Hello"); }
            // Compile time error
                -> { System.out.println("Hello"); }
      3.4 Parameters with Modifiers
            (final int x, final int y) -> { return x + y; }
            (int x, final int y) -> { return x + y; }
            // The following lambda expression will not compile because it uses the final modifier
            // in parameter declarations, but omits the parameter type:
            (final x, final y) -> { return x + y; }
 */
//4. Target Type
/*
- Every lambda expression has a type, which is a functional interface type. In other words, a lambda expression
represents an instance of a functional interface.
Example 2
- What is the type of this lambda expression?
(x, y) -> x + y
 + All we can say about
this lambda expression with confidence is that it takes two parameters named x and y
 + We cannot tell its return type
as the expression x + y, depending on the type of x and y, may evaluate to a number (int, long, float, or double)
or a String. This is an implicit lambda expression, and therefore, the compiler will have to infer the types of two
parameters using the context in which the expression is used. This lambda expression may be of different functional
interface types depending on the context in which it is used.
There are two types of expressions in Java:
•	 Standalone Expressions
•	 Poly Expressions


A standalone expression is an expression whose type can be determined by the expression without knowing the
context of its use. The following are examples of standalone expressions:
// The type of expression is String
new String("Hello")
// The type of expression is String (a String literal is also an expression)
"Hello"
// The type of expression is ArrayList<String>
new ArrayList<String>()
A poly expression is an expression that has different types in different contexts.
The compiler determines the type of the expression. The contexts that allow the use of poly expressions are known as poly contexts.
All lambda expressions in Java are poly expressions. You must use it in a context to know its type.
Poly expressions existed in Java prior to Java 8 and lambda expressions
For example, the expression new ArrayList<>() is a poly expression. You
cannot tell its type unless you provide the context of its use.
The compiler infers the type of a lambda expression. The context in which a lambda expression is used expects
a type, which is called the target type. The process of inferring the type of a lambda expression from the context is
known as target typing
T t = <LambdaExpression>;

The compiler uses the following rules to determine
whether the <LambdaExpression> is assignment compatible with its target type T

•	T must be a functional interface type.
•	 The lambda expression has the same number and type of parameters as the abstract method
of T. For an implicit lambda expression, the compiler will infer the types of parameters from
the abstract method of T.
•	 The type of the returned value from the body of the lambda expression is assignment
compatible to the return type of the abstract method of T.
•	 If the body of the lambda expression throws any checked exceptions, those exceptions must
be compatible with the declared throws clause of the abstract method of T. It is a compile-time
error to throw checked exceptions from the body of a lambda expression, if its target type's
method does not contain a throws clause.

- I will now discuss the target typing in the context of method calls. You can pass lambda expressions as arguments
to methods
 */



public class Main {
    public static void main(String[] args) {

        // Example 1 First Lambda
        /*// Wrong not a type of lambda
        StringToIntMapper mapper = (String s) ->  s.length();
        int a = mapper.map("Nguyen Vi");
        System.out.println(a);
        // Example of Lambda
            // Take one parameter and increase it
                // (int a) -> a+1;
            // Take two parameters and sum it up
                // (x, y) -> x+y;
            // Takes two int parameters and returns the maximum of the two
                    //(x,y) -> {
                    //     int max =  (x>y) ? x : y;
                    //     return max;
                    //};
            // Takes no parameters and returns void
                     //() -> { }
            // Take a String and print it out
                     //(String s) -> {
                     //System.out.println(s);};
        // Test Find Max interface
        FindMax<Integer> findMax = (d,b) -> {
            int c = (d > b) ? d : b;
            return c;
        };
        System.out.println(findMax.max(10,20));
*/
        // Example 2 Target Type
        Adder adder = (x,y) -> x+y;
        // The type of the adder variable is Adder
        // . The lambda expression is assigned to the variable adder, and therefore,
        //the target type of the lambda expression is Adder
        // The compiler verifies that Adder is a functional interface. The
        //lambda expression is an implicit lambda expression. The compiler finds that the Adder interface contains a double
        //add(double, double) abstract method. It infers the types for x and y parameters as double and double, respectively
        // At this point, the compiler treats the statement as shown:
        // Adder adder = (double x, double y) -> x + y;


        // Lambda Utils Example 1
        LambdaUtils lambdaUtils = new LambdaUtils();
        lambdaUtils.testAdder((x,y) -> x+y);
        lambdaUtils.testJoiner((x,y)-> x+ y);
        // The compiler must infer the type of the lambda expression. The target type of the lambda expression
        // is the type Adder because the argument type of the testAdder(Adder adder) is Adder
        // Lambda Utils Example 2
        // Call the testAdder() method
        lambdaUtils.testAdder((x, y) -> x + y);
        // Call the testJoiner() method
        lambdaUtils.testJoiner((x, y) -> x + y);
        // Call the testJoiner() method. The Joiner will
        // add a space between the two strings
        lambdaUtils.testJoiner((x, y) -> x + " " + y);
        // Call the testJoiner() method. The Joiner will
        // reverse the strings and join resulting strings in
        // reverse order adding a comma in between
        lambdaUtils.testJoiner((x, y) -> {
            StringBuilder sbx = new StringBuilder(x);
            StringBuilder sby = new StringBuilder(y);
            sby.reverse().append(",").append(sbx.reverse());
            return sby.toString();
        });
        // Notice the output of the LambdaUtilTest class. The testJoiner() method was called three times, and every time
        //it printed a different result of joining the two strings “Hello” and “World”. This is possible because different lambda
        //expressions were passed to this method
        // . Changing the
        //behavior of a method through its parameters is known as behavior parameterization. This is also known as passing
        //code as data because you pass code (logic, functionality, or behavior) encapsulated in lambda expressions to methods
        //as if it is data

        // Example 3
        // It is not always possible for the compiler to infer the type of a lambda expression. In some contexts, there
        //is no way the compiler can infer the type of a lambda expression; those contexts do not allow the use of lambda
        //expressions. Some contexts may allow using lambda expressions, but the use itself may be ambiguous to the compiler;
        //one such case is passing lambda expressions to overloaded methods.
        // lambdaUtils.test((x,y) -> x+y);
        // Ambiguous call
        // The following are the some
        //of the ways to help the compiler resolve the ambiguity:
            // Method 1
            lambdaUtils.test((Adder)(x,y) -> x+y);
            // Method 2
            lambdaUtils.test((double x, double y) -> x+y);
            // Method 3
            Adder adder1 = (x,y) -> x+y;
            lambdaUtils.test(adder1);
        // Lambda expressions can be used only in the following contexts:
        /*
        - Assignment Context: A lambda expression may appear to the right-hand side of the assignment operator in an assignment statement.
                            For example, ReferenceType variable1 = LambdaExpression;
        - Method Invocation Context: A lambda expression may appear as an argument to a method or constructor call.
                            For example, util.testJoiner(LambdaExpression);
        - Return Context: A lambda expression may appear in a return statement inside a method, as its target type is the declared return type of the method.
                            For example, return LambdaExpression;
        - Cast Context: A lambda expression may be used if it is preceded by a cast. The type specified in the cast is its target type.
                            For example, (Joiner) LambdaExpression;
         */






    }
}
