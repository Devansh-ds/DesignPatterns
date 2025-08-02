package Observer;

import java.util.ArrayList;
import java.util.List;

public class ObsAndAble implements Observer<Person> {
    public static void main(String[] args) {
        ObsAndAble demo = new ObsAndAble();
    }

    public ObsAndAble() {
        Person person = new Person();
        person.subscribe(this);

        for (int i = 20; i < 24; i++) {
            person.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.println("Person's " + args.propertyName + " has changed to " + args.newValue);
    }
}

class Person extends Observable<Person> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChange(this, "age", age);
    }
}

class PropertyChangedEventArgs<T> {
    public T source;
    public String propertyName;
    public Object newValue;

    public PropertyChangedEventArgs(Object newValue, String propertyName, T source) {
        this.newValue = newValue;
        this.propertyName = propertyName;
        this.source = source;
    }
}

interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}

class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChange(T source, String propertyName, Object newValue) {
        for (Observer<T> o : observers) {
            o.handle(new PropertyChangedEventArgs(newValue, propertyName, source));
        }
    }
}
