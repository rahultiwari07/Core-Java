package Java8.MyCollection;

public interface MyIterator<T> {

    boolean hasNext();   
    T next();            
    void remove(); 
}
