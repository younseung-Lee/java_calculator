package calculator;

public class SubtractOperator<T extends Number> implements Operator<T> {

    @Override
    public double operate(T first, T second) {
        return first.doubleValue() - second.doubleValue();
    }
}
