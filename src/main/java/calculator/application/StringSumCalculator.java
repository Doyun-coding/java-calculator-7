package calculator.application;

import calculator.common.ErrorMessage;

import java.util.Arrays;

public class StringSumCalculator {
    // 입력받은 문자열을 정수로 변환하고 합계를 반환
    public int sumStringNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers) // stream 형으로 반환
                .mapToInt(this::parseAndValidate) // parseAndValidate 메소드를 통해 정수형으로 변환하고 합계 계산
                .sum();
    }

    // String 을 정수로 변환해주는 메소드
    private int parseAndValidate(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        validatePositiveNumber(number); // 음수인 경우 에러 출력하는 함수 호출

        return number;
    }

    // 정수가 0 이상인 양의 정수인지 확인하는 메소드
    private void validatePositiveNumber(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER_ERROR);
        }
    }
}
