package ru.netology.manager;

import ru.netology.domian.Product;
import ru.netology.repository.ProductRepository;


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

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {

        int index = 0;

        Product[] result = new Product[index];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];


                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[index] = product;
                result = tmp;
                index++;

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

    }
}
