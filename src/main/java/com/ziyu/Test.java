package com.ziyu;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangziyu1
 * @date 2020-06-16 17:39
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("first add to git");
        System.out.println("second add to git");
        System.out.println("therd add to git");


        /**
         *public static void fill(int[] a, form, to, int var)
         * 参数：
         *
         * a--数组
         *
         * form--替换开始位置（包括）
         *
         * to--替换结束位置（不包括）
         *
         * var--要替换的值
         */
        //Arrays.fill 方法使用案例
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(a));

        //不指定范围全部替换
//        Arrays.fill(a, 0);
        System.out.println(Arrays.toString(a));

        //包头不包尾
        Arrays.fill(a, 0, 5, 0);
        System.out.println(Arrays.toString(a));

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "2");
        map.put("1", "3");
        map.put("1", "4");
        map.put("2", "2");

        map.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
        });
        System.out.println(map.size());
    }
}
