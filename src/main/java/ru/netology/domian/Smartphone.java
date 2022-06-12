package ru.netology.domian;

public class Smartphone extends Product {
    private String breeder;


    public Smartphone(String breeder) {
        this.breeder = breeder;

    }

    public Smartphone(int id, String name, double price, String breeder) {
        super(id, name, price);
        this.breeder = breeder;
    }

    public Smartphone() {

    }

    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (breeder.contains(search)) {
            return true;
        }
        return false;
    }
}
