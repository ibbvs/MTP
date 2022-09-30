/*
Создайте класс, который описывает вектор (в трёхмерном пространстве).
У него должны быть:
    a) конструктор с параметрами в виде списка координат x, y, z
    b) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt()
    c) метод, вычисляющий скалярное произведение
    d) метод, вычисляющий векторное произведение с другим вектором
    e) метод, вычисляющий угол между векторами (или косинус угла): косинус угла между векторами равен скалярному произведению векторов,
       деленному на произведение модулей (длин) векторов
    f) методы для суммы и разности
    g) статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
    h) Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый
 */
import java.util.Random;

class Vector {
    int x;
    int y;
    int z;

    //  a) конструктор с параметрами в виде списка координат x, y, z
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void value() {
        System.out.printf("(%d, %d, %d);\n", x, y, z);
    }

    //  b) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt()
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    //  c) метод, вычисляющий скалярное произведение
    public double ProductScalar(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    //  d) метод, вычисляющий векторное произведение с другим вектором
    public Vector ProductVectors(Vector vector) {
        int X = y * vector.z - z * vector.y;
        int Y = z * vector.x - x * vector.z;
        int Z = x * vector.y - y * vector.x;
        return new Vector(X, Y, Z);
    }

    //  e) метод, вычисляющий угол между векторами (или косинус угла)
    public double CosAngle(Vector vector) {
        double p_scalar = ProductScalar(vector);    //Скалярное произведение
        double l1 = length();                       //Длина текущего вектора
        double l2 = vector.length();                //Длина другого вектора
        return p_scalar / (Math.abs(l1) * Math.abs(l2));
    }

    //  f) методы для суммы и разности
    public Vector sum(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector dif(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    // g) статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
    public static Vector[] generator(int N) {
        Vector vArr[];
        vArr = new Vector[N];
        Random rd = new Random();
        for (int i=0; i < N; i++) {
            int rdx = rd.nextInt(100);
            int rdy = rd.nextInt(100);
            int rdz = rd.nextInt(100);
            vArr[i] = new Vector(rdx, rdy, rdz);
        }
        return vArr;
    }


}



public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector(3, 4, 5);
        Vector v2 = new Vector(7, 8, 9);
        System.out.print("Вектор 1: ");
        v1.value();
        System.out.print("Вектор 2: ");
        v2.value();
        System.out.printf("Длина 1 вектора: %f;\n", v1.length());
        System.out.printf("Длина 2 вектора: %f;\n", v2.length());
        System.out.printf("Скалярное произведение этих векторов: %f;\n", v1.ProductScalar(v2));
        System.out.print("Векторное произведение этих векторов: ");
        v1.ProductVectors(v2).value();
        System.out.printf("Угол между этими векторами: %f;\n", v1.CosAngle(v2));
        System.out.print("Сумма этих векторов вернет новый вектор: ");
        v1.sum(v2).value();
        System.out.print("Разность этих векторов вернет новый вектор: ");
        v1.dif(v2).value();
        System.out.println("\n\nСлучайно созданные массивы:");
        Vector[] vectors = Vector.generator(5);
        for (int i = 0; i < vectors.length; i++) {
            vectors[i].value();
        }
    }
}
