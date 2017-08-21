package com.wl.college;

/**
 * Created by XJH on 2017/8/21.
 */
public class Matches {
    public static void main(String[] args) throws Exception {
        String regex = "^[A-Za-z](?![a-zA-Z]+$)[0-9A-Za-z!@#$%^&*]{7,15}$";

        String value = "aaa";  // 长度不够
        System.out.println("1、" + value.matches(regex));

        value = "1111aaaa1111aaaaa";  // 太长
        System.out.println("2、" + value.matches(regex));

        value = "111111111"; // 纯数字
        System.out.println("3、" + value.matches(regex));

        value = "aaaaaaaaa"; // 纯字母
        System.out.println("4、" + value.matches(regex));

        value = "####@@@@#"; // 特殊字符
        System.out.println("5、" + value.matches(regex));

        value = "1111aaaa";  // 数字字母组合
        System.out.println("6、" + value.matches(regex));

        value = "aaaa1111"; // 数字字母组合
        System.out.println("7、" + value.matches(regex));

        value = "aa1111aa";	// 数字字母组合
        System.out.println("8、" + value.matches(regex));

        value = "11aaaa11";	// 数字字母组合
        System.out.println("9、" + value.matches(regex));

        value = "aa11aa11"; // 数字字母组合
        System.out.println("10、" + value.matches(regex));

        value = "aa11aa11"; // 数字字母组合
        System.out.println("10、" + value.matches(regex));

        value = "aaaaaaaa"; // 数字字母组合
        System.out.println("11、" + value.matches(regex));

        value = "11111111"; // 数字字母组合
        System.out.println("12、" + value.matches(regex));

        value = "a1111111"; // 数字字母组合
        System.out.println("13、" + value.matches(regex));

        value = "1aaaaaaa"; // 数字字母组合
        System.out.println("14、" + value.matches(regex));

        value = "1aaaaaa"; // 数字字母组合
        System.out.println("15、" + value.matches(regex));

        value = "z11111111"; // 数字字母组合
        System.out.println("16、" + value.matches(regex));
    }
}
