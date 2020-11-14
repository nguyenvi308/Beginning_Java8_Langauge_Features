package Chapter12_Collections.entity;

public class ComparablePerson extends Person implements Comparable {

    public ComparablePerson(int id, String name) {
        super(id, name);
    }

    @Override
    public int compareTo(Object o) {
       ComparablePerson comparablePerson = (ComparablePerson) o;
       int comparablePersonId = comparablePerson.getId();
       String comparablePersonName = comparablePerson.getName();
       if (this.getId() < comparablePersonId)
       {
           return -1; 
       }
       if (this.getId() > comparablePersonId)
       {
           return 1;
       }
       if (this.getId() == comparablePersonId)
       {
           return this.getName().compareTo(comparablePersonName);
       }
       // should not reach here
       return 0;
    }
}
