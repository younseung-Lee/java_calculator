package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultManager resultManager = new ResultManager();
        ResultUpdate resultUpdate = new ResultUpdate();
        ExitProgram exitProgram = new ExitProgram();


        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double first = scanner.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요 (+, -, /, *, %): ");
                char operator = scanner.next().charAt(0);
                System.out.print("두 번째 숫자를 입력하세요: ");
                double second = scanner.nextDouble();

                // 객체 생성 및 계산 수행
                Calculator calculator = new Calculator(first, second, operator);
                double result = calculator.calculate();

                // 결과 출력
                if (!Double.isNaN(result)) { // 오류 발생 시 출력 안 함
                    System.out.println(first + " " + operator + " " + second + " = " + result);
                }

                // 저장된 연산 결과 출력
                System.out.println("저장 리스트 목록: " + calculator.getResults());
                // 결과값 리스트 삭제
                resultManager.removeResult(calculator.getResults(), scanner);
                // 결과값 리스트 값 변환
                resultUpdate.setResult(calculator.getResults(), scanner);
                // 저장된 연산 결과 출력
                System.out.println("저장 리스트 목록: " + calculator.getResults());

                // 종료 기능 추가
                exitProgram.exitCalculator(scanner);

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                scanner.nextLine(); // 잘못된 입력을 제거
            }


        }
    }
}
