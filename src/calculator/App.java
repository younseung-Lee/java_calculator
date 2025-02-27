package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //"exit"을 입력하기 전까지 계속해서 계산을 수행할 수 있도록 무한 루프를 사용
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double first = scanner.nextDouble(); // 첫 번째 숫자를 입력받아 first 변수에 저장
            System.out.print("사칙연산 기호를 입력하세요 (+, -, /, *, %): ");
            char operator = scanner.next().charAt(0); // char로 입력받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            double second = scanner.nextDouble(); // 두 번째 숫자를 입력받아 second 변수에 저장

            // Calculator 객체 생성
            // calculate() 메서드를 호출하여 연산 수행
            Calculator calculator = new Calculator(first, second, operator);
            calculator.calculate(); // 연산 결과를 double 타입으로 반환
            System.out.println(first + " " + operator + " " + second + " = " + calculator.getResult());

            calculator.removeFirstResult();

            // 종료 기능 추가
            calculator.exitCalculator(scanner);

        }
    }
}