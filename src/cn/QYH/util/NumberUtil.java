package cn.QYH.util;

import java.util.Random;

public class NumberUtil {

    // 计算随机数的方法
    public static String getNumber(int number) {
        Random random = new Random();
        int num = random.nextInt(number) + 1;
        return num < 10 ? "0" + num : num + "";
    }

    public static void main(String[] args) {
    }
}
