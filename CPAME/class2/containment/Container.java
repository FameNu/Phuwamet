package containment;

import human.*;
import java.util.Arrays;

public class Container<T> implements Containable<T> {

    private static final int SIZE = 3;
    private int count;
    // private Person[] box = new Person[SIZE];
    private T[] box = (T[]) new Object[SIZE];
    
    /*
    @Override
    public boolean add(Object o){
        if (o == null || o instanceof Person || count == SIZE) return false;
        box[count++] = (Person) o;
        return true;
    }
    
    @Override
    public Object get(Object o){
        if (o == null || o instanceof Person) return null;
        for (int i = 0; i < count; i++){
            if (box[i].equals(o)) return box[i];
        }
        return null;
    }
    */
    
    
    @Override
    public boolean add(T t) {
        if (t == null || count == SIZE) return false;
        box[count++] = t; // add object o to box by send o to Person before collect in box
        return true;
    }

    @Override
    public T get(T t) {
        if (t == null) return null;
        for (int i = 0; i < count; i++){
            if (box[i].equals(t)) return box[i];
        }
        return null;
    }
    
    @Override
    public void sort(){
        if (count < 2) return;
        Arrays.sort(box, 0, count);
    }
    
    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append("Container{");
        for (int i = 0; i < count; i++){
            sb.append("\n  ");
            sb.append(box[i]);
        }
        sb.append("\n}");
        return sb.toString();
    }
}
