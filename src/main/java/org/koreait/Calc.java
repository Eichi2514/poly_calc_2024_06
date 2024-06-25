package org.koreait;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int run(String exp) {

        exp = exp.replaceAll("- ", "+ -");
//        exp = exp.replaceAll("-\\(", "(-");
//        exp = exp.replaceAll("\\(", "( ");
//        exp = exp.replaceAll("\\)", " )");

        String[] bits = exp.split(" ");
        List<String> Bits = new ArrayList<>();
        for (int o = 0; o < bits.length; o++) {
            Bits.add(bits[o]);
        }
//        int e1 = 0;
//        for (int e = 0; e < (Bits.size()); e++) {
//            if (Bits.get(e).contains("(")) {
//                for (int f = 0; f < (Bits.size()); f++) {
//                    if (Bits.get(f).contains(")")) {
//
//                    }
//                }
//
//            }
//        }


        for (int i = 0; i < (Bits.size() - 1); i++) {
            if (Bits.get(i + 1).contains("*")) {
                int bi0 = Integer.parseInt(Bits.get(i));
                int bi1 = Integer.parseInt(Bits.get(i + 2));

                Bits.set(i, Integer.toString(bi0 * bi1));
                Bits.remove(i + 1);
                Bits.remove(i + 1);
                i--;
            }
        }

        for (int w = 0; w < (Bits.size() - 1); w++) {
            if (Bits.get(w + 1).contains("/")) {
                int bi0 = Integer.parseInt(Bits.get(w));
                int bi1 = Integer.parseInt(Bits.get(w + 2));

                Bits.set(w, Integer.toString(bi0 / bi1));
                Bits.remove(w + 1);
                Bits.remove(w + 1);
                w--;
            }
        }

        int a2 = 0;
        for (int i2 = 0; i2 < Bits.size(); i2++) {
            if (!Bits.get(i2).contains("+")) {
                a2 += Integer.parseInt(Bits.get(i2));
            }
        }
        return a2;
    }
}


/// 수업 //////////////////////////////////////////////////////////////////////////////////////
//public class Calc {
//    public static int run(String exp) {
//
//        exp = exp.replaceAll("- ", "+ -");
//
//
//        if (exp.contains("*")) {
//            String[] bits = exp.split(" \\* ");
//            int a = 1;
//            for (int i = 0; i < bits.length; i++) {
//                a *= Integer.parseInt(bits[i]);
//            }
//            return a;
//        } else {
//            String[] bits = exp.split(" \\+ ");
//            int a = 0;
//            for (int i = 0; i < bits.length; i++) {
//                a += Integer.parseInt(bits[i]);
//            }
//            return a;
//        }
//    }
//}
