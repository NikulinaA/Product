package ru.netology.manager;

import ru.netology.domian.Book;
import ru.netology.domian.Product;
import ru.netology.domian.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;
    private Product product;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager(ProductRepository repository, Product product) {
        this.repository = repository;
        this.product = product;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] findAll() {
        Product[] items = repository.findAll();
        return items;
    }

    public Product[] removeById() {
        Product[] items = repository.removeById();

        return items;
    }


    public Product[] searchBy(String text) {


        int index = 0;

        Product[] result = new Product[index]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];

                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[index] = product;
                result = tmp;
                index++;


                // "добавляем в конец" массива result продукт product
            }
            /*else if((product.matches(text))) { // вызов метода matches в версии описанной в Product
                int length = result.length + 1;
                Product[] tmp = new Product[length];

                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[index] = product;
                result = tmp;
                index++;
            }*/


    }

        return result;
    }}
