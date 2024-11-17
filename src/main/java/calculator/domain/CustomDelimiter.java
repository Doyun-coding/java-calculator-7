package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 사용자 정의 구분자를 처리할 수 있는 Delimiter 인터페이스 구현체
public class CustomDelimiter implements Delimiter {
    // (.) 에서 () 는 그룹화를 의미하고 . 는 임의의 문자를 의미한다 (.) 는 // 뒤에 오는 한 문자를 캡쳐하는 것
    // (.*) 는 임의의 문자가 0개 이상 존재한다는 의미이고 모든 임의의 문자를 캡쳐한다
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)"); // 문자열이 // 로 시작하는지 확인하고 \n 안에 있는 문자열 가져온다
    private static final String NUMBER_REGEX = "[0-9]+([,|:|%s][0-9]+)*"; // 사용자가 정의한 구분자 %s 사용할 수 있도록 설정
    private static final String DELIMITER_REGEX = ",|:|%s"; // , : 구분자 이외에 사용자가 정의한 구분자를 사용할 수 있도록 설정

    @Override
    public boolean supports(String input) {
        // getMatcher 메소드를 이용하여 CUSTOM_DELIMITER_PATTERN 와 패턴이 맞는지 확인한다
        Matcher matcher = getMatcher(input);
        if(!matcher.matches()) {
            return false;
        }

        // 매칭 결과를 캡처한 값을 추출하고 새로운 정규 표현식을 동적으로 생성하는 과정
        String customDelimiter = matcher.group(1); // 첫 번째 그룹으로 묶인 부분의 값을 추출 (.) 인 부분 //(.)\n 에 해당
        String numberString = matcher.group(2); // (.*) 로 정의된 부분에 해당 -> //;\n1;2;3 이면 1;2;3 에 해당
        // Pattern.quote(customDelimiter) 부분은 customDelimiter 를 정규 표현식으로 ; % 등 특수 기호를 안정하게 사용할 수 있도록 한다
        String numberPattern = String.format(NUMBER_REGEX, Pattern.quote(customDelimiter)); // %s 부분 처리하기 위해 format 함수 사용

        return numberString.matches(numberPattern);
    }

    // input 에 대해 CUSTOM_DELIMITER_PATTERN 을 사용하여 매칭
    @Override
    public String[] split(String input) {
        Matcher matcher = getMatcher(input);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        String delimiterRegex = String.format(DELIMITER_REGEX, Pattern.quote(customDelimiter));

        return numberString.split(delimiterRegex);
    }

    // 주어진 입력에 대해 Matcher 객체를 생성하고 반환
    public Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}
