package ru.netology.manager;

import ru.netology.domian.Product;
import ru.netology.repository.ProductRepository;

import static java.lang.Character.getName;

public class ProductManager {
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
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

        return items;}



    public Product[] searchBy(String text) {

        int index = 0;

        Product[] result = new Product[index]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];




                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[index] = product;
                result = tmp;
                index++;


                // "добавляем в конец" массива result продукт product
            }
            }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {

            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
