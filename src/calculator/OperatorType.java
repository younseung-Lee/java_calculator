package calculator;
// 연산자 타입 enum
// 연산자를 나타내는 enum 클래스
public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');

    // symbol: 각 연산자를 나타내는 문자(+, -, *, /, %)를 저장하는 변수
    private final char symbol;

    //생성자는 각 OperatorType 항목에 심볼을 할당(예: OperatorType.ADD는 심볼 '+')
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // 연산자 심볼을 반환하는 메소드
    public char getSymbol() {
        return symbol;
    }

    // 주어진 문자(symbol)에 해당하는 OperatorType을 반환하는 메소드
    // 연산자가 '+'이면 OperatorType.ADD를 반환하고, 잘못된 연산자이면 예외 발생
    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType type : calculator.OperatorType.values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("알 수 없는 연산자: " + symbol);
    }
}