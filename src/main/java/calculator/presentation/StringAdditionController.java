package calculator.presentation;

import calculator.application.DelimiterProcessor;
import calculator.application.StringSumCalculator;
import calculator.io.InputHandler;
import calculator.io.ResultPrinter;

// 프로그램의 전체 흐름을 관리하는 컨트롤러 역할
// 각 역할을 수행하는 클래스들을 주입받아 사용자로부터 입력을 받아 처리하고 최종 결과를 출력하는 기능
public class StringAdditionController {
    private static final int ZERO = 0; // 입력이 비어있는 경우 출력할 때 사용
    private InputHandler inputHandler; // 입력을 받는 역할
    private DelimiterProcessor delimiterProcessor; // 입력된 문자열을 특정 구분자로 분리
    private StringSumCalculator stringSumCalculator; // 문자열 배열을 정수로 변환하고 합산
    private ResultPrinter resultPrinter; // 출력

    public StringAdditionController(InputHandler inputHandler, DelimiterProcessor delimiterProcessor, StringSumCalculator stringSumCalculator,
                                    ResultPrinter resultPrinter) {
        this.inputHandler = inputHandler;
        this.delimiterProcessor = delimiterProcessor;
        this.stringSumCalculator = stringSumCalculator;
        this.resultPrinter = resultPrinter;
    }

    // 실행을 담당하는 메소드
    public void run() {
        inputHandler.input() // inputHandler 의 input 메소드를 통해 Optional<String> 타입의 입력을 받는다
                .ifPresentOrElse(this::processInput, () -> resultPrinter.printResult(ZERO)); // processInput 메소드를 호출하여 계산, 없으면 0 출력
    }

    // 입력 문자열을 처리하는 메소드
    private void processInput(String input) {
        String[] stringNumbers = delimiterProcessor.extraNumberStrings(input); // 구분자들로 나눠서 정수만을 배열로 나눈다
        int sum = stringSumCalculator.sumStringNumbers(stringNumbers); // 위에서 나눈 정수들을 StringSumCalculator 에서 정의한 함수로 계산
        resultPrinter.printResult(sum); // 출력
    }

}
