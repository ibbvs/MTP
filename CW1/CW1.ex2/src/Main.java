public class Main {
    public static void main(String[] args) {

        Tesla tesla = new Tesla("red", 220, 120, "auto", 5000000, 2020);
        Lada lada = new Lada("white", 120, 60, "mechanic", 1500000,"Granta");
        Car noName = new Car("brown", "mechanic", 90, 40, 50000);

        System.out.println(noName.toString());

        Garage garage = new Garage(5);

        garage.addCar(tesla);
        garage.addCar(lada);
        garage.addCar(noName);
        garage.addCar(new Tesla("green", 225, 140, "auto", 55000000, 2021));
        garage.addCar(new Lada("brown", 140, 140, "mechanic", 550000, "Niva"));
        garage.addCar(new Tesla("yellow", 225, 140, "auto", 55000000, 2021));
        garage.getCars("количество");
        garage.getCars("цена");
    }
}