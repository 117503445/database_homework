package com.wizzstudio.database_homework.util;

public class MathUtil {
    public static boolean isBetween(double num, double left, double right, boolean onLeft, boolean onRight) {
        if (num == left) {
            return onLeft;
        }
        if (num == right) {
            return onRight;
        }

        return num > left && num < right;
    }
}
