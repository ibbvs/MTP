/*
1. Реализуйте класс матрицы и методы:
   a) Сложение и вычитание матриц.
   b) Умножение матрицы на число.
   c) Произведение двух матриц.
   d) Транспонированная матрица.
   e) Возведение матрицы в степень.
   f) Если метод, возвращает матрицу, то он должен возвращать новый объект,
   а не менять базовый.
 */

import java.util.Random;

class Matrix {
    int n;
    int m;
    double[][] matrix;


    // конструктор 1
    public Matrix(int n, int m) {
        this.matrix = new double[n][m];
        this.n = n;
        this.m = m;
        this.createMatrix();
    }

    // конструктор 2
    public Matrix(double[][] matrix) {
        this(n, m);
        this.matrix = matrix;
    }


    // Инициализация матрицы
    private void createMatrix() {
        Random rd = new Random;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rd.nextInt(100);
            }
        }
    }

    // Вывод значений матрицы
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f  ", matrix[i][j]);
            }
            System.out.print("\n");
        }
    }


    // b) Умножение матрицы на число.
    public Multiplication(double Num) {
        double[][] resultMatrix = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                double result = this.thisMatrix[i][j] * inputNumber;
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }
}


public class Main {
    public static void main(String[] args) {
        Matrix obj1 = new Matrix(3, 5);
        obj1.show();
    }
}