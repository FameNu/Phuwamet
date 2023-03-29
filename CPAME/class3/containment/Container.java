package containment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Container<T> implements Iterable<T>{
    private static final int SIZE = 5;
    private final T[] box = (T[]) new Object[SIZE];
    private int count;
    private int modCount;
    
    public boolean add(T t){
        if (t == null || count == SIZE) return false;
        box[count++] = t;
        modCount++;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator(){ // Iterator is interface
            private int cur;
            // private final int localModcount = modCount;
            // if want to set variable name to same name of container class
            private final int modCount = Container.this.modCount; // It's a to fccus to modCount of container

            @Override
            public boolean hasNext() {
                // if (localModcount != modCount) throw new ConcurrentModificationException();
                if (modCount != Container.this.modCount) throw new ConcurrentModificationException();

                //if (cur == count) return false;
                //return true;
                return cur != count;
            }

            @Override
            public T next() {
                // if (localModcount != modCount) throw new ConcurrentModificationException();
                if (modCount != Container.this.modCount) throw new ConcurrentModificationException();

                if (cur >= count) throw new NoSuchElementException();
                return box[cur++];
            }
        };
    }
    
    /*
    public T delete(T t){
        if (t == null) return null;
        for (int i = 0; i < count; i++){
            if (box[i].equals(t)){
                T x = box[i];
                box[i] = box[--count];
                box[count] = null;
                return x;
            }
        }
        return null;
    }
    */
    
    public T delete(T t){
        int i = locate(t);
        if (i == -1) return null;
        T x = box[i];
        box[i] = box[--count];
        box[count] = null;
        modCount++;
        return x;
    }
    
    public T find(T t){
        int i = locate(t);
        return i == -1 ? null : box[i];
    }
    
    public int locate(T t){
        if (t == null) return -1;
        for (int i = 0; i < count; i++){
            if (box[i].equals(t)) return i;
        }
        return -1;
    }
    
    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append("Container{");
        for (int i = 0; i < count; i++){
            sb.append("\n  ").append(box[i]); // method chaning
        }
        sb.append("\n}");
        return sb.toString();
    }
    /*
    public void sort(){ // this method not return object
        //if (count < 2) return;
        //Arrays.sort(box, 0, count);
        
        if (count >= 2) Arrays.sort(box, 0, count);
    }
    */
    /*
    public Container sort(){
        if (count >= 2) Arrays.sort(box, 0, count);
        return this;
    }
    */
    public Container sort(){
        if (count < 2) return this;
        Arrays.sort(box, 0, count);
        modCount++;
        return this;
    }
    
    public Container sort(Comparator<T> comp){
        if (count >= 2) {
            Arrays.sort(box, 0 ,count, comp);
            modCount++;
        }
        return this;
    }
}
