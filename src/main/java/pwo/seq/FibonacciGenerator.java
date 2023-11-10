package pwo.seq;

import java.math.BigDecimal;

public class FibonacciGenerator extends Generator {

    public FibonacciGenerator() {
        reset();
    }

    @Override
    public void reset() {
        super.reset();
        current = BigDecimal.ZERO;
        f_1 = BigDecimal.ONE;
        f_2 = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else {
            current = (lastIndex == 1) ? BigDecimal.ONE : BigDecimal.ZERO;
        }

        lastIndex++;
        return current;
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 1) {
            BigDecimal temp = current;
            current = f_2;
            f_2 = f_1.subtract(f_2);
            f_1 = temp;
            return current;
        } else {
            return (lastIndex == 1) ? BigDecimal.ZERO : BigDecimal.ONE;
        }
    }
}
