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
    private List<Double> resultList;

    // 생성자
    public Calculator(double first, double second, char operator) {
        this.first = first;
        this.second = second;
        this.operator = operator;
        this.resultList = new ArrayList<>();
    }

    public Calculator() {} //result 초기화 안됨

    // 게터 메서드
    public double getResult() {
        return result;
    }
    // 세터 메서드
    public void setResult(double result) {
        this.result = result;
    }
    // list 메서드
    public List<Double> getResults() {
        return resultList;
    }





    // 기능(계산 수행 메서드)
    public void calculate() {
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
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                result = first / second;
                break;
            case '%':
                if (second == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                result = first % second;
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요.");
                return;
        }
        addResult(result);
    }

    public void addResult(double result) {
        resultList.add(result);
    }

    public void removeFirstResult(){
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("result 삭제");
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 종료 기능 메서드
    public void exitCalculator(Scanner scanner) {
        System.out.println("종료하려면 'exit' 입력, 계속하려면 아무 키나 입력: ");
        String exit = scanner.next();
        // "equalsIgnoreCase()": 대소문자 구분 없이 비교
        if (exit.equalsIgnoreCase("exit")) {
            System.out.println("계산기를 종료합니다.");
            System.exit(0); //프로그램 종료
        }
    }
}