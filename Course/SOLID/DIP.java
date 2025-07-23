import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.management.relation.Relation;
import org.javatuples.Triplet;

public class DIP {
    public static void main(String[] args) {
        Person p1 = new Person("John");
        Person c1 = new Person("Chris");
        Person c2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(p1, c2);
        relationships.addParentAndChild(p1, c1);

        new Research(relationships);
    }
}

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

class Relationships implements RelationshipBrowser {   // low-level

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name) 
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Research {    // high-level
    
    // high level module should not depend on low level module
    // public Research(Relationships relationships) {
    //     List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
    //             relations.stream()
    //                 .filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
    //                 .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
    // }

    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person child: children) {
            System.out.println("John has: " + child.name);
        }
    }
}