package JavaBasics;

// 4) Даны две переменные. Поменяйте значения переменных друг с другом двумя способами
public class Program4 {
    public static void main(String[] args){
        int a = 1;
        int b = 9;

        int c;
        c = a;
        a = b;
        b = c;
        
        /*
        a ^= b;
        b ^= a; //2 способ
        a ^= b;
        */
        System.out.println(a);
        System.out.println(b);
    }
}
