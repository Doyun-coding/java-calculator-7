package calculator.io;

public class ResultPrinter {
    // 결과 값을 출력해주는 문자를 상수로 설정
    private static final String RESULT_MESSAGE_FORMAT = "결과 : %d";

    public void printResult(int result) {
        // String.format 함수를 사용하여 메세지와 result 값을 출력
        System.out.println(String.format(RESULT_MESSAGE_FORMAT, result));
    }
}
