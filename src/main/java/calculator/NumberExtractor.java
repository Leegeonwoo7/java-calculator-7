package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    Validator validator = new Validator();

    public List<Integer> extractNumbers(String text) {
        // 4:3:2  4,3,2  4:3,2
        if (validator.isDefaultDelimiter(text)) {
            String[] splits = text.split("[:,]");

            return integerParse(splits);
        }

        String customDelimiter = getCustomDelimiter(text);
        String numbersWithDelimiter = removeIdentifier(text);
        String[] numbers = numbersWithDelimiter.split(customDelimiter);

        return integerParse(numbers);
    }

    private List<Integer> integerParse(String[] splits) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : splits) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private String getCustomDelimiter(String text) {
        int endDelimiterIndex = text.indexOf("\n");
        return text.substring(2, endDelimiterIndex);
    }

    private String removeIdentifier(String text) {
        int endDelimiterIndex = text.indexOf("\n");
        return text.substring(endDelimiterIndex + 1);
    }
}
