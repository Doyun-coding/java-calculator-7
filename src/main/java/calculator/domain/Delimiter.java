package calculator.domain;

// 문자열을 특정 구분자로 분리하기 위해 만든 인터페이스이다.
// 상황에 따라 구분자로 분리할 수 있다.
public interface Delimiter {
    // 특정 구분자가 입력에 맞는지 확인
    boolean supports(String input);

    // 해당 구분자를 이용하여 입력 문자열을 분리
    String[] split(String input);
}
