//Реализовать иерархию классов, описывающие трехмерные фигуры:
class Shape {
    private double volume;

    //геттер
    public double getVolume() {
        return this.volume;
    }
    //сеттер
    public void setVolume(double volume) {
        this.volume = volume;
    }
}

class Pyramid extends Shape {
    private double s;
    private double h;
}


class Box extends Shape {
    //Добавление фигуры в контейнер
    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return false;
        }else{
            //Оставшееся свободное место
            double freeVolume = this.getVolume() - shape.getVolume();
            this.setVolume(freeVolume);
            return true;
        }
    }
}

class SolidOfRevolution extends Shape {
    private double radius;
    public double getRadius() {
        return radius;
    }

}

class Cylinder extends SolidOfRevolution {
    private double height;
}

class Ball extends SolidOfRevolution {}



public class Main {

    public static void main(String[] args) {
        // коробка
        Box box = new Box();
        // объем коробки
        box.setVolume(60.3);

        //шар с объемом 17.2
        Ball ball1 = new Ball();
        ball1.setVolume(17.2);


        //Добавляем шар в коробку
        System.out.printf("Объём коробки: %.3f\n", box.getVolume());
        System.out.printf("Объём шара: %.3f\n", ball1.getVolume());
        boolean result = box.add(ball1);
        System.out.printf("Объём коробки после попытки поместить шар в коробку: %.3f\n", box.getVolume());

        SolidOfRevolution sor = new SolidOfRevolution();
        sor.setVolume(100);
        System.out.printf("\nОбъём некоего тела: %.3f\n", sor.getVolume());
        result = box.add(sor);
        System.out.printf("Объём коробки после попытки поместить это тело в коробку: %.3f\n", box.getVolume());

        Pyramid pyramid = new Pyramid();
        pyramid.setVolume(19.137);
        System.out.printf("\nОбъём пирамиды: %.3f\n", pyramid.getVolume());
        result = box.add(pyramid);
        System.out.printf("Объём коробки после попытки поместить пирамиду в коробку: %.3f\n", box.getVolume());
    }
}