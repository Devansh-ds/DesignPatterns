
import java.util.Arrays;

public class Prototype {
    public static void main(String[] args) throws Exception {
        Person john = new Person(new String[]{"John", "Cena"}, 
                               new Address("Rajasthan", 34)
                               );
        Person aman = (Person) john.clone();
        aman.names[0] = "Aman";
        aman.address.houseNumber = 69;
        
        System.out.println(john);
        System.out.println(aman);
    }
}

class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append("streetName=").append(streetName);
        sb.append(", houseNumber=").append(houseNumber);
        sb.append('}');
        return sb.toString();
    }

    // deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("names=").append(Arrays.toString(names));
        sb.append(", address=").append(address.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address) address.clone());
    }

}