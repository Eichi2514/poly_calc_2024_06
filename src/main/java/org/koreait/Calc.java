package org.koreait;

import java.util.Arrays;
import java.util.stream.Collectors;


////// 내 풀이 //////////////////////////////////////////////////////////////////////////////////////
public class Calc {
    public static boolean debug = true;
    public static int runCallCount = 0;

    public static double run(String exp) {
        runCallCount++;
        // 마이너스 제거
        exp = exp.replaceAll("- ", "+ -");
        // 괄호 앞 마이너스 제거
        exp = exp.replaceAll("-\\(", "-1 * (");
        // 10 + (10 + 5)
        exp = exp.trim(); // 양 옆의 쓸데없는 공백 제거
        // 괄호 제거

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ");
        boolean needToDividedBy = exp.contains(" / ");
        boolean needToSplit = exp.contains("(") || exp.contains(")");
        boolean needToCompound1 = needToMulti && needToPlus;
        boolean needToCompound2 = needToPlus && needToDividedBy;
        boolean needToCompound3 = needToMulti && needToDividedBy;

        int outerBracketsCount2 = 0;
        int outerBracketsCount3 = 0;
        boolean A = false;

        if (needToSplit) {
            for (int u = 0; u < exp.length(); u++) {
                if (exp.charAt(u) == '(') {
                    outerBracketsCount2++;
                    if (outerBracketsCount2 == 2) {
                        A = true;
                    }
                } else if (exp.charAt(u) == ')') {
                    outerBracketsCount2--;
                    outerBracketsCount3++;
                }
            }
        }

        if (A || outerBracketsCount2 == 0 && outerBracketsCount3 < 2) exp = stripOuterBrackets(exp);
        if (debug) {
            System.out.println("run(" + runCallCount + ") : " + exp);
        }
        // 단일항이 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        if (needToSplit) {
            int splitPointIndex = findSplitPointIndex(exp);

            String firstExp = exp.substring(0, splitPointIndex);
            String secondExp = exp.substring(splitPointIndex + 1);

            char operator = exp.charAt(splitPointIndex);

            exp = Calc.run(firstExp) + " " + operator + " " + Calc.run(secondExp);

            return Calc.run(exp);
        } else if (needToCompound1 || needToCompound2) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits).mapToDouble(Calc::run).mapToObj(e -> e + "").collect(Collectors.joining(" + "));

            return run(newExp);
        } else if (needToCompound3) {
            String[] bits = exp.split(" / ");

            String newExp = Arrays.stream(bits).mapToDouble(Calc::run).mapToObj(e -> e + "").collect(Collectors.joining(" / "));

            return run(newExp);
        }

        if (needToPlus) {

            String[] bits = exp.split(" \\+ ");

            double sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Double.parseDouble(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            double sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Double.parseDouble(bits[i]);
            }

            return sum;
        } else if (needToDividedBy) {
            String[] bits = exp.split(" / ");

            double sum = 1;
            double sum2 = Double.parseDouble(bits[0]);
            for (int i = 0; i < bits.length - 1; i++) {
                sum2 /= Double.parseDouble(bits[i + 1]);
                sum = sum2;
            }

            return sum;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+');

        if (index >= 0) return index;

        return findSplitPointIndexBy(exp, '*');
    }

    private static int findSplitPointIndexBy(String exp, char findChar) {
        int brackesCount = 0;

        for (int i = 0; i < exp.length(); i++) {
            exp.charAt(i);
            char c;

            if (exp.charAt(i) == '(') {
                brackesCount++;
            } else if (exp.charAt(i) == ')') {
                brackesCount--;
            } else if (exp.charAt(i) == findChar) {
                if (brackesCount == 0) return i;
            }
        }
        return -1;
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

////// 강사님 풀이 //////////////////////////////////////////////////////////////////////////////////////
//public class Calc {
//
//    public static boolean debug = false;
//    public static int runCallCount = 0;
//
//    public static int run(String exp) {
//        runCallCount++;
//
//        exp = exp.trim(); // 양 옆의 쓸데없는 공백 제거
//        // 괄호 제거
//        exp = stripOuterBrackets(exp);
//
//        // 만약에 -( 패턴이라면, 내가 갖고있는 코드는 해석할 수 없으므로 해석할 수 있는 형태로 수정
//        if (isCaseMinusBracket(exp)) {
//            exp = exp.substring(1) + " * -1";
//        }
//
//        if (debug) {
//            System.out.printf("exp(%d) : %s\n", runCallCount, exp);
//        }
//
//        // 단일항이 들어오면 바로 리턴
//        if (!exp.contains(" ")) {
//            return Integer.parseInt(exp);
//        }
//
//        boolean needToMulti = exp.contains(" * ");
//        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");
//        boolean needToSplit = exp.contains("(") || exp.contains(")");
//        boolean needToCompound = needToMulti && needToPlus;
//
//        if (needToSplit) {
//            int splitPointIndex = findSplitPointIndex(exp);
//
//            String firstExp = exp.substring(0, splitPointIndex);
//            String secondExp = exp.substring(splitPointIndex + 1);
//
//            char operator = exp.charAt(splitPointIndex);
//
//            exp = Calc.run(firstExp) + " " + operator + " " + Calc.run(secondExp);
//
//            return Calc.run(exp);
//        } else if (needToCompound) {
//            String[] bits = exp.split(" \\+ ");
//
//            String newExp = Arrays.stream(bits).mapToInt(Calc::run).mapToObj(e -> e + "").collect(Collectors.joining(" + "));
//
//            return run(newExp);
//        }
//
//        if (needToPlus) {
//            exp = exp.replaceAll("- ", "+ -");
//
//            String[] bits = exp.split(" \\+ ");
//
//            int sum = 0;
//
//            for (int i = 0; i < bits.length; i++) {
//                sum += Integer.parseInt(bits[i]);
//            }
//
//            return sum;
//        } else if (needToMulti) {
//            String[] bits = exp.split(" \\* ");
//
//            int sum = 1;
//
//            for (int i = 0; i < bits.length; i++) {
//                sum *= Integer.parseInt(bits[i]);
//            }
//
//            return sum;
//        }
//
//        throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
//    }
//
//    private static boolean isCaseMinusBracket(String exp) {
//        // -( 로 시작하는지?
//        if (exp.startsWith("-(") == false) return false;
//
//        // 괄호로 감싸져 있는지?
//        int bracketsCount = 0;
//
//        for (int i = 0; i < exp.length(); i++) {
//            char c = exp.charAt(i);
//
//            if (c == '(') {
//                bracketsCount++;
//            } else if (c == ')') {
//                bracketsCount--;
//            }
//            if (bracketsCount == 0) {
//                if (exp.length() - 1 == i) return true;
//            }
//        }
//
//        return false;
//    }
//
//    private static int findSplitPointIndex(String exp) {
//        int index = findSplitPointIndexBy(exp, '+');
//
//        if (index >= 0) return index;
//
//        return findSplitPointIndexBy(exp, '*');
//    }
//
//    private static int findSplitPointIndexBy(String exp, char findChar) {
//        int bracketsCount = 0;
//
//        for (int i = 0; i < exp.length(); i++) {
//            char c = exp.charAt(i);
//
//            if (c == '(') {
//                bracketsCount++;
//            } else if (c == ')') {
//                bracketsCount--;
//            } else if (c == findChar) {
//                if (bracketsCount == 0) return i;
//            }
//        }
//        return -1;
//    }
//
//    private static String stripOuterBrackets(String exp) {
//        int outerBracketsCount = 0;
//
//        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
//            outerBracketsCount++;
//        }
//
//        if (outerBracketsCount == 0) return exp;
//
//        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
//    }
//}