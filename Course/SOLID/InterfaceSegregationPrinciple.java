public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        
    }
}

class Document {   
}

interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// YAGNI - YOU AIN'T GOING TO NEED IT

class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {
    }
}

class PhotoCopier implements Printer, Scanner {

    @Override
    public void print(Document d) {
    }

    @Override
    public void scan(Document d) {
    }
    
}

class MultiFuntionPrinter implements Machine {

    @Override
    public void print(Document d) {
        System.out.println("Printing the document");
    }

    @Override
    public void fax(Document d) {
        System.out.println("Fax document");
    }

    @Override
    public void scan(Document d) {
        System.out.println("Scan the document");
    }
    
}

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {
    }

    @Override
    public void fax(Document d) {
    }

    @Override
    public void scan(Document d) {
    }
    
}