package org.koreait;

public class Calc {
    public static int run(String exp) {
        int Sum = 0;

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
            for (int i = 0; i < bits.length; i++) {
                Sum += Integer.parseInt(bits[i]);
            }
            return Sum;

        } else if (needToMinus) {
            bits = exp.split(" - ");
            Sum = Integer.parseInt(bits[0]);
            for (int i = 1; i < bits.length; i++) {
                Sum -= Integer.parseInt(bits[i]);
            }
            return Sum;
        }
        throw new RuntimeException("해석불가 : 올바른 계산식이 아니야");

    }
}
