package Chapter5_Lambda_Expression.Part1;

@FunctionalInterface
public interface FindMax<V> {
    V max(V a, V b);
}
