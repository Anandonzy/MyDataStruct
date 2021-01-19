package com.ziyu.recursion.test;

public class Queue8Test {

    static int max = 8;
    static int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {


        Queue8Test queue8Test = new Queue8Test();
        queue8Test.put(0);
        System.out.println(count);


    }

    /**
     * 监测是否冲突
     * 冲突为false 不允许放在这个位置,,不冲突为true
     *
     * @param n
     */
    private static boolean judge(int n) {

        for (int i = 0; i < n; i++) { //第n个之前的都要判断是否冲突
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
            //不满足需要右移
        }
        return true;


    }

    /**
     * 递归回溯,找到合适的位置
     *
     * @param n 放置的第n个皇后
     */
    private static void put(int n) {
        if (n == max) {
            printQueue();
            return;
        }

        for (int i = 0; i < max; i++) { //第n个之前的位置都要判断是否冲突.
            array[n] = i; //需要赋值,每一个都要涉及到
            if(judge(n)){
                put(n + 1);
            }
        }
    }

    /**
     * 打印结果
     */
    private static void printQueue() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
