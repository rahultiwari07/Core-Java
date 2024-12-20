package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private int id;
    private String name;
    private double salary;

    Student(int id,String name,double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void setId(int id){ this.id = id;}
    public int getId(){return this.id;}
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setSalary(double salary){this.salary = salary;}
    public double getSalary(){return this.salary;}
    public String toString(){
        //System.out.println("Id : "+this.id+ "Name : " +this.name + "salary : " + this.salary);
        return ("Id : "+this.id+ "Name : " +this.name + "salary : " + this.salary);
    }
}
public class StreamCreation {
    public static void main(String args[]){
        Student[] arrayOfStds = {
            new Student(1, "Jeff Bezos", 100000.0), 
            new Student(2, "Bill Gates", 200000.0), 
            new Student(3, "Mark Zuckerberg", 300000.0),
            new Student(4, "Mark Zuckerberg", 400000.0)
        };
        // Stream.of(arrayOfStds);
        //Stream<Student> stream = Arrays.asList(arrayOfStds).stream();
        Map<String,List<Student>> map = Arrays.asList(arrayOfStds).stream()
                                            .collect(Collectors.groupingBy(Student :: getName));
        // Arrays.asList(arrayOfStds).stream().collect(Collectors
        //                 ,groupingBy(e -> getName());

        map.forEach((key,value)->{
            System.out.println("Key : " + key);
            List<Student> stdvalue = value;
            stdvalue.forEach(e ->{
                System.out.println("Value : "+ e.toString()); 
            });
        });
    }
}