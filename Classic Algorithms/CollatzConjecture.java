import java.math.BigInteger;

/**
 * Finds the number of steps it takes for a number to go to 1 using the
 * Collatz sequence algorithm.
 *
 * @author slapvanilla
 */
public class CollatzConjecture {

    public static void main(String[] args) {

        /* Verify arguments and initialize vars */
        if (args.length == 0 || args.length > 1) usage();
        BigInteger n = new BigInteger(args[0]);
        int count  = 0;

        /* Loop Collatz algorithm until n = 1 */
        while (!n.equals(BigInteger.ONE)) {
            if (n.mod(new BigInteger("2")) == BigInteger.ZERO) {
                n = n.divide(new BigInteger("2"));
            }
            else {
                n = n.multiply(new BigInteger("3"));
                n = n.add(BigInteger.ONE);
            }
            count++;
        }

        /* Print the results */
        System.out.printf("Steps required: %d%n", count);

    }

    /**
     * Prints the proper usage for the program and exits.
     */
    private static void usage() {
        System.out.print("usage: CollatzConjecture integer(>1)%n");
        System.exit(0);
    }
}
