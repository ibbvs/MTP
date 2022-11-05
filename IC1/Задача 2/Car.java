package com.company;
import java.util.Scanner;



public class Car implements Comparable<Car> {
    private final String color, type_box;
    private final int maxSpeed;
    private int currentSpeed;
    public int price;

    public Car(String color, String type_box, int maxSpeed, int currentSpeed, int price) {
        this.color = color;
        this.type_box = type_box;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.price = price;
    }

    public int getPrice(){ return price;}

    public void start() {
        System.out.printf("Начальная скорость равна %d, сколько добавляем к текущей скорости: \n", currentSpeed);
        Scanner scan = new Scanner(System.in);
        int speed = scan.nextInt();
        accelerate(speed);
    }

    public void stop() {
        currentSpeed = 0;
        System.out.printf("Машина остановилась, текущая скорость равна = %s.\n", currentSpeed);
    }

    private void accelerate(int speed) {

        if (speed + currentSpeed <= maxSpeed) {
            currentSpeed = speed + currentSpeed;
            System.out.printf("Текущая увеличилась на %s, текущая скорость равна %d.\n", speed, currentSpeed);
        } else {
            System.out.printf("Машина достигла своей максимальной скорости, которая равна %s, увеличение скорости невозможно.\n", maxSpeed);
        }
    }

    @Override
    public int compareTo(Car o) {
        return price - o.price;
    }


    public  String getName(){
        return "Car";
    }

    public String toString() {
        return "\n\nНазвание машины = " + getName() + '\n' +
                "Цвет = " + color + '\n' +
                "Коробка передач = " + type_box + '\n' +
                "Максимальная скорость = " + maxSpeed + '\n' +
                "Текущая скорость = " + currentSpeed + '\n' +
                "Цена = " + price;
    }
}