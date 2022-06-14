package ru.netology.repository;

import ru.netology.domian.Product;

public class ProductRepository {

    private Product[] items = new Product[0];
    private int id;

    public ProductRepository(int id) {
        this.id = id;
    }

    public ProductRepository() {
    }

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];

        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

    public Product[] findAll() {
        return items;
    }

    public Product[] removeById() {

        if (findById() != null) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;

            return items;
        }

        throw new NotFoundException("Идентификатор " + id + " не найден. Введите валидный идентификатор.");
    }

    public Product[] findById() {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        Product[] find = new Product[index];
        System.arraycopy(tmp, 0, find, 0, find.length);
        if (find.length != 0) {
            return find;
        }
        return null;
    }
}
