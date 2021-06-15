package ru.education.algorithm;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringEquation {

    public ArrayList<Double> equationRegEx(String text) {
        String str = text.replaceAll(" ", "");
        Pattern pattern1 = Pattern.compile("(-?[\\d]*?\\.?[\\d]*?)x\\^2([+-])([\\d]*?\\.?[\\d]*?)x");
        Matcher matcher1 = pattern1.matcher(str);
        if(matcher1.find()) {
            double a;
            int index = str.indexOf("x^2");
            if (str.substring(0, index).equals("-")) {
                a = -1;
            } else if (matcher1.group(1).isEmpty()) {
                a = 1;
            } else {
                a = Double.parseDouble(matcher1.group(1));
            }
            if (a != 0) {
                ArrayList<Double> result = new ArrayList<>();
                double b;
                if (matcher1.group(3).isEmpty()) {
                    b = 1;
                } else {
                    b = Double.parseDouble(matcher1.group(3));
                }
                Pattern pattern2 = Pattern.compile("([\\d]*?\\.?[\\d]*?)=0$");
                Matcher matcher2 = pattern2.matcher(str);
                matcher2.find();
                double c;
                if (matcher2.group(1).isEmpty()) {
                    double x1 = 0;
                    double x2;
                    if (matcher1.group(2).equals("-")) {
                        x2 = b / a;
                    } else {
                        x2 = -b / a;
                    }
                    result.add(x1);
                    result.add(x2);
                    System.out.println("Result ax^2+cx :" + result);
                    return result;
                } else {
                    c = Double.parseDouble(matcher2.group(1));
                }
                double D = Math.pow(b, 2) - 4 * (a * c);
                if (D > 0) {
                    double x1 = (-b + Math.sqrt(D)) / 2 * a;
                    double x2 = (-b - Math.sqrt(D)) / 2 * a;
                    result.add(x1);
                    result.add(x2);
                    System.out.println("Result D>0 :" + result);
                    return result;
                } else if (D == 0) {
                    double x = -b / 2 * a;
                    result.add(x);
                    System.out.println("Result D==0 :" + result);
                    return result;
                } else if (D < 0) {
                    System.out.println("Result D<0 :" + result);
                    throw new IllegalStateException("the equation has no roots");
                }
            } else {
                throw new IllegalStateException("Error a==0");
            }
        }else {
            throw new IllegalStateException("Не квадратное урванение");
        }
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        String str = "-x^2 + x  = 0";
        String str2 = "1x^2 + 4x - 1.1 = 0";
        String str3 = "x^2 + 2x + 1 = 0";
        String str4 = "1x^2 + x + 1 = 0";
        String str5 = "0x^2 + x + 1 = 0";
        String str6 = "0.1x^2 + x + 1 = 0";

        StringEquation stringEquation = new StringEquation();
       // stringEquation.equationRegEx(str);
//         stringEquation.equationRegEx(str5);
       // stringEquation.equationRegEx(str3);
       // stringEquation.equationRegEx(str6);

    }


}
