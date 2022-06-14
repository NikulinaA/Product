package ru.netology.manager;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domian.Book;
import ru.netology.domian.Product;
import ru.netology.domian.Smartphone;
import ru.netology.repository.AlreadyExistsException;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;


public class ProductManagerTest {

    Product first = new Book(1, "Ромео и Джульета", 500, "Шекспир");
    Product second = new Smartphone(2, "IPhone 13 PRO", 92502, "Apple");
    Product third = new Smartphone(3, "Galaxy S22+", 89000.20, "Samsung");
    Product fourth = new Book(4, "Фауст", 300.20, "Гёте");
    Product fifth = new Book(5, "Герой нашего времени", 658.25, "Лермонтов");
    Product sixth = new Book(5, "Герой нашего времени", 658.25, "Лермонтов");

    @Test

    public void AddProduct() {
        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);


        Product[] actual = add.findAll();
        Product[] expected = {first, second, third, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void AddTwoProduct() {
        ProductManager add = new ProductManager(new ProductRepository());


        add.add(fifth);

        assertThrows(AlreadyExistsException.class, () -> {
            add.add(sixth);
        });

    }

    @Test

    public void AddNoProduct() {
        ProductManager add = new ProductManager(new ProductRepository());


        Product[] actual = add.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void RemoveNoId() {
        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);

        assertThrows(NotFoundException.class, () -> {add.removeById(547);});
    }

    @Test

    public void RemoveId() {
        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);

        add.removeById(2);
        Product[] actual = add.findAll();
        Product[] expected = {first, third, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchByProduct() {

        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);


        Product[] actual = add.searchBy("Gala");
        Product[] expected = {third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchByNoProduct() {

        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);


        Product[] actual = add.searchBy("ухо");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchByNumberProduct() {

        ProductManager add = new ProductManager(new ProductRepository());

        add.add(first);
        add.add(second);
        add.add(third);
        add.add(fourth);
        add.add(fifth);


        Product[] actual = add.searchBy("ме");
        Product[] expected = {first, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }
}
