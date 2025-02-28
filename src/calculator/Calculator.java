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
                    } //직접 예외를 발생시켜 프로그램이 잘못된 연산을 수행하지 못하게 함
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
            //예외가 발생하면 오류 메시지를 출력하고, result 값을 NaN(Not a Number, 숫자가 아님) 으로 설정.
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            result = Double.NaN; // NaN 값을 반환하여 오류 상황 표시
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            result = Double.NaN;
        }
        return result;
    }


    // 계산 결과를 저장하는 메서드
    public void addResult(double result) {
        resultList.add(result);
    }
    // 결과 리스트 메서드 (게터)
    // 저장된 모든 계산 결과를 외부에서 확인할 수 있게 해줌.
    public List<Double> getResults() {
        return resultList;
    }
    // 리스트 삭제 메서드
    public void removeResult(Scanner scanner) {
        if (!resultList.isEmpty()) { // 리스트가 비어 있지 않은 경우
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = scanner.next();
            if (remove.equalsIgnoreCase("remove")) {
                resultList.remove(0); // 첫 번째 요소 삭제
                System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
            } else {
                System.out.println("삭제가 취소되었습니다.");
            }
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 결과 리스트 값 변환 (세터)
    public void setResult(Scanner scanner) {
        if (resultList.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return;
        }

        System.out.println("수정할 연산 결과의 인덱스를 입력하세요 (0부터 입력)");
        int index;
        try {
            index = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("올바른 숫자를 입력하세요.");
            scanner.nextLine(); // 입력 버퍼 정리
            return;
        }

        if (index < 0 || index >= resultList.size()) {
            System.out.println("유효하지 않은 인덱스입니다.");
            return;
        }

        System.out.println("새로운 값을 입력하세요: ");
        double newValue;

        try {
            newValue = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("올바른 숫자를 입력하세요.");
            scanner.nextLine(); // 입력 버퍼 정리
            return;
        }

        System.out.println("해당 값을 변경하시겠습니까? (yes 입력 시 변경)");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("yes")) {
            resultList.set(index, newValue);
            System.out.println("인덱스 " + index + "의 값이 " + newValue + "(으)로 변경되었습니다.");
        } else {
            System.out.println("변경이 취소되었습니다.");
        }
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
