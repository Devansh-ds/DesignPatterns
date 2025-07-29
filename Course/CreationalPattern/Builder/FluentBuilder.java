package CreationalPattern.Builder;

public class FluentBuilder {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person person = pb.withname("John")
                          .worksAt("Developer")
                          .build();
        System.out.println(person.toString());
    }
}

class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name=").append(name);
        sb.append(", position=").append(position);
        sb.append('}');
        return sb.toString();
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withname(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return this;
    }

    @Override
    public EmployeeBuilder self() {
        return this;
    }

}