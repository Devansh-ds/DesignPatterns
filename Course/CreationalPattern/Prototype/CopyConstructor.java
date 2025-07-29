package CreationalPattern.Prototype;
public class CopyConstructor {
    public static void main(String[] args) {
        Employee john = new Employee("John", new Address("Delhi", "India", "34"));

        Employee chris = new Employee(john);
        chris.name = "Chris";
        chris.address.country = "China";

        System.out.println(john);
        System.out.println(chris);
    }
}

class Address {
    public String street, city, country;

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public Address(Address other) {
        this(other.street, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", country=" + country + "]";
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other) {
        this(other.name, new Address(other.address));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("name=").append(name);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }

    
}