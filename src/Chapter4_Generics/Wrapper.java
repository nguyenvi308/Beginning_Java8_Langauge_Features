package Chapter4_Generics;
// Example 1
/*
You will be using your type parameter named T inside the class code in instance variable declarations,
constructors, the get() method, and the set() method

- The parameter that is specified in the type declaration is called a formal type parameter
- You replace the formal type parameter T with String), it is called a parameterized type
- A reference type in Java, which accepts one or more type parameters, is called a generic type.
  A generic type is mostly implemented in the compiler.
- The JVM has no knowledge of a generic type. All actual type parameters are erased during compile time using a process known as erasure

 */
public class Wrapper<T>// Type Declaration
  {

    private T ref;

    public Wrapper(T ref) {
        this.ref = ref;
    }

    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }
}
