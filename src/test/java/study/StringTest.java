package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");

        assertThat(actual).contains("1");

        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt() 이용한 특정 위치의 문자 ")
    @Test
    void charAt() {
        String str = "abc";

        // assertThatThrownBy(() -> { 
        //     str.charAt(str.length());
        // }).isInstanceOf(StringIndexOutOfBoundsException.class)
        // .hasMessageContaining("Index: 2, length: 2")
        // .hasMessageContaining("String index out of range")
        // .hasMessageContaining(String.valueOf(str.length()));

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
            str.charAt(3);
        }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
