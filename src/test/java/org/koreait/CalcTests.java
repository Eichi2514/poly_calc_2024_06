package org.koreait;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcTests {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(Calc.run("1 + 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(Calc.run("2 + 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("50 - 30 == 20")
    void t4() {
        assertThat(Calc.run("50 - 30")).isEqualTo(20);
    }

    @Test
    @DisplayName("100 - 50 == 50")
    void t5() {
        assertThat(Calc.run("100 - 50")).isEqualTo(50);
    }

    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t6() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }

    @Test
    @DisplayName("20 + 40 + 60 == 120")
    void t7() {
        assertThat(Calc.run("20 + 40 + 60")).isEqualTo(120);
    }

    @Test
    @DisplayName("20 - 40 - 60 == -80")
    void t8() {
        assertThat(Calc.run("20 - 40 - 60")).isEqualTo(-80);
    }

    @Test
    @DisplayName("20 - 40 - 60 - 20 == -100")
    void t9() {
        assertThat(Calc.run("20 - 40 - 60 - 20")).isEqualTo(-100);
    }

    @Test
    @DisplayName("1 - 2 - 3 + 4 + 5 - 6 - 7 + 8 - 9 + 10 + 11 == 12")
    void t10() {
        assertThat(Calc.run("1 - 2 - 3 + 4 + 5 - 6 - 7 + 8 - 9 + 10 + 11")).isEqualTo(12);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t11() {
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }

    @Test
    @DisplayName("10 + 5 * 2 == 20")
    void t12() {
        assertThat(Calc.run("10 + 5 * 2")).isEqualTo(20);
    }
}
