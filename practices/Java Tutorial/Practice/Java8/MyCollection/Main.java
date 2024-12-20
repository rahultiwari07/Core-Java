package Java8.MyCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

interface MyIter1<T> {
    boolean hasNext1();
    
}
interface MyiterIm<T> extends MyIter1<T>{
    String uter();
}

class MyIteratorImpl<T> implements MyIterator<T>{

    public boolean hasNext(){
        return true;
    }  
    public T next(){
        return null;
    }         
    public void remove(){
        
    }
}

public class Main {
    
    public static void main(String[] args){
        
        int[] a = {4, 6,2,2, 2, 8, 7, 4, 9, 4,2};
        int count = 0;
        for(int i =0 ;i< a.length;i++){
            if(a[i]==2){
               count++;
            }
        }
           System.out.println(count);          
    }
    
}
