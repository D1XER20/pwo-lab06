package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {

    public TribonacciGenerator() {
        reset();
    }

    @Override
    public void reset() {
        super.reset();
        f_3 = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else {
            current = (lastIndex == 2) ? BigDecimal.ONE : BigDecimal.ZERO;
        }
        lastIndex++;
        return current;
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 2) {
            BigDecimal temp = f_3;
            f_3 = f_2.subtract(f_1);
            f_2 = f_1;
            f_1 = temp;
            return f_3;
        } else {
            return (lastIndex == 2) ? BigDecimal.ONE : BigDecimal.ZERO;
        }
    }
}
