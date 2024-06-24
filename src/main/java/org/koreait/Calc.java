package org.koreait;

public class Calc {
    public static int run(String exp) {


        exp = exp.replaceAll("- ", "+ -");


        String[] bits = exp.split(" \\+ ");


        int a = 0;
        for (int i = 0; i < bits.length; i++) {
            a += Integer.parseInt(bits[i]);
        }
        return a;
    }
}
