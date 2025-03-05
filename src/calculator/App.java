package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 객체 생성
        Scanner scanner = new Scanner(System.in);
        ResultManager resultManager = new ResultManager();
        ResultUpdate resultUpdate = new ResultUpdate();
        ExitProgram exitProgram = new ExitProgram();
        ArtimaticCalculator<Number> calc1 = new ArtimaticCalculator<>(); //사칙 연산을 처리하는 계산기 객체

        while (true) {
            try {
                double first;   // 첫 번째 숫자
                double second;   // 두 번째 숫자
                char operator;  // 사칙 연산 기호

                System.out.print("첫 번째 숫자를 입력하세요: ");
                first = scanner.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요 (+, -, /, *, %): ");
                operator = scanner.next().charAt(0);
                System.out.print("두 번째 숫자를 입력하세요: ");
                second = scanner.nextDouble();

                // ArtimaticCalculator 클래스의 calculate() 메소드를 호출
                double result = calc1.calculate(first, second, operator);

                // 결과 출력
                if (!Double.isNaN(result)) { // 오류 발생 시 출력 안 함
                    System.out.println(first + " " + operator + " " + second + " = " + result);
                }

                // 저장된 연산 결과 출력
                System.out.println("저장 리스트 목록: " + calc1.getResults());
                // 결과값 리스트 삭제
                resultManager.removeResult(calc1.getResults(), scanner);
                // 결과값 리스트 값 변환
                resultUpdate.setResult(calc1.getResults(), scanner);
                // 저장된 연산 결과 출력
                System.out.println("저장 리스트 목록: " + calc1.getResults());


                //BadException 예외가 발생하면 해당 예외의 메시지를 출력하고,
                // 일반적인 예외가 발생하면 잘못된 입력이라는 메시지를 출력
            } catch (BadException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                scanner.nextLine(); // 잘못된 입력을 제거
            }

            // 종료 여부 확인
            // ExitProgram 클래스의 exitCalculator() 메소드를 호출
            exitProgram.exitCalculator(scanner);
        }


    }
}