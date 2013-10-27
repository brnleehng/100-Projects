import java.math.BigInteger;
/**
 * Calculates pi and displays it up to the given integer. This number is
 * not rounded.
 *
 * @author slapvanilla
 */
public class PiToTheNth {

    public static void main(String[] args) {

        if (args.length != 1 || Integer.parseInt(args[0]) < 1) usage();

        calcPitoNthDigits(Integer.parseInt(args[0]));

    }

    /**
     * Calculates and prints pi up to the amount of digits provided.
     *
     * @param digits the number of digits of pi to be calculated.
     */
    private static void calcPitoNthDigits(int digits){
        final BigInteger TWO = BigInteger.valueOf(2);
        final BigInteger THREE = BigInteger.valueOf(3);
        final BigInteger FOUR = BigInteger.valueOf(4);
        final BigInteger SEVEN = BigInteger.valueOf(7);

        BigInteger q = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;
        BigInteger r = BigInteger.ZERO;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger l = BigInteger.valueOf(3);

        BigInteger nn, nr;
        boolean first = true;
        int count = 0;

        while (count < digits) {
            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                System.out.print(n);
                if (first) {
                    System.out.print(".");
                    first = false;
                }
                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;
                System.out.flush();
                count++;
            }
            else {
                nr = TWO.multiply(q).add(r).multiply(l);
                nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(TWO);
                k = k.add(BigInteger.ONE);
                n = nn;
                r = nr;
            }
        }
    }

    /**
     * Prints the proper usage for the program and exits.
     */
    private static void usage() {
        System.out.print("usage: PiToTheNth integer(>0)");
        System.exit(0);
    }
}
