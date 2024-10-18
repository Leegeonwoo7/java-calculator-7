package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NumberExtractorTest {

    NumberExtractor numberExtractor = new NumberExtractor();

    @Test
    @DisplayName("기본 구분자 ','를 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useCommaDefaultDelimiter() {
        //given
        String text = "1,2,3";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(1,2,3);
    }


    @Test
    @DisplayName("기본 구분자 ':'를 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useColonDelimiter() {
        //given
        String text = "1:2:3";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(1,2,3);
    }

    @Test
    @DisplayName("기본 구분자 ':'와 ','를 함께 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useDefaultDelimiters() {
        //given
        String text = "1,2:3";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(1,2,3);
    }

    @Test
    @DisplayName("특수문자 커스텀 구분자를 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useCustomDelimiter1() {
        //given
        String text = "//;\n4;5;6";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(4,5,6);
    }

    @Test
    @DisplayName("알파벳 커스텀 구분자를 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useCustomDelimiter2() {
        //given
        String text = "//a\n4a5a6";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(4,5,6);
    }

    @Test
    @DisplayName("알파벳 커스텀 구분자를 사용한 문자열로부터 숫자 리스트를 가져온다")
    void useCustomDelimiter3() {
        //given
        String text = "//;\n4";

        //when
        List<Integer> numbers = numberExtractor.extractNumbers(text);

        //then
        assertThat(numbers).containsAnyOf(4);
    }
}