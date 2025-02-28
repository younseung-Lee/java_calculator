package calculator;

import java.util.List;
import java.util.Scanner;

public class ResultUpdate {
    // 결과 리스트 값을 변환하는 메서드
    public void setResult(List<Double> resultList, Scanner scanner) {
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
}
