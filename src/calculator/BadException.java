package calculator;
/* 이 클래스는 주로 잘못된 연산자 입력이나 연산 중 오류가 발생했을 때
BadException을 던져 사용자가 알 수 있게 하도록 설계 */

// RuntimeException을 상속받기 때문에 예외를 던질 때 throws 선언을 하지 않아도 됨.
public class BadException extends RuntimeException {
    public BadException(String type) {
        super(type);
    }
}
