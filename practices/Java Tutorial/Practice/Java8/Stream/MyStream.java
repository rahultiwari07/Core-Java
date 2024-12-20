package Java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MyStream {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,2,4,3,5,6,5,4));
        //findOddAndEvenList(list);
        //removeDuplicate(list); 
        getFrequenceyOfEachElements(list);           
    }

    private static void findOddAndEvenList(List<Integer> list){
        List<Integer> evenList = list.stream().filter(e -> e%2 == 0).collect(Collectors.toList());
        List<Integer> oddList = list.stream().filter(e -> e%2 != 0).collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println(oddList);
    }

    private static void removeDuplicate(List<Integer> list){
        List<Integer> uniqueList1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Remove duplicate using distinct method : " + uniqueList1);
        Set<Integer> set = new HashSet<>();
        List<Integer> uniqueList2 = list.stream().filter(set :: add).collect(Collectors.toList());
        System.out.println("Remove duplicate using set with stream Api : " + uniqueList2);
        List<Integer> uniqie3 = list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        System.out.println(uniqie3);
        // List<Integer> usingTreeMap = list.stream().collect(Collectors.toCollection(TreeMap :: new))
        //                                 .stream().collect(Collectors.toList()); 
    }
    private static void getFrequenceyOfEachElements(List<Integer> list){
        //group by element and get list of same element or group element 
         Map<Object, List<Integer>> map = list.stream().collect(Collectors.groupingBy(e -> e ));
        for(Map.Entry<Object,List<Integer>> result : map.entrySet()){
            Integer key = (Integer) result.getKey();
            //System.out.println("Key : " + key);
            List<Integer> value = result.getValue(); 
           // System.out.println("Value : " + value);
        }
        Map<Integer,Long> countOccurence = list.stream().collect(Collectors.groupingBy(e -> e,Collectors.counting()));
        countOccurence.forEach((key,value)->{
            System.out.println("Key : " + key + "value : " + value);
        });

        String s = new String("Rahulllfjhsgf");
        // s.chars().mapto
    }
}