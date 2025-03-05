package calculator;

import java.util.ArrayList;
import java.util.List;

// 추상 클래스
public abstract class Calculator<T extends Number> {
    protected List<Double> list = new ArrayList<>();

//   계산을 수행하는 추상 메소드
//   구체적인 계산 로직은 ArtimaticCalculator에서 구현
    public abstract double calculate(T first, T second, char operatorSymbol) throws BadException;

//    연산 결과를 저장하는 list를 반환하는 메소드
    public List<Double> getResults() {
        return list;
    }
}