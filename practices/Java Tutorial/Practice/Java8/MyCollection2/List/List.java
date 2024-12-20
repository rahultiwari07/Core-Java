package Java8.MyCollection2.List;

import Java8.MyCollection2.Iterator2;

public interface List{

    boolean add(int element);
    boolean remove(int element);
    int size();
    boolean contains(int element);
    Iterator2 iterator();  

    void add(int index, int element);
    int get(int index);
    void clear();
    boolean isEmpty();
    boolean contains(Object o);
    boolean remove(Object o);
    int indexOf(Object o);
    Object[] toArray();
    // Query Operations
    // int size();
    // boolean isEmpty();
    // boolean contains(Object o);
    // Object[] toArray();
    // //<T> T[] toArray(T[] a);
    
    // // Positional Access Operations
    // E get(int index);
    // E set(int index, E element);
    // boolean add(E e);
    // void add(int index, E element);
    // E remove(int index);
    // boolean remove(Object o);
    // // Search Operations
    // int indexOf(Object o);
    // int lastIndexOf(Object o);
    // // List Iterators
    // ListIterator<E> listIterator();
    // ListIterator<E> listIterator(int index);
  
    // // View
    // List<E> subList(int fromIndex, int toIndex);
    
    // // Bulk Operations
    // boolean addAll(Collection<? extends E> c);
    // boolean addAll(int index, Collection<? extends E> c);
    // boolean removeAll(Collection<?> c);
    // boolean retainAll(Collection<?> c);
    // void clear();
    
    // // Default Methods in List
    // default void replaceAll(UnaryOperator<E> operator) {
    //     ListIterator<E> li = listIterator();
    //     while (li.hasNext()) {
    //         li.set(operator.apply(li.next()));
    //     }
    // }
    
    // default void sort(Comparator<? super E> c) {
    //     E[] a = (E[]) toArray();
    //     Arrays.sort(a, c);
    //     ListIterator<E> i = listIterator();
    //     for (E e : a) {
    //         i.next();
    //         i.set(e);
    //     }
    // }
}
