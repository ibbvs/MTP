package com.company;

public class Lada extends Car{
    private final String model;
    public Lada(String color, int maxSpeed, int currentSpeed, String box, int price,String model) {
        super(color, box, maxSpeed, currentSpeed, price);
        this.model = model;
    }
    @Override
    public  String getName(){
        return "Lada";
    }
    public String getModel(){
        return this.model;
    }
}
