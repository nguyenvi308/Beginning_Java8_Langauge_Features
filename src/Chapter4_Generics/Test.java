package Chapter4_Generics;

// Example 8

public class Test<T> {


    // Generic constructor

    public <U extends T> Test()
    {

        // Do some thing

    }

    public <U extends T> Test(U k)
    {
        // Do some thing
    }
    public <V> void m1(Wrapper<V> a, Wrapper<V> b, T c)
    {
        // Do something
    }

    public static <T> void copy(Wrapper<T> source, Wrapper<? super  T> dest)
    {
        T value = source.getRef();
        dest.setRef(value);
    }

}
