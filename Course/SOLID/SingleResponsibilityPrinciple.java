
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;



public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Journal journal = new Journal();
        journal.addEntry("First entry");
        journal.addEntry("I eat");
        System.out.println(journal);
    }
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + " : " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

class Persistence {

    public void saveToFile(Journal journal, String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(toString());
            }
        }
    }

    public void load(Journal journal) {
        System.out.println("reading/loading the journal");
    }
}