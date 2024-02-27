package ch.hslu.exercises.D1;


public class Fibonacci {

    private long[] memo;

    public static int fiboRec1(int n) {
        if (n <= 1) { // Basisfall
            return n;
        } else { // Rekursionsfall
            return fiboRec1(n - 1) + fiboRec1(n - 2);
        }
    }

    public int fiboRec2(int n) {
        if (memo == null) {
            memo = new long[n + 1];
        }
        if (memo[n] != 0) {
            return (int) memo[n];
        }

        if (n <= 1) {
            return n;
        } else {
            memo[n] = fiboRec2(n - 1) + fiboRec2(n - 2);
            return (int) memo[n];
        }
    }

    public void clearMemo() {
        memo = null;
    }

    public int fiboIter(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
