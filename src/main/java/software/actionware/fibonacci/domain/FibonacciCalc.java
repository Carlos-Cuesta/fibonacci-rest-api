package software.actionware.fibonacci.domain;

import java.math.BigInteger;

/**
 *
 * Fecha: 06/10/2020.
 * Autores: Carlos Cuesta
 */
public class FibonacciCalc {

    /**
     * Returns a Fibonacci number of the specified position.
     *
     * @param position the position of the Fibonacci sequence to calculate
     * @return the Fibonacci number as BigInteger
     * @throws IllegalArgumentException if the position param is negative
     */
    public static BigInteger getFibonacciNumber(Integer position) throws IllegalArgumentException {
        if (position == null){
            throw new IllegalArgumentException("Position can't be null");
        }
        if (position < 0) {
            throw new IllegalArgumentException(String.format("Position was less than 0. [%d]", position));
        }

        if(position == 0 || position == 1) {
            return BigInteger.valueOf(position);
        }
        BigInteger n0 = BigInteger.ZERO;
        BigInteger n1 = BigInteger.ONE;
        BigInteger tempPositionValue;
        for (int i = 2; i <= position; i++) {
            tempPositionValue = n0.add(n1);
            n0 = n1;
            n1 = tempPositionValue;
        }
        return n1;
    }
}
