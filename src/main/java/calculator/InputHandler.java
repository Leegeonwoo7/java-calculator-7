package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 문자열을 입력받는 객체
 * 검증 객체를 의존하여 검증을 수행한다.
 */
public class InputHandler {
    private Validator validator;

    public String inputString() {
        String inputStr = Console.readLine();

        validator.validate(inputStr);
        Console.close();

        return inputStr;
    }
}
