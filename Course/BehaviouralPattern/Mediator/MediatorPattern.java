
import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Person john = new Person("John");
        Person jane = new Person("Jane");

        room.join(john);
        room.join(jane);

        john.say("Hi room");
        jane.say("Oh, hey john");

        Person simon = new Person("Simon");
        room.join(simon);
        simon.say("hi everyone");

        jane.privateMessage("Simon", "John is bad person Simon");
    }
}

class Person {
    public String name;
    public ChatRoom room;
    private List<String> chatLogs = new ArrayList<>();

    public Person(String name, ChatRoom room) {
        this.name = name;
        this.room = room;
    }

    public Person(String name) {
        this.name = name;
    }

    public void recieve(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("[" + name + "'s chat session] " + s);
        chatLogs.add(s);
    }

    public void say(String message) {
        room.broadcast(name, message);
    }

    public void privateMessage(String who, String message) {
        room.message(name, who, message);
    }

}

class ChatRoom {
    private List<Person> people = new ArrayList<>();

    public void join(Person person) {
        String joinMessage = person.name + " joins the room";
        broadcast("room", joinMessage);

        person.room = this;
        people.add(person);
    }

    public void broadcast(String source, String message) {
        for (Person person : people) {
            if (!person.name.equals(source)) person.recieve(source, message);
        }
    }

    public void message(String source, String destination, String message) {
        people.stream()
            .filter(p -> p.name.equals(destination))
            .findFirst()
            .ifPresent(p -> p.recieve(source, message));
    }
}