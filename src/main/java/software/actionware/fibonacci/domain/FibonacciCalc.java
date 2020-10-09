package software.actionware.fibonacci.domain;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import static software.actionware.fibonacci.Constants.MSG_ERROR_PARAMETER_NEG;


/**
 *
 * Fecha: 06/10/2020.
 * Autores: Carlos Cuesta
 */
public class FibonacciCalc implements Callable<BigInteger> {
    private int position;

    public FibonacciCalc(int position) {
        this.position = position;
    }

    /**
     * Returns a Fibonacci number of the specified position.
     *
     * @return the Fibonacci number as BigInteger
     */
    @Override
    public BigInteger call() {
        if (position == 0 || position == 1) {
            return BigInteger.valueOf(position);
        }
        BigInteger n0 = BigInteger.ZERO;
        BigInteger n1 = BigInteger.ONE;
        BigInteger tempPositionValue;
        for (int i = 2; i <= position; i++) {
            tempPositionValue = n0.add(n1);
            n0 = n1;
            n1 = tempPositionValue;
            if (Thread.interrupted()){
                break;
            }
        }
        return n1;
    }

}
