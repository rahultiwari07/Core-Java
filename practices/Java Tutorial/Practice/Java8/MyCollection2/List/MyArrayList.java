package Java8.MyCollection2.List;

import java.util.ArrayList;
import java.util.Arrays;

import Java8.MyCollection2.Iterator2;

public class MyArrayList implements List {

    private int[] elements;
    private static int INITIAL_SIZE = 10;
    private int size = 0;

    MyArrayList(){
        this.elements = new int[INITIAL_SIZE];
    }

    @Override
    public boolean add(int element) {
        if(size == elements.length){
            grow();
        }
        this.elements[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(int element) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(int element) {
        for(int i =0;i<elements.length;i++){
            if(elements[i]==element){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator2 iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            grow(); 
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element; 
        size++; 
    }
    

    @Override
    public int get(int index) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    @Override
    public void clear() {
        this.elements = new int[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public boolean remove(Object o) {
        int count = 0;
        for(int i =0;i<size -1;i++){
            if(elements[i] == (int)o){
                count++;
            }
        }

        int index = 0;
        int[] newElements = new int[size-count];
        for(int i =0;i<size -1;i++){
            if(elements[i] == (int)o){
                newElements[index++] = elements[i];
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    private void grow(){
        if(size == INITIAL_SIZE){
            int[] newElements = new int[INITIAL_SIZE * 2];
            System.arraycopy(elements,0,newElements,0,elements.length);
            elements = newElements;
        }
    }
    
}
