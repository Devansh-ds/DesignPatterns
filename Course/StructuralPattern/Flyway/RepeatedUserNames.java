
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class RepeatedUserNames {
    public static void main(String[] args) {
     User first = new User("John Smith");
     User second = new User("Jane Smith");

    }
}

class User {
    static List<String> strings = new ArrayList<>();
    private int[] names;

    public User(String fullname) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int index = strings.indexOf(s);
            if (index != -1) return index;
            else {
                strings.add(s);
                return strings.size() - 1;
            }
        };

        names = Arrays.stream(fullname.split(" "))
                      .mapToInt(s -> getOrAdd.apply(s))
                      .toArray();
    }
}