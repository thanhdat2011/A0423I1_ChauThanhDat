package _02_loop_in_java.exercise;

public class e3_100_prime_number {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int val) {
        for (int i=2; i < val; i ++) {
            if (val % i ==0) {
                return false;
            }
        }
        return true;
    }

}
