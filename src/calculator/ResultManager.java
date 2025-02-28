package calculator;

import java.util.List;
import java.util.Scanner;

public class ResultManager {
    // 결과 리스트에서 삭제하는 메서드
    public void removeResult(List<Double> resultList, Scanner scanner) {
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
}
