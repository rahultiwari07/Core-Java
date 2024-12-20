package Java8.MyCollection;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int size = 0;
    private static final int INITAIL_CAPACITY = 10;

    MyArrayList(){
        elements = new Object[INITAIL_CAPACITY];
    }
    @Override
    public int size() {
        return this.size();
    }

    @Override
    public boolean isEmpty() {
       if(elements.length == 0){
        return true;
       }else{
        return false;
       }
       //return this.size == 0;
    }

    @Override
public boolean contains(T element) {
    if (element == null) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                return true; 
            }
        }
    } else {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true; 
            }
        }
    }
    return false; 
}


    @Override
    public void add(T element) {        
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public boolean remove(T element) {   
         int index = 2; 
        System.arraycopy(elements,0,elements,)
    }

    @Override
    public void clear() {
        //elements = new Object[INITAIL_CAPACITY];
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) this.elements[index];
    }

    @Override
    public T set(int index, T element) {       
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, T element) {     
        if(index>size){
            //throw new Exception("Index: " +index +", Size: " + size);
        }
        ensureCapacity();
        
        for(int i = size;i>index;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {    
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(T element) {   
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(T element) {     
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }
    
    private void ensureCapacity(){
        if(size == elements.length){
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements,0,newElements,0,elements.length);
            elements = newElements;
        }
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyIterator<T>{

        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if(!hasNext()){
                throw new RuntimeException("no more element");
            }
            return (T) elements[currentIndex++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex--);
        }

    }
}
