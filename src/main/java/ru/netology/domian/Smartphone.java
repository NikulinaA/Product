package ru.netology.domian;

public class Smartphone extends Product {
    private  String breeder;


    public Smartphone(String breeder) {
        this.breeder = breeder;

    }

    public Smartphone(int id, String name, double price, String breeder) {
        super(id, name, price);
        this.breeder = breeder;
    }

}
