package int103;

public class Person {
    
    public int pub; 
    // If class have same package with this class, 
    // will can put this variable to that cless file
    
    protected int pro; 
    // Can put to other package 
    // if that class use 'extends' to this class file
    
    int data; 
    // Package-Private (default)
    // Can use only on this class
    
    private int id; 
    // Can't put to other package
    
    public int med(){
        data = 0;
        id = 0;
        return data + id;
    }
    
    
    public void accessTest(Person p) {
        this.id = p.id;
    }
}
