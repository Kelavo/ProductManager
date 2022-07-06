package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Smartphone item1 = new Smartphone(1, "Смартфон", 50000, "А20", "Samsung");
    Smartphone item2 = new Smartphone(2, "Смартфон", 75000, "Iphone 13", "Apple");
    Smartphone item3 = new Smartphone(3, "Смартфон", 35000, "Mi10", "Xiaomi");
    Book item4 = new Book(4, "Книга. Война и Мир", 800, "Книга", "Л.Н. Толстой");
    Book item5 = new Book(5, "Книга. Белый отряд", 750, "Книга", "Артур Конан Дойл");
    Book item6 = new Book(6, "Книга. Сегун", 900, "Книга", "Джеймс Клавелл");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    @Test
    public void shouldSave() {
        repo.save(item1);
        repo.save(item5);

        Product[] expected = new Product[]{item1, item5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAdd() {
        manager.add(item1);
        manager.add(item5);

        Product[] expected = new Product[]{item1, item5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {

        repo.save(item2);
        repo.save(item3);
        repo.save(item5);
        repo.save(item6);
        repo.removeById(3);

        Product[] expected = new Product[]{item2, item5, item6};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByElement() {

        repo.save(item4);

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Война и Мир");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySeveralElement() {

        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Product[] expected = {item4, item5, item6};
        Product[] actual = manager.searchBy("Книга");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoElements() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item5);
        repo.save(item6);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Толстой");

        assertArrayEquals(expected, actual);
    }
}
