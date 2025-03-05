package calculator;

// Operator 인터페이스는 숫자 타입을 제네릭으로 받음
public interface Operator<T extends Number> {
    double operate(T first, T second);
    // operate():두 숫자(first, second)를 받아 계산을 수행
}