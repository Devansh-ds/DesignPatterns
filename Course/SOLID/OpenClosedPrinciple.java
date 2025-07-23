
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product p1 = new Product("Apple", Color.RED, Size.SMALL);
        Product p2 = new Product("Tree", Color.GREEN, Size.MEDIUM);
        Product p3 = new Product("House", Color.BLUE, Size.LARGE);
        List<Product> products = Arrays.asList(p1, p2, p3);

        ProductFilter pf = new ProductFilter();
        System.out.println("All products: ");
        pf.filterByColor(products, Color.RED)
          .forEach(item -> System.out.println(item));

        BetterFilter bf = new BetterFilter();
        System.out.println("Better products: ");
        bf.filter(products, new ColorSpecification(Color.BLUE))
            .forEach(item -> System.out.println(item));

    }
}

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

interface Specification<T> {
    boolean isStaisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isStaisfied(Product item) {
        return item.color == color;
    }
}


class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.color = color;
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " - " + color + " - " + size;
    }
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> products, Specification<Product> spec) {
        return products.stream().filter(p -> spec.isStaisfied(p));
    }
}

class ProductFilter {

    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return  products.stream().filter(item -> item.color == color);
    }

        public Stream<Product> filterBySize(List<Product> products, Size size) {
        return  products.stream().filter(item -> item.size == size);
    }
}