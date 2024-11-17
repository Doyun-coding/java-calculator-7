package calculator.config;

import calculator.application.DelimiterProcessor;
import calculator.application.StringSumCalculator;
import calculator.domain.CustomDelimiter;
import calculator.domain.DefaultDelimiter;
import calculator.domain.Delimiter;
import calculator.io.InputHandler;
import calculator.io.ResultPrinter;
import calculator.presentation.StringAdditionController;

import java.util.List;

public class ApplicationContext {
    private InputHandler inputHandler;
    private ResultPrinter resultPrinter;
    private StringSumCalculator stringSumCalculator;
    private DelimiterProcessor delimiterProcessor;
    private StringAdditionController stringAdditionController;

    public ApplicationContext() {
        this.inputHandler = new InputHandler();
        this.delimiterProcessor = new DelimiterProcessor(createDelimiters());
        this.stringSumCalculator = new StringSumCalculator();
        this.resultPrinter = new ResultPrinter();

        this.stringAdditionController = new StringAdditionController(inputHandler, delimiterProcessor,stringSumCalculator, resultPrinter);
    }

    public StringAdditionController getStringAdditionController() {
        return stringAdditionController;
    }

    private List<Delimiter> createDelimiters() {
        return List.of(new DefaultDelimiter(), new CustomDelimiter());
    }
}
