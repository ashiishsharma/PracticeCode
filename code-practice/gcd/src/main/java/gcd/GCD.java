package gcd;

/**
 * GCD of
 * 8 and 24 is 8
 * 300 and 200 is 100
 * 800 and 500 is 100
 * <p>
 * gcd 300, 200
 * p    q
 * 300 % 200 is 100
 * p     q
 * 300 % 100 is 0
 * p     q
 * 100   0
 * q == 0
 */
public class GCD {

    /**
     * @param args
     */
    public static void main(String[] args) {


        int p = 300;
        int q = 200;

        System.out.println(gcd(p, q));
    }

    /*Euclid's algorithm*/
    private static int gcd(int p, int q) {

        if (q == 0) {
            return p;
        }

        return gcd(q, p % q);
    }


}
