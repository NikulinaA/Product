package ru.netology.domian;

public class Book extends Product {
    private String author;


    public Book(int id, String name, double price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public boolean matches(String text) {
        if (super.matches(text)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (author.contains(text)) {
            return true;
        }
        return false;
    }

}