package Java8.MyCollection;

/**
 * MyIterable
 * @param <T>
 */
public interface MyIterable<T> {

    MyIterator<T> iterator();
}