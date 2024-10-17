package calculator;


/**
 * 문자열에 대한 검증을 수행한다.
 */
public class Validator {
    private final String CUSTOM_DELIMITER_PATTERN = "^//([^0-9\\n])\\n\\d+(\\1\\d+)*$";
    private final String DEFAULT_DELIMITER_PATTERN = "^\\d+([,:]\\d+)*$";

    public void validate(String text) {
        if (!isCustomDelimiter(text) && !isDefaultDelimiter(text)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    /**
     * @param text 검증할 문자열
     * @return 커스텀 구분자를 사용하는지에 대한 검증 결과
     * 커스텀 문자열을 사용하는지 검증한다
     * 커스텀 문자열을 사용한다면 커스텀 문자열을 적용해서 사용하는지 검증한다
     */
    private boolean isCustomDelimiter(String text) {
        return text.matches(CUSTOM_DELIMITER_PATTERN);
    }

    /**
     *
     * @param text 검증할 문자열
     * @return 기본 구분자를 사용하는지에 대한 검증 결과
     */
    private boolean isDefaultDelimiter(String text) {
        return text.matches(DEFAULT_DELIMITER_PATTERN);
    }
}
