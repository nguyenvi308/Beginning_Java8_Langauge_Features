package Chapter4_Generics;


// Chapter Objectives
/*
•	 What generics are
•	 How to define generic types, methods, and constructors
•	 How to define bounds for type parameters
•	 How to use wildcards as the actual type parameters
•	 How the compiler infers the actual type parameters for generic type uses
•	 Generics and their limitations in array creations
•	 How the incorrect use of generics may lead to heap pollution
 */

//1. Why are generic ?
/*
Generics let you write true polymorphic code, which is code that works with any type
- Using Object wrapper
- It lets you specify a type parameter with a type (class or interface).
  Such a type is called a generic type (more specifically generic class or generic interface).
  The type parameter value could be specified when you declare a variable of the generic type
  and create an object of your generic type.
Example 1
+  T to indicate that the parameter is a type
+  E to indicate that the parameter is an element
+  K to indicate that the parameter is a key
+  V to indicate that the parameter is a value
If you want to use more than one parameter for a type, they must be separated by a comma.
 */

// Example 2

// 2. Supertype-Subtype Relationship
// Example 3
/*
- Wrapper<String> is not a Wrapper<Object>. The normal supertype/subtype rules do not apply with parameterized types.
- Because a class Wrapper with a instance variable type object and one Wrapper class with instance variable type
String -> It is impossible
- Even if it is impossible 2 classes is different. It just have a instance var is sub-sup class of each other
 */
// 3. Raw Type
/*
- Implementation of generic types in Java is backward compatible
-  If an existing non-generic class is rewritten to take advantage of generics,
   the existing code that uses the non-generic version of the class should keep working.Even thought it is not recommended
- The non-generic version of a generic type is called a raw type
// Example 4
 */
// 4. Unbounded Wildcards
// Example 5
/*
- The question mark in a wildcard generic type (e.g., <?>) denotes an unknown type. When you declare a
parameterized type using a wildcard (means unknown) as a parameter type, it means that it does not know about its type.

 */
// 5. Upper-Bounded Wildcards
/*
- T is a type. <? extends T> means anything that is of type T or its subclass is acceptable. Using your upper
bound as Number, you can define your method as
Example 6
 */

// 6. Lower-Bounded Wildcards
/*
-  Specifying a lower-bound wildcard is the opposite of specifying an upper-bound wildcard. The syntax for using a
lower-bound wildcard is <? super T>, which means “anything that is a supertype of T.”
- Example 7
 */
// 7. Generic Methods and Constructors
// Example 8
// 8. Type Inference in Generic Object Creation
// 9. No Generic Exception Classes
/*
- Exceptions are thrown at runtime. The compiler cannot ensure the type-safety of exceptions at runtime if you use a
generic exception class in a catch clause to catch an exception, because the erasure process erases the mention of
any type parameter during compilation.
- This is the reason that it is a compile-time error to attempt to define a generic
class, which is a direct or indirect subclass of java.lang.Throwable

 */
// 10. No Generic Anonymous Classes
/*
- An anonymous class is a one-time class. You need a class name to specify the actual type parameter.
- An anonymous class does not have a name. Therefore, you cannot have a generic anonymous class.
- However, you can have generic methods inside an anonymous class.
- Your anonymous class can inherit a generic class. An anonymous class can implement a generic interface.
- Any class, except an exception type, enums, and anonymous inner classes, can have type parameters.
 */
// 11. Generics and Arrays
/*
Recall that all references to the generic type are erased from the code when a generic class or code using it
is compiled. An array needs to know its type when it is created, so that it can perform a check at runtime when
an element is stored in it to make sure that the element is assignment-compatible with its type. An array’s type
information will not be available at runtime if you use a type parameter to create it.
- It is allowed to create an array of unbounded wildcard generic types, as shown:
- // Cannot create an array of generic type
 */

// Can not have two class with the same name
/*
// 12. Runtime Class Type of Generic Object
/*
- Example 12

- The program creates objects of the Wrapper class by using String and Integer as type parameters.
- It prints the class names for both objects and they are the same. The output shows that all parameterized objects
  of the same generic type share the same class object at runtime. As mentioned earlier, the type information
  you supply to the generic type is removed from the code during compilation. The compiler changes the Wrapper<String>
  a; statement to Wrapper a;. For the JVM, its business as usual (before pre-generics)!
 */
// 13. Heap Pollution
/*
Representing a type at runtime is called "reification". A type that can be represented at runtime is called a reifiable type.
A type that is not completely represented at runtime is called a non-reifiable type. Most generic types are non-reifiable
because generics are implemented using erasure, which removes the type’s parameters information at compile time.
For example, when you write Wrapper<String>, the compiler removes the type parameter <String> and the runtime
sees only Wrapper instead of Wrapper<String>.
Heap pollution is a situation that occurs when a variable of a parameterized type refers to an object not of the same
parameterized type. The compiler issues an unchecked warning if it detects possible heap pollution. If your program
compiles without any unchecked warnings, heap pollution will not occur. Consider the following snippet of code:
Example 13
 */

// Summary
/*
- Generics are the Java language features that allow you to declare types (classes and interfaces) that use type
  parameters.
- Type parameters are specified when the generic type is used. The type when used with the actual type
  parameter is known a parameterized type. When a generic type is used without specifying its type parameters,
  it is called a raw type.
    + For example, if Wrapper<T> is a generic class, Wrapper<String> is a parameterized type with String
      as the actual type parameter and Wrapper as the raw type. Type parameters can also be specified for
      constructors and methods. Generics allow you to write true polymorphic code in Java—code using a
      type parameter that works for all types.
- By default, a type parameter is unbounded, meaning that you can specify any type for the type parameter.
  For example, if a class is declared with a type parameter <T>, you can specify any type available in Java,
  such as <String>, <Object>, <Person>, <Employee>, <Integer>, etc., as the actual type for T.
  Type parameters in a type declaration can also be specified as having upper bounds or lower bounds.

- The declaration Wrapper<U extends Person> is an example of specifying an upper bound for the type parameter U
  that specifies that U can be of a type that is Person or a subtype of Person.

- The declaration Wrapper<? super Person> is an example of specifying a lower bound; it specifies
  that the type parameter is the type Person type of a supertype of Person.

- Java also lets you specify the wildcard, which is a question mark, as the actual type parameter. A wildcard as
  the actual parameter means the actual type parameter is unknown; for example, Wrapper<?> means that the type
  parameter T for the generic type Wrapper<T> is unknown.
- The Java compiler attempts to infer the type of an expression using generics, depending on the context in which
  the expression is used. If the compiler cannot infer the type, it generates a compile-time error and you will need to
  specify the type explicitly.The supertype–subtype relationship does not exist with parameterized types. For example, Wrapper<Long> is not
  a subtype of Wrapper<Number>.
- The generic type parameters are erased by the compiler using a process called type erasure. Therefore, the generic
  type parameters are not available at runtime. For example, the runtime type of Wrapper<Long> and
  Wrapper<String> are the same, which is Wrapper.


- The supertype–subtype relationship does not exist with parameterized types. For example, Wrapper<Long> is not
  a subtype of Wrapper<Number>.

- The generic type parameters are erased by the compiler using a process called type erasure. Therefore, the generic type parameters are not available at runtime. For example, the runtime type of Wrapper<Long> and
  Wrapper<String> are the same, which is Wrapper.


 */


import Chapter4_Generics.entities.Person;
import Chapter4_Generics.entities.Student;

// Example 2
class  MyClass<T,V,K,E>
{

}

public class Main {

    public static void main(String[] args) {
/*
        Wrapper<String> stringWrapper = new Wrapper<>("Hello !");
        stringWrapper.setRef("Nguyen Vi");
        String myName = stringWrapper.getRef(); // No need to cast
*/

        // Example 3
/*

        Wrapper<String> someString = new Wrapper<String>("Hello");
        stringWrapper.setRef("a string");
        Wrapper<Object> someObject = new Wrapper<>(new Object());
        someObject.setRef(new Object()); // Set another object

        // Using String object with someString
        someObject.setRef("A String"); // okay
        // someObject = someString; it is not allowed
*/
        WrapperUtils wrapperUtils = new WrapperUtils();

        // Example 4
        // This is non-generic
        /*
        Wrapper rawType = new Wrapper("Hello Raw Type !");
        Wrapper<String> genericType ;
        genericType = rawType; // An unchecked warning
        rawType = genericType;
        System.out.println(genericType.getRef());
        System.out.println(rawType.getRef());
        */
        // Example 5
        /*
        Wrapper<Object> objectWrapper = new Wrapper<>(new Object());

        wrapperUtils.printDetails(objectWrapper);

        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
        // wrapperUtils.printDetails(stringWrapper);
        // method printDetails in class WrapperUtil cannot be applied to given types;
*/
        // Test wild card
        Wrapper<Integer> integerWrapper = new Wrapper<>(10);
        /*
        Wrapper<String> stringWrapper1 = new Wrapper<>("Nguyen Vi");
        wrapperUtils.printDetails1(stringWrapper1);
        wrapperUtils.printDetails1(integerWrapper);
*/
        // Example 6 Upper-Bounded Wildcards
        /*
        Wrapper<Integer> n1 = new Wrapper<>(11);
        System.out.println(wrapperUtils.sum(n1, integerWrapper));
        */
        // Example 7
        /*Wrapper<Object> objectWrapper1 = new Wrapper<Object>(new Object());
        Wrapper<String> stringWrapper2 = new Wrapper<String>("Hello");
        WrapperUtils.copy(stringWrapper2, objectWrapper1); // OK with the new copy() method
*/
        // Example 7 Version 2
        /*
        Wrapper<Student> st = new Wrapper<>(new Student());
        Wrapper<Person> person = new Wrapper<>(new Person());
        wrapperUtils.copyLowerBound(st, person);
*/
        // Example 8



        Test<String> t = new Test<>();
        Wrapper<Integer> iw1 = new Wrapper<>(10);
        Wrapper<Integer> iw2 = new Wrapper<>(11);
        // Specify that Integer is the actual type for the parameter for m1
        t.<Integer>m1(iw1, iw2 , "Hello");
        // Let the compiler figure out the actual type parameter for the m1() call
        // using types for iw1 and iw2
        t.m1(iw1, iw2, "hello"); // OK
        Test.copy(iw1,iw2);
        Wrapper<Student> st = new Wrapper<>(new Student());
        Wrapper<Person> person = new Wrapper<>(new Person());
        Test.copy(st,person);

        // Constructor <U extends T>
        // T is person U is student that extends T
        Test<Person> p = new Test<>(new Student());






        // Cannot create an array of generic type
        Wrapper<String>[] wrappers = null;
        // wrappers = new Wrapper<String>[10];


        Wrapper<?>[] wrappers1 = new Wrapper<?>[10]; // OK





        Wrapper<Student> studentWrapper = new Wrapper<>(new Student());
        Wrapper<Person> personWrapper = new Wrapper<>(new Person());
        Class a = studentWrapper.getClass();
        Class b = personWrapper.getClass();
        System.out.println("Student Wrapper Object " + a);
        System.out.println("Person Wrapper Object " + b);
        System.out.println(a == b);


        /*Wrapper nWrapper = new Wrapper<Integer>(101); // #1
        // Unchecked warning at compile-time and heap pollution at runtime
        Wrapper<String> sWrapper = nWrapper; // #2
        String str = sWrapper.getRef(); // #3 - ClassCastException
        System.out.println(str);*/
        /*
        The first statement (labeled #1) compiles fine. The second statement (labeled #2) generates an unchecked
warning because the compiler cannot determine if nWrapper is of the type Wrapper<String>. Since parameter type
information is erased at compile-time, the runtime has no way of detecting this type mismatch. The heap pollution in
the second statement makes it possible to get a ClassCastException in the third statement (labeled #3) at runtime. If
the second statement was not allowed, the third statement will not cause a ClassCastException.
Heap pollution may also occur because of an unchecked cast operation.
         */


        Wrapper<Student> st1 = new Wrapper<>(new Student("Vi"));
        Wrapper<Person> p1 = new Wrapper<>(new Person("Nguyen"));
        WrapperUtils wrapperUtils1 = new WrapperUtils();
        wrapperUtils.copyLowerBoundV1(st1,p1);
        System.out.println(p1.getRef().getName());






    }

}
