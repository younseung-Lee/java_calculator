package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    // 속성
    private double first;
    private double second;
    private char operator;
    private double result;
    private static final List<Double> resultList = new ArrayList<>(); // static으로 변경

    // 생성자
    public Calculator(double first, double second, char operator) {
        this.first = first;
        this.second = second;
        this.operator = operator;
    }

    public Calculator() {}

    // 게터 메서드
    public double getResult() {
        return result;
    }


    // 계산 수행 메서드 (예외 처리 추가)
    public double calculate() {
        try {
            switch (operator) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    if (second == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    result = first / second;
                    break;
                case '%':
                    if (second == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    result = first % second;
                    break;
                default:
                    throw new IllegalStateException("올바른 연산자가 아닙니다.");
            }
            addResult(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            result = Double.NaN; // NaN 값을 반환하여 오류 상황 표시
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            result = Double.NaN;
        }
        return result;
    }

    // 결과 저장
    public void addResult(double result) {
        resultList.add(result);
    }
    // 결과 리스트 메서드(게터)
    public List<Double> getResults() {
        return resultList;
    }

    // 종료 기능
    public void exitCalculator(Scanner scanner) {
        System.out.println("종료하려면 'exit' 입력, 계속하려면 아무 키나 입력: ");
        String exit = scanner.next();
        if (exit.equalsIgnoreCase("exit")) {
            System.out.println("계산기를 종료합니다.");
            System.exit(0);
        }
    }
}
