package calculator;

import calculator.application.DelimiterProcessor;
import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DelimiterProcessTest {
    private DelimiterProcessor delimiterProcessor;

    @BeforeEach
    void setup() {
        delimiterProcessor = new DelimiterProcessor(List.of(new DefaultDelimiter(), new CustomDelimiter()));
    }

    @DisplayName("문자열을 숫자로 분리 - 숫자가 하나일 경우")
    @Test
    void extraNumberStringsWith_숫자_하나() {
        String input = "1";
        String[] result = delimiterProcessor.extraNumberStrings(input);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("기본 구분자(,|:)를 사용하 문자열을 숫자로 분리")
    @Test
    void extractNumberStringWith_커스텀_구분자_세미콜론() {
        String input = "1,2:3";
        String[] result = delimiterProcessor.extraNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자(;)를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringWith_기본_구분자() {
        String input = "//;\n1;2;3";
        String[] result = delimiterProcessor.extraNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자(#)를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringWith_커스텀_구분자_해시() {
        String input = "//#\n4#5#6";
        String[] result = delimiterProcessor.extraNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3", "4");
    }


}
