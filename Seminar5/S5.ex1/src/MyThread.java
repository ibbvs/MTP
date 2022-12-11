public class MyThread extends Thread {
    private Object obj;
    public MyThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                try {
                    System.out.println(getName());
                    obj.notify();
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}