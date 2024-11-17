package calculator;

import calculator.config.ApplicationContext;
import calculator.presentation.StringAdditionController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ApplicationContext context = new ApplicationContext();
        StringAdditionController stringAdditionController = context.getStringAdditionController();
        stringAdditionController.run();
    }
}
