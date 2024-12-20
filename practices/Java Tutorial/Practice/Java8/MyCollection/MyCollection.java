package Java8.MyCollection;

public interface MyCollection<T> extends MyIterable<T> {

    int size();
    boolean isEmpty();
    boolean contains(T element);
    void add(T element);
    boolean remove(T element);
    void clear();
} 
