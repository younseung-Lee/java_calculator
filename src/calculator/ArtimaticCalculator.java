package calculator;

import java.util.HashMap;
import java.util.Map;

public class ArtimaticCalculator<T extends Number> extends Calculator<T> {
    // 속성
    // 연산자 타입과 Operator 객체를 매핑하는 Map
    // Map<OperatorType, Operator 객체>
    private final Map<OperatorType, Operator<T>> operators = new HashMap<>();

    // 생성자
    public ArtimaticCalculator() {
        operators.put(OperatorType.ADD, new AddOperator<>());
        operators.put(OperatorType.SUBTRACT, new SubtractOperator<>());
        operators.put(OperatorType.MULTIPLY, new MultiplyOperator<>());
        operators.put(OperatorType.DIVIDE, new DivideOperator<>());
        operators.put(OperatorType.MOD, new ModOperator<>());
    }

    @Override
    public double calculate(T first, T second, char operatorSymbol) throws BadException {
        OperatorType operatorType;
        try {
            operatorType = OperatorType.fromSymbol(operatorSymbol);
        } catch (IllegalArgumentException e) {
            throw new BadException(e.getMessage());
        }

        Operator<T> operator = operators.get(operatorType);
        if (operator == null) {
            throw new BadException("알 수 없는 연산자: " + operatorSymbol);
        }
        double result = operator.operate(first, second);
        list.add(result);
        return result;
    }
}