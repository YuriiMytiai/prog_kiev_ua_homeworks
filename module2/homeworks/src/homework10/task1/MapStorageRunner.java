package homework10.task1;

import java.util.Optional;

public class MapStorageRunner {
    public static void main(String[] args) {
        Storage<Product, Long> productStorage = new MapStorage<>();

        productStorage.save(new Product(11, "MacBook", "Apple's notebook", 2000));
        productStorage.save(new Product(15, "Lenovo", "Lenovo's notebook", 1500));

        Optional<Product> product = productStorage.findById(11L);
        // Product{id=11, name='MacBook', description='Apple's notebook', price=2000}
        product.ifPresent(System.out::println);
    }

}
