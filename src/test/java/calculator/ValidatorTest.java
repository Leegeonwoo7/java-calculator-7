package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("커스텀 구분자를 등록하지 않고 사용할 경우 예외가 발생한다")
    void notRegisterCustomDelimiter() {
        //given
        String inputString = "4;5;6";

        //when //then
        assertThatThrownBy(() -> validator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자등록 형식이 잘못되면 예외가 발생한다")
    void wrongCustomDelimiter() {
        //given
        String inputString = "/;\n4;5;6";

        //when //then
        assertThatThrownBy(() -> validator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("등록한 커스텀 구분자와 다른 구분자를 사용하면 예외가 발생한다")
    void wrongUseCustomDelimiter() {
        //given
        String inputString = "//%\n4;5;6";

        //when //then
        assertThatThrownBy(() -> validator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("기본 구분자와 등록되지 않은 커스텀 구분자를 함께 사용하면 예외가 발생한다")
    void wrongUseDelimiters() {
        //given
        String inputString = "4;5,6-7";

        //when //then
        assertThatThrownBy(() -> validator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른문자가 입력되면 예외가 발생한다")
    void wrongInputWithChar() {
        //given
        String inputString = "4d,5,6,a7";

        //when //then
        assertThatThrownBy(() -> validator.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Success Case

    @Test
    @DisplayName("커스텀 구분자를 사용한다 (구분자: 특수문자)")
    void customDelimiterBySpecialChar() {
        //given
        String inputString = "//;\n4;2;1";

        //when //then
        validator.validate(inputString);
    }

    @Test
    @DisplayName("커스텀 구분자 사용한다 (구분자: 영문자)")
    void useCustomDelimiterByAlphabet() {
        //given
        String inputString = "//d\n1d2d3";

        //when //then
        validator.validate(inputString);
    }

    @Test
    @DisplayName("기본 구분자 \":\"를 단독으로 사용한다")
    void useDefaultColonDelimiter() {
        //given
        String inputString = "4:5:6";

        //when //then
        validator.validate(inputString);
    }

    @Test
    @DisplayName("기본 구분자 \",\"를 단독으로 사용한다")
    void useDefaultCommaDelimiter() {
        //given
        String inputString = "4,5,6";

        //when //then
        validator.validate(inputString);
    }

    @Test
    @DisplayName("기본 구분자 \",\"와 \":\"를 함께 사용한다")
    void useMultiDelimiters() {
        //given
        String inputString = "4:5,6";

        //when //then
        validator.validate(inputString);
    }

    @Test
    @DisplayName("입력된 숫자는 자릿수에 구애받지 않는다")
    void validateInputNumbers() {
        //given
        String inputString = "45123,511,633";

        //when //then
        validator.validate(inputString);
    }

}