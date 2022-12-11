public class Main {
    public static void main(String[] args) {
        Object obj = new Object();
        new MyThread(obj).start();
        new MyThread(obj).start();
    }
}