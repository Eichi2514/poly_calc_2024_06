package org.koreait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//public class Calc {
//    public static int run(String exp) {
//
//        exp = exp.replaceAll("- ", "+ -");
//        exp = exp.replaceAll("\\(", "");
//        exp = exp.replaceAll("\\)", "");
//
//        String[] bits = exp.split(" ");
//        List<String> Bits = new ArrayList<>();
//        for (int o = 0; o < bits.length; o++) {
//            Bits.add(bits[o]);
//        }
////        int e1 = 0;
////        for (int e = 0; e < (Bits.size()); e++) {
////            if (Bits.get(e).contains("(")) {
////                for (int f = 0; f < (Bits.size()); f++) {
////                    if (Bits.get(f).contains(")")) {
////
////                    }
////                }
////
////            }
////        }
//
//
//        for (int i = 0; i < (Bits.size() - 1); i++) {
//            if (Bits.get(i + 1).contains("*")) {
//                int bi0 = Integer.parseInt(Bits.get(i));
//                int bi1 = Integer.parseInt(Bits.get(i + 2));
//
//                Bits.set(i, Integer.toString(bi0 * bi1));
//                Bits.remove(i + 1);
//                Bits.remove(i + 1);
//                i--;
//            }
//        }
//
//        for (int w = 0; w < (Bits.size() - 1); w++) {
//            if (Bits.get(w + 1).contains("/")) {
//                int bi0 = Integer.parseInt(Bits.get(w));
//                int bi1 = Integer.parseInt(Bits.get(w + 2));
//
//                Bits.set(w, Integer.toString(bi0 / bi1));
//                Bits.remove(w + 1);
//                Bits.remove(w + 1);
//                w--;
//            }
//        }
//
//        int a2 = 0;
//        for (int i2 = 0; i2 < Bits.size(); i2++) {
//            if (!Bits.get(i2).contains("+")) {
//                a2 += Integer.parseInt(Bits.get(i2));
//            }
//        }
//        return a2;
//    }
//}


//// 수업 //////////////////////////////////////////////////////////////////////////////////////
public class Calc {
    public static int run(String exp) {
        exp = exp.replaceAll("- ", "+ -");

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        exp = stripOuterBrackets(exp);

        if (exp.contains("*") && exp.contains("+")) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run).mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));
            return run(newExp);

        } else if (exp.contains("/") && exp.contains("+")) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits).mapToInt(Calc::run).mapToObj(e -> e + "").collect(Collectors.joining(" + "));
            return run(newExp);

        } else if (exp.contains("*")) {
            String[] bits = exp.split(" \\* ");
            int a1 = 1;
            for (int i = 0; i < bits.length; i++) {
                a1 *= Integer.parseInt(bits[i]);
            }
            return a1;

        } else if (exp.contains("/")) {
            String[] bits = exp.split(" / ");
            int a1 = Integer.parseInt(bits[0]);
            for (int i = 0; i < bits.length - 1; i++) {
                a1 /= Integer.parseInt(bits[i + 1]);
            }
            return a1;

        } else if (exp.contains("+")) {

            String[] bits = exp.split(" \\+ ");
            int a2 = 0;

            for (int i = 0; i < bits.length; i++) {
                a2 += Integer.parseInt(bits[i]);
            }
            return a2;
        }
        return 0;
    }

    private static String stripOuterBrackets(String exp) {
        int outerBracketsCount = 0;
        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }

        if (outerBracketsCount == 0) return exp;

        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }
}
