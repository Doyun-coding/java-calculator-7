package calculator.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class InputHandler {
    // 사용자에게 입력을 요청하는 메세지를 상수로 저장
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public Optional<String> input() {
        // 사용자에게 메세지 출력
        System.out.println(INPUT_PROMPT_MESSAGE);
        // Console 에 있는 readLine() 을 통해 사용자에게 입력을 받음
        String input = Console.readLine();

        // processInput 함수를 호출하여 받은 입력을 결과로 반환
        return processInput(input);
    }

    // processInput 함수는 입력된 문자열을 검증하고 가공하는 역할을 한다
    private Optional<String> processInput(String input) {
        // 입력받은 값이 null 이거나 공백으로 이루어져 있으면 empty() 를 반환하여 값이 없음을 알린다
        if(input == null || input.isBlank()) {
            return Optional.empty();
        }

        // trim() 을 사용하여 공백을 없애고 \\n 문자를 \n 개행으로 바꾼다
        return Optional.of(input.trim().replace("\\n", "\n"));
    }
}
