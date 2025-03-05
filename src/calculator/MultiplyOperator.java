package calculator;

public class MultiplyOperator<T extends Number> implements Operator<T> {
    @Override
    public double operate(T first, T second) {
        return first.doubleValue() * second.doubleValue();
    }
}
