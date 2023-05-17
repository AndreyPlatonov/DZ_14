import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldDeleteSuccess() {

        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(3, "Кружка", 100);
        Product product2 = new Product(5, "Ложка", 10);
        Product product3 = new Product(7, "Тарелка", 150);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(3);

        Product[] actual = shop.findAll();
        Product[] expected = {product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteFailedById() {

        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(3, "Кружка", 100);
        Product product2 = new Product(5, "Ложка", 10);
        Product product3 = new Product(7, "Тарелка", 150);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(9);
        });
    }

    @Test
    public void shouldAddSuccess() {

        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(3, "Кружка", 100);
        Product product2 = new Product(5, "Ложка", 10);
        Product product3 = new Product(7, "Тарелка", 150);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFailed() {

        ShopRepository shop = new ShopRepository();

        Product product1 = new Product(3, "Кружка", 100);
        Product product2 = new Product(5, "Ложка", 10);
        Product product3 = new Product(7, "Тарелка", 150);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });
    }

}
