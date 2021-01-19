package com.ziyu.recursion;


/**
 * 经典8皇后问题
 */
public class Queue8 {
    //定义max最大的皇后个数
    int max = 8;
    int[] array = new int[max]; //定义数组,保存皇后存放位置的结果,比如arr={0,4,7,5,2,6,1,3}
    static int count = 0;

    public static void main(String[] args) {

        //测试一把,8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    //编写一个方法,放置第n个皇后 0,1,2,3,4,5,6,7,8
    private void check(int n) {
        if (n == max) { //n=8 就放置第九个皇后了.其实8个皇后就已经放置好了. 也就是结束了.
            printQueue();
            return;
        }

        //以此放置皇后,判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前的皇后n,放在该行的第一列
            array[n] = i;

            //当放置第n个皇后到i列的时候,是否冲突.
            if (judge(n)) {//不冲突,继续放n+1个皇后.
                check(n + 1); //每一层就递归时,都会进入到for循环.
            }
            //如果冲突,就继续执行array[n] = i,将第n个皇后放置本行的右移的一个位置.
        }


    }

    //查看当前我们放置第n个皇后,将去监测当前皇后是否与已经摆放的冲突了
    private boolean judge(int n) {

        for (int i = 0; i < n; i++) { //第n个之前的都要监测是否冲突, 所以要for循环
            //array[i] == array[n] 是否在一列
            //Math.abs(n - i) == Math.abs(array[n] - array[i]) 是否在一个斜线上!
            // n = 1 ; Math.abs(1-0) == Math.abc(array(1)-array[0])
            //没有必要判断是否在同一行, i++ 在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }

        }
        return true;
    }

    /**
     * 打印结果.
     */
    private void printQueue() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
