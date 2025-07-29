package CreationalPattern.Builder;

public class FlacetBuilder {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                          .lives()
                            .in("Delhi")
                            .at("Budh Vihar")
                            .withPostcode("696969")
                            .builder()
                          .works()
                            .at("Google")
                            .asA("SWE")
                            .income(43259434)
                            .builder()
                          .build();
        System.out.println(person);
    }
}

// POJO
class Person {
    public String streetAddress, postcode, city;
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person [streetAddress=" + streetAddress + ", postcode=" + postcode + ", city=" + city
                + ", companyName=" + companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
    }
}

// Base builder
class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person, this);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person, this);
    }

    public Person build() {
        return person;
    }
}

// Address facet
class PersonAddressBuilder {
    private final Person person;
    private final PersonBuilder builder;

    public PersonAddressBuilder(Person person, PersonBuilder builder) {
        this.person = person;
        this.builder = builder;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }

    public PersonBuilder builder() {
        return builder;
    }
}

// Job facet
class PersonJobBuilder {
    private final Person person;
    private final PersonBuilder builder;

    public PersonJobBuilder(Person person, PersonBuilder builder) {
        this.person = person;
        this.builder = builder;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder income(int income) {
        person.annualIncome = income;
        return this;
    }

    public PersonBuilder builder() {
        return builder;
    }
}
