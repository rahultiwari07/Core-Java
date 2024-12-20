import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Point { int x, y; 
 public void display1(){
    System.out.println("Point class");
 }
}
class ColoredPoint extends Point { int color; 
    public void display(){
        System.out.println("Collered - Point class");
     }
    }
public class Test {
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>(Arrays.asList(8,7,6,5,2,4,5,6,1,2,7,6,1,1,1,3));
        //removeDuplicate1(list);
        //removeDuplicate2(list);
        //getCountOfEachElement(list);
        reverseDecimalList();
    }

    //can remove using set ,linkedset ,Map and by using manual logic
    private static void removeDuplicate1(List<Integer> list){
        Set<Integer> set = new LinkedHashSet<>();
        for(int i =0 ;i<list.size();i++){
            set.add(list.get(i));
        }
        System.out.println("Unique : =>  " + set);
    }
    private static void removeDuplicate2(List<Integer> list){
        int[] a = {5,1,6,5,6,7,8,8,8,6,7,5};
        int[] b = new int[a.length];
        int k = 0;
        for(int i =0;i<a.length;i++){
            boolean isDuplicate = false;
            for(int j=0;j<k;j++){
                if(a[i] == b[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                b[k] = a[i];
                k++;
            }
        }
        for(int i =0;i<k;i++){
            System.out.println(b[i]);
        }
    }

    private static void getCountOfEachElement(List<Integer> list){
        Map<Integer,Integer> countOccurence = new HashMap<>();
        for(int i =0;i<list.size();i++){
            Integer element = list.get(i);
            countOccurence.put(element, countOccurence.getOrDefault(element, 0)+1);
        }
        for(Map.Entry<Integer,Integer> result : countOccurence.entrySet()){
            System.out.println("Occurence of " + result.getKey() + " is "+ result.getValue());
        }   
    }

    private static void reverseDecimalList(){
         List<Double> decimalNumbers = new ArrayList<>(Arrays.asList(5.67, 3.14, 9.81, 2.71, 6.28));
        decimalNumbers.sort(Collections.reverseOrder());
        System.out.println("Sorted list in reverse order: " + decimalNumbers);

    }

    
}