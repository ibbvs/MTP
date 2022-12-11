public class Main {
    public static double f(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double solve(double y1, double y2){
        if(y2 - y1 <= 0.001){
            return y1;
        }

        double x = y1 + (y2 - y1) / 2;

        if (f(y1) * f(x) > 0)
            return solve(x, y2);
        else
            return solve(y1, x);
    }

    public static void main(String[] args) {
        System.out.println(solve(0, 10));
    }
}