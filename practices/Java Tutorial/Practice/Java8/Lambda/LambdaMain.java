package Java8.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface A1{
    //public void sayHellow();
    int compare(int i1, int i2);
}

public class LambdaMain {   
    public static void main(String[] args) {
        
        Comparator<Integer> comparator = (a,b) -> a < b ? -1 : (a>b ? 1:0);
        List<Integer> li = Arrays.asList(2,5,4,3,5,6,7);
        List<String> l2 = new ArrayList<>();
        l2.add("Rahul");
        l2.add("Ankita");
        System.out.println(l2);
        System.out.println(li);
        li.sort(comparator);
        System.out.println(li);
        System.out.println(comparator.reversed());

    }

    private void sortList(List<Integer> li){
        
    }
}

