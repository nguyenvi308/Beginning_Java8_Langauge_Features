package Chapter5_Lambda_Expression.Part2;

//1. Functional Interfaces
// 1.1 Using the @FunctionalInterface Annotation
/*
A functional interface is simply an interface that has exactly one abstract method.
The following types of methods in an interface do not count for defining a functional interface:
    •	 Default methods
    •	 Static methods
    •	 Public methods inherited from the Object class
 */

// 1.2 Generic Functional Interface
// 1.3 Intersection Type and Lambda Expressions
/*
// Sensitive.java
public interface Sensitive {
// It is a a marker interface. So, no methods exist.
}
Suppose you have a lambda expression assigned to a variable of the Sensitive type.
Sensitive sen = (x, y) -> x + y; // A compile-time error
 */
// 1.4 Commonly Used Functional Interfaces
// 1.5 Using the Function<T,R> Interface
/*
Six specializations of the Function<T, R> interface exist:
•	 IntFunction<R>
•	 LongFunction<R>
•	 DoubleFunction<R>
-> IntFunction<R>, LongFunction<R>, and DoubleFunction<R> take an int, a long, and a double as an argument,
respectively, and return a value of type R.
•	 ToIntFunction<T>
•	 ToLongFunction<T>
•	 ToDoubleFunction<T>
-> ToIntFunction<T>, ToLongFunction<T>, and ToDoubleFunction<T> take an
argument of type T and return an int, a long, and a double, respectively.
 */

// Example 1



// 1.6 Some default function
// 1.6.1 Function<T,V>
/*
•	 default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
        The andThen() method returns a composed Function that applies this function to the argument, and then
applies the specified after function to the result.

•	 default <V> Function<V,R> compose(Function<? super V,? extends T> before)
        The compose() function returns a composed function that applies
the specified before function to the argument, and then applies this function to the result

•	 static <T> Function<T,T> identity()
 */
// 1.6.2 Predicate<T>
/*
•	 default Predicate<T> negate()
•	 default Predicate<T> and(Predicate<? super T> other)
•	 default Predicate<T> or(Predicate<? super T> other)
•	 static <T> Predicate<T> isEqual(Object targetRef)
 */
// 1.6 Using Functional Interfaces


import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // Example1 Using Function<T, V>
       /* Function<Integer, Integer> square1 = x -> x * x;
        IntFunction<Integer> square2 = x -> x * x;
        ToIntFunction<Integer> square3 = x -> x * x;
        UnaryOperator<Integer> square4 = x -> x * x;
        Function<String, Long> lengthOfSomething = str -> Long.valueOf(str.length());



        System.out.println(square1.apply(5));
        System.out.println(square2.apply(5));
        System.out.println(square3.applyAsInt(5));
        System.out.println(square4.apply(5));
        System.out.println(lengthOfSomething.apply("Nguyen Vi"));

        // Using andThen function

        // Create two functions
        Function<Long, Long> square = x -> x * x;
        Function<Long, Long> addOne = x -> x + 1;

        // Compose functions from the two functions
        Function<Long, Long> squareAddOne = square.andThen(addOne);
        Function<Long, Long> addOneSquare = square.compose(addOne);

        // You are not limited to composing a function that consists of two functions that are executed in a specific order.
        //A function may be composed of as many functions as you want. You can chain lambda expressions to create a
        //composed function in one expression. Note that when you chain lambda expressions, you may need to provide
        //hints to the compiler to resolve the target type ambiguity that may arise.
        Function<Long, Long> chainedFunction = ((Function<Long, Long>) (x -> x*x)).andThen(x -> x+1).andThen(x-> x*x);
        System.out.println(chainedFunction.apply(5L));*/
        // Example 2 Using Predicate<T>
        Predicate<Integer> greaterThan10 = x -> x> 10;
        Predicate<Integer> divisibleBy3 = x -> x%3 == 0;
        Predicate<Integer> divisibleBy5 = x -> x%5 == 0;
        Predicate<Integer> equalToTen = Predicate.isEqual(10);
            System.out.println(greaterThan10.test(10));
            System.out.println(divisibleBy3.test(10));
            System.out.println(divisibleBy5.test(10));

        // Using default method
        Predicate<Integer> lestThanOrEqualTo10 = greaterThan10.negate();
        Predicate<Integer> divisibleByThreeAndFive = divisibleBy3.and(divisibleBy5);
        Predicate<Integer> divisibleByThreeOrFive = divisibleBy3.or(divisibleBy5);





    }


}
