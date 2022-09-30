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
    int[][] matrix;

    // конструктор получающий два числа
    public Matrix(int n, int m) {
        this.matrix = new int[n][m];
        this.n = n;
        this.m = m;
        this.createMatrix();
    }
    // конструктор получающий готовую матрицу
    public Matrix(int[][] initMatrix) {
        this.matrix = initMatrix;
        this.n = initMatrix.length;
        this.m = initMatrix[0].length;
    }


    // Заполнение матрицы
    private void createMatrix() {
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rd.nextInt( 10,50);
            }
        }
    }

    // Вывод значений матрицы
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d  ", matrix[i][j]);
            }
            System.out.println();
        }
    }




    // b) Умножение матрицы на число.
    public Matrix multiplicationNumber(int Num) {
        int[][] resultMatrix = new int[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                int result = this.matrix[i][j] * Num;
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }


    // d) Транспонированная матрица.
    public Matrix transpose(){
        int[][] resultMatrix = new int[this.m][this.n];
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                resultMatrix[j][i] = this.matrix[i][j];
        return new Matrix(resultMatrix);
    }


    // e) Возведение матрицы в степень.
    public Matrix exponentiation(int N) {
        if (this.m != this.n) {
            System.out.println("Матрица не квадратная, возведение в степень невозможно");
            return null;
        }
        Matrix resultMatrix = this;

        for (int i = 1; i < N; i++) {
            Several matrix = new Several(resultMatrix, resultMatrix);
            resultMatrix = matrix.multiplication();
        }
        return resultMatrix;
    }
}

class Several {

    Matrix matrix1;
    Matrix matrix2;

    public Several(Matrix m1, Matrix m2) {
        this.matrix1 = m1;
        this.matrix2 = m2;
    }


    // c) Произведение двух матриц.
    public Matrix multiplication() {

        if (matrix1.m != matrix2.n) {
            System.out.println("Количество столбцов первой матрицы не равно количеству строк второй матрицы");
            return null;
        }
        int[][] resultMatrix = new int[matrix1.n][matrix2.m];

        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix2.m; j++) {
                for (int k = 0; k < matrix1.m; k++) {
                    resultMatrix[i][j] += matrix1.matrix[i][k] * matrix2.matrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
    }


    // a) Сложение и вычитание матриц.
    public Matrix sum() {
        if ((matrix1.n != matrix2.n) || (matrix1.m != matrix2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        }
        int[][] resultMatrix = new int[matrix1.n][matrix2.m];
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                int result = matrix1.matrix[i][j] + matrix2.matrix[i][j];
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }
    public Matrix dif() {
        if ((matrix1.n != matrix2.n) || (matrix1.m != matrix2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        }
        int[][] resultMatrix = new int[matrix1.n][matrix2.m];
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                int result = matrix1.matrix[i][j] - matrix2.matrix[i][j];
                resultMatrix[i][j] = result;
            }
        }
        return new Matrix(resultMatrix);
    }
}



public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(7, 2);
        System.out.println("Матрица 1:");
        m1.show();
        Matrix m2 = new Matrix(7, 2);
        System.out.println("\nМатрица 2:");
        m2.show();

        int N = 3;
        System.out.printf("\nУмножение первой матрицы на число %d:\n", N);
        Matrix result3 = m1.multiplicationNumber(N);
        if (result3 != null)
            result3.show();

        System.out.println("\nСумма этих матриц:");
        Several sumMatricies = new Several(m1, m2);
        Matrix result1 = sumMatricies.sum();
        if (result1 != null)
            result1.show();

        System.out.println("\nРазность этих матриц:");
        Several difMatricies = new Several(m1, m2);
        Matrix result2 = difMatricies.dif();
        if (result2 != null)
            result2.show();

        System.out.println("\n--------------------------------------------\n");
        Matrix m3 = new Matrix(2, 3);
        Matrix m4 = new Matrix(3, 2);

        System.out.println("Матрица 3:");
        m3.show();
        System.out.println("\nМатрица 4:");
        m4.show();

        System.out.println("\nПроизведение этих матриц:");
        Several mltMatricies = new Several(m3, m4);
        Matrix result4 = mltMatricies.multiplication();
        if (result4 != null)
            result4.show();

        System.out.println("\n--------------------------------------------\n");
        Matrix m5 = new Matrix(3, 5);
        System.out.println("Матрица 5:");
        m5.show();
        System.out.println("\nТранспонированная матрица 5:");
        Matrix trnsps_m5 = m5.transpose();
        trnsps_m5.show();

        System.out.println("\n--------------------------------------------\n");
        Matrix m6 = new Matrix(3, 3);
        System.out.println("Матрица 6:");
        m6.show();
        System.out.print("\nВозведение матрицы 6 в степень 2:\n");
        Matrix result5 = m6.exponentiation(N);
        if (result5 != null)
            result5.show();
    }
}