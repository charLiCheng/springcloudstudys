package com.charli.lambda.regex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 * @Description : regex记录
 * @Author xiaoli.cheng
 * @Date 2020/6/11 15:15
 */
public class Regex {

    /**
     * 0<=数字<=100 ,可以是小数,且小数点保留两位
     */
    private final static String REGEX = "^((\\d|[1-9]\\d|100)(\\.\\d{1,2}))|(\\d|[1-9]\\d|100)$";

    public static void main(String[] args) {
        boolean matches = Pattern.matches(REGEX, "23");
        System.out.println(matches);
        boolean matches1 = Pattern.matches(REGEX, "23.0");
        System.out.println(matches1);
        boolean matches2 = Pattern.matches(REGEX, "23.12");
        System.out.println(matches2);
        boolean matches3 = Pattern.matches(REGEX, "23.123");
        System.out.println(matches3);
        boolean matches4 = Pattern.matches(REGEX, "-23.12");
        System.out.println(matches4);
        boolean matches5 = Pattern.matches(REGEX, "0.0");
        System.out.println(matches5);

        BigDecimal completeNum = new BigDecimal("1");
        BigDecimal allNum = new BigDecimal("3");
        BigDecimal multiply = completeNum.divide(allNum, 2, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
        System.out.println(multiply);
        double aaa = Double.parseDouble("2");
        double bbb = Double.parseDouble("5");
        double ccc =(aaa / bbb)*100;

        BigDecimal divide = new BigDecimal(String.valueOf(ccc)).setScale(2,BigDecimal.ROUND_DOWN);
        String s1 = divide.stripTrailingZeros().toPlainString();
        divide = new BigDecimal(divide.stripTrailingZeros().toPlainString());
        System.out.println(divide);
        System.out.println(ccc);
    }

}
