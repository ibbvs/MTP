### 1. Реализуйте класс матрицы и методы:

    a) Сложение и вычитание матриц.
    b) Умножение матрицы на число.
    c) Произведение двух матриц.
    d) Транспонированная матрица.
    e) Возведение матрицы в степень.
    f) Если метод, возвращает матрицу, то он должен возвращать новый объект, 
       а не менять базовый.






### 2. Создайте класс, который описывает вектор (в трёхмерном пространстве). У него должны быть:

    a) конструктор с параметрами в виде списка координат x, y, z
    b) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt()
    c) метод, вычисляющий скалярное произведение
    d) метод, вычисляющий векторное произведение с другим вектором
    e) метод, вычисляющий угол между векторами (или косинус угла): 
       косинус угла между векторами равен скалярному произведению векторов, деленному на произведение модулей (длин) векторов
    f) методы для суммы и разности
    g) статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
    h) если метод возвращает вектор, то он должен возвращать новый объект, 
       а не менять базовый






### 3. Реализовать иерархию классов, описывающие трехмерные фигуры:

    Класс Box является контейнером, он можем содержать в себе другие фигуры. 
        Метод add() принимает на вход Shape. 
        Нужно добавлять новые фигуры до тех пор, пока для них хватает места в Box
        (будем считать только объём, игнорируя форму. Допустим, мы переливаем жидкость). 
        Если места для добавления новой фигуры не хватает, то метод должен вернуть false.
<img src="https://www.pvsm.ru/images/2019/05/08/prakticheskie-zadachi-po-Java-dlya-kursov-i-prochih-zanyatii-9.png" />


### 4. Реализуйте ту же иерархию классов, но сделав некоторые классы абстрактными


### 5. Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.

        Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
### Пример:
        Дан массив [1, 2, 3], и массив весов [1, 2, 10].
        В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».



