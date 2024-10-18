package calculator;

/**
 * 문자열에 대한 검증을 수행한다.
 */
public class Validator {
    private final String CUSTOM_DELIMITER_PATTERN = "^//([^0-9\\\\n])\\\\n\\d+(\\1\\d+)*$";
    private final String DEFAULT_DELIMITER_PATTERN = "^\\d+([,:]\\d+)*$";

    public void validate(String text) {
        System.out.println(text);
        if (!isCustomDelimiter(text) && !isDefaultDelimiter(text)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    public boolean isCustomDelimiter(String text) {
        return text.matches(CUSTOM_DELIMITER_PATTERN);
    }

    public boolean isDefaultDelimiter(String text) {
        return text.matches(DEFAULT_DELIMITER_PATTERN);
    }
}
