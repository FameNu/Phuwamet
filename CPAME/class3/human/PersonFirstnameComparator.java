package human;

import java.util.Comparator;

public class PersonFirstnameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.firstname.compareTo(o2.firstname);
    }
    
}
