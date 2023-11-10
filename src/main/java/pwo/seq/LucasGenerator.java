package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {

    public LucasGenerator() {
        super();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 1) {
            BigDecimal temp = current;
            current = f_1.subtract(f_2);
            f_2 = f_1;
            f_1 = temp;
            return current;
        } else {
            return (lastIndex == 1) ? BigDecimal.ONE : BigDecimal.ZERO;
        }
    }
}
