package int103class2;

import containment.*;
import human.*;

public class Recapint103class2 {

    public static void main(String[] args) {
        testContainable();
    }
    
    static void testContainable(){
        //Containable<Person> c = new Container();
        var c = new Container<Person>(); // Have some different
        
        System.out.println("Add P5 " + c.add(new Person(5, "Five")));
        System.out.println("Add P2 " + c.add(new Student(2, "Two", "IT")));
        System.out.println("Add null " + c.add(null));
        System.out.println("Add P7 " + c.add(new Person(7, "Seven")));
        System.out.println("Add P3 " + c.add(new Student(3, "Three", "CS")));
        System.out.println("Got S7 " + c.get(new Person(7, "UNKNOWN")));
        System.out.println("Got S7 " + c.get(new Student(2, "UNKNOWN", "x")));
        System.out.println("Before sorting: " + c.toString());
        c.sort();
        System.out.println("After sorting: " + c.toString());
    }
}
