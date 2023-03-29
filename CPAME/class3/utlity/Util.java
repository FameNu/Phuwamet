package utlity;

public class Util {
    
    private Util(){} // Protect to create new object
    
    public static final boolean isValid(String str){
        return str != null && !str.isBlank();
    }
}
