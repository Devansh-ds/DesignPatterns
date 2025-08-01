package Observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EasyMethod {
    public static void main(String[] args) {
        Person person = new Person();
        Event<PropertyChangedEventArgs<Integer>>.Subscription sub = person.propertyChanged.addHandler(x -> {
                    System.out.println("Person's " + x.propertyName + " has changed to " + x.newValue);
                });
    }
}

class Event<TArgs> {
    private int count = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler : handlers.values()) {
            handler.accept(args);
        }
    }

    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() throws Exception {
            event.handlers.remove(id);
        }
    }
}


class PropertyChangedEventArgs<T> {
    public Object source;
    public String propertyName;
    public T newValue;

    public PropertyChangedEventArgs(Object source, String propertyName, T newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

class Person {
    public Event<PropertyChangedEventArgs<Integer>> propertyChanged = new Event<>();

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChanged.fire(new PropertyChangedEventArgs<>(this, "age", this.age));
    }
}