package calculator.application;

import calculator.common.ErrorMessage;
import calculator.domain.Delimiter;
import org.assertj.core.internal.ErrorMessages;

import java.util.List;

public class DelimiterProcessor {
    // 구분자들의 리스트
    private List<Delimiter> delimiters;

    // 구분자 리스트를 초기화
    public DelimiterProcessor(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    // 구분자로 분리하여 문자열 배열을 반환
    public String[] extraNumberStrings(String input) {
        return this.delimiters.stream() // 리스트들을 stream 으로 변환하여 각 구분자들을 처리
                .filter(d -> d.supports(input)) // supports 함수로 해당 구분자가 사용가능한 커스텀된 구분자인지 확인
                .findFirst()// supports 의 값이 true 인지 확인
                .map(d -> d.split(input)) // split 을 통해 구분자로 문자열을 분리
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR)); // 조건에 맞지 않으면 ERROR 예외를 발생시키고 에러 메세지 출력
    }

}
