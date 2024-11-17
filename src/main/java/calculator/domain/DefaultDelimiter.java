package calculator.domain;

// , 또는 : 로 분리하는 역할을 한다
public class DefaultDelimiter implements Delimiter {
    private static final String NUMBER_REGEX = "[0-9]+([,|:][0-9]+)*"; // , : 로 연결된 형태의 문자열 허용
    private static final String DELIMITER_REGEX = "[,:]"; // , : 을 구분자로 사용하여 문자를 분리할 수 있도록 허용

    // 문자열이 NUMBER_REGEX 패턴과 일치하는지 확인하고 일치하면 True, False
    // (숫자 + 구분자 + 숫자) 패턴이 맞는지
    @Override
    public boolean supports(String input) {
        return input.matches(NUMBER_REGEX);
    }

    // , : 를 기준으로 분리하여 문자열 배열로 반환
    @Override
    public String[] split(String input) {
        return input.split(DELIMITER_REGEX);
    }
}
