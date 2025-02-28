package calculator;

import java.util.Scanner;

public class ExitProgram {
    // 종료 기능 메서드
    public void exitCalculator(Scanner scanner) {
        System.out.println("종료하려면 'exit' 입력, 계속하려면 아무 키나 입력: ");
        String exit = scanner.next();
        if (exit.equalsIgnoreCase("exit")) {
            System.out.println("계산기를 종료합니다.");
            System.exit(0);
        }
    }
}
