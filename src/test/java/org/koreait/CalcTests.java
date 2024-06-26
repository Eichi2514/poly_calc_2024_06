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

    @Test
    @DisplayName("20 + 10 + 5 * 2 == 40")
    void t13() {
        assertThat(Calc.run("20 + 10 + 5 * 2")).isEqualTo(40);
    }

    @Test
    @DisplayName("10 + 10 * 10 * 10 == 1010")
    void t14() {
        assertThat(Calc.run("10 + 10 * 10 * 10")).isEqualTo(1010);
    }

    @Test
    @DisplayName("3 * 1 + 1 - 4 * 1 - 1 - 1 == -2")
    void t16() {
        assertThat(Calc.run("3 * 1 + 1 - 4 * 1 - 1 - 1")).isEqualTo(-2);
    }

    @Test
    @DisplayName("(10 + 20) == 30")
    void t18() {
        assertThat(Calc.run("(10 + 20)")).isEqualTo(30);
    }

    @Test
    @DisplayName("((10 + 20)) == 30")
    void t19() {
        assertThat(Calc.run("((10 + 20))")).isEqualTo(30);
    }

    @Test
    @DisplayName("(((10 + 20))) == 30")
    void t20() {
        assertThat(Calc.run("(((10 + 20)))")).isEqualTo(30);
    }

    @Test
    @DisplayName("10 / 5 == 2")
    void t21() {
        assertThat(Calc.run("10 / 5")).isEqualTo(2);
    }

    @Test
    @DisplayName("(((20 + 20))) + 20 == 60")
    void t22() {
        assertThat(Calc.run("(((20 + 20))) + 20")).isEqualTo(60);
    }

    @Test
    @DisplayName("(10 + 20) * 3 == 90")
    void t23() {
        assertThat(Calc.run("(10 + 20) * 3")).isEqualTo(90);
    }

    @Test
    @DisplayName("10 + (10 + 5) == 25")
    void t24() {
        assertThat(Calc.run("10 + (10 + 5)")).isEqualTo(25);
    }

    @Test
    @DisplayName("(10 + 5) + 10 == 25")
    void t25() {
        assertThat(Calc.run("(10 + 5) + 10")).isEqualTo(25);
    }

    @Test
    @DisplayName("-(10 + 5) == -15")
    void t26() {
        assertThat(Calc.run("-(10 + 5)")).isEqualTo(-15);
    }

    @Test
    @DisplayName("-(8 + 2) * -(7 + 3) + 5 == 105")
    void t27() {
        assertThat(Calc.run("-(8 + 2) * -(7 + 3) + 5")).isEqualTo(105);
    }

    @Test
    @DisplayName("3 * 1 + (1 - (4 * 1 - (1 - 1))) == 0")
    void t28() {
        assertThat(Calc.run("3 * 1 + (1 - (4 * 1 - (1 - 1)))")).isEqualTo(0);
    }

    @Test
    @DisplayName("3 * (1 + (1 - 4) * (1 - 1)) - 1 == 2")
    void t29() {
        assertThat(Calc.run("3 * (1 + (1 - 4) * (1 - 1)) - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("10 / 5 / 2 == 1")
    void t30() {
        assertThat(Calc.run("10 / 5 / 2")).isEqualTo(1);
    }

    @Test
    @DisplayName("10 * 5 / 2 == 25")
    void t31() {
        assertThat(Calc.run("10 * 5 / 2")).isEqualTo(25);
    }

    @Test
    @DisplayName("10 / 4 == 2.5")
    void t32() {
        assertThat(Calc.run("10 / 4")).isEqualTo(2.5);
    }


}
