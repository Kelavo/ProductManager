package ru.netology.domain;

public class Smartphone extends Product {

    private String model;
    private String vendor;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String model, String vendor) {
        super(id, name, price);
        this.model = model;
        this.vendor = vendor;
    }
}
