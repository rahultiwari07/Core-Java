package Java8.MyCollection;

public interface MyList<T> extends MyCollection<T> {
    T get(int index);
    T set(int index, T element);
    void add(int index, T element);
    T remove(int index);
    int indexOf(T element);
    int lastIndexOf(T element);
}
