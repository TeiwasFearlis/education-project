package ru.education.algorithm.twosum;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEqNew {
    public ArrayList<Double> equationRegEx(String text) {
        String str = text.replaceAll(" ", "");
        Pattern pattern1 = Pattern.compile("(-?[\\d]*?\\.?[\\d]*?)x\\^2([+-][\\d]*?\\.?[\\d]*?)x([+-][\\d]*?\\.?[\\d]*?)?=0");
        Matcher matcher1 = pattern1.matcher(str);
        if(matcher1.find()) {
            double a;
            if (matcher1.group(1).isEmpty()) {
                a = 1;
            } else {
                a = Double.parseDouble(matcher1.group(1));
            }
            if (a != 0) {
                ArrayList<Double> result = new ArrayList<>();
                double b;
                if (matcher1.group(2).isEmpty()) {
                    b = 1;
                } else {
                    b = Double.parseDouble(matcher1.group(2));
                }
                double c;
                if (matcher1.group(3)==null || matcher1.group(3).isEmpty()) {
                    result.add(0.0);
                    result.add(-b / a);
                    return result;
                } else {
                    c = Double.parseDouble(matcher1.group(3));
                }
                double D = Math.pow(b, 2) - 4 * (a * c);
                if (D > 0) {
                    double x1 = (-b + Math.sqrt(D)) / 2 * a;
                    double x2 = (-b - Math.sqrt(D)) / 2 * a;
                    result.add(x1);
                    result.add(x2);
                    return result;
                } else if (D == 0) {
                    double x = -b / 2 * a;
                    result.add(x);
                    return result;
                } else if (D < 0) {
                    throw new IllegalStateException("the equation has no roots");
                }
            } else {
                throw new IllegalStateException("Error a==0");
            }
        }else {
            throw new IllegalStateException("Pattern not found");
        }
        return new ArrayList<>();//TODO REMOVE THIS
    }
}
