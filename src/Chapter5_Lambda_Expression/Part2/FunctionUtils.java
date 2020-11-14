package Chapter5_Lambda_Expression.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtils {
      // Applies an action on each item in a list
    public static <T> void forEach(List<T> items, Consumer<T> action)
    {
        for (T t : items)
        {
            action.accept(t);
        }
    }
    // Applies filter to a list and returned the filtered list
    public static <T> List<T> filter(List<T> items , Predicate<T> predicate)
    {
        List<T> filteredList = new ArrayList<>();
        for (T item : items)
        {
            if (predicate.test(item))
            {
                filteredList.add(item);
            }
        }
        return filteredList;
    }
    //  Maps each item in a list to a value
    public static <T, R> List<R> map(List<T> list, Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for(T item : list) {
            mappedList.add(mapper.apply(item));
        }
        return mappedList;
    }


}
