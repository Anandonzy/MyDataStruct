package com.ziyu.recursion;

/**
 * 递归的回顾
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int res = factorial(1);
        System.out.println(2);

    }

    /**
     * 递归打印,简单理解,入门
     * 方法栈 test(4) test(3) test(2)
     * <-- < -- < --
     * 输出2,3,4
     *
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n:" + n);
    }


    public static int factorial(int n) {


        if (n == 1) {
            return 1;
        } else {

            return factorial(n - 1) * n;
        }

    }

}
