package org.koreait;

//public class Calc {
//    public static int run(String exp) {
//
//        exp = exp.replaceAll("- ", "+ -");
//
//        String[] bits = exp.split(" ");
//        int b = 0;
//        for (int n = 0; n < bits.length; n++) {
//            if (bits[n] == "*") {
//                int c = Integer.parseInt(bits[n - 1]);
//                int d = Integer.parseInt(bits[n + 1]);
//                if (d > 1) {
//                    for (int m = 0; m < d; m++) {
//                        c += c;
//                    }
//                }
//                bits[n - 1] = Integer.toString(c);
//            }
//        }
//
//        int a = 0;
//        for (int i = 0; i < bits.length; i++) {
//            a += Integer.parseInt(bits[i]);
//        }
//        return a;
//    }
//}


public class Calc {
    public static int run(String exp) {

        exp = exp.replaceAll("- ", "+ -");


        if (exp.contains("*")) {
            String[] bits = exp.split(" \\* ");
            int a = 1;
            for (int i = 0; i < bits.length; i++) {
                a *= Integer.parseInt(bits[i]);
            }
            return a;
        } else {
            String[] bits = exp.split(" \\+ ");
            int a = 0;
            for (int i = 0; i < bits.length; i++) {
                a += Integer.parseInt(bits[i]);
            }
            return a;
        }
    }
}
