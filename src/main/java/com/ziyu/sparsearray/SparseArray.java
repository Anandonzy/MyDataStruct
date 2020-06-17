package com.ziyu.sparsearray;

/**
 * @author wangziyu1
 * @date 2020-06-17 14:24
 * 二维数组 转 稀疏数组的思路
 * 主要思想就是将多余的0不进行记录,将有值的地方记录行竖坐标即可.
 * 1. 遍历原始的二维数组，得到有效数据的个数 sum
 * 2. 根据 sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
 * 3. 将二维数组的有效数据数据存入到 稀疏数组
 *
 * 原先的数组
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 1 0 0 0 0 0 0 0 0
 * 0 0 0 2 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 稀疏数组: 第一行记录原先的数组有多少行有多少列.
 * row   col   val
 * 0   11      11    2
 * 1   1       2     1
 * 2   2       3     2
 */
public class SparseArray {

    public static void main(String[] args) {

        //创建原先的数组11*11
        int[][] sourceArray1 = new int[11][11];
        sourceArray1[1][2] = 1;
        sourceArray1[2][3] = 2;
        sourceArray1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : sourceArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //转换稀疏数组
        //1.遍历原先的数组统计有效的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (sourceArray1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组的大小
        int[][] chessyArr2 = new int[sum + 1][3];

        //给稀疏数组的第一行赋值
        chessyArr2[0][0] = 11;
        chessyArr2[0][1] = 11;
        chessyArr2[0][2] = sum;

        //遍历原先的二维数组
        int count = 0; //用于记录第几个非0 的数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (sourceArray1[i][j] != 0) {
                    count++; //count值能确定第几个,从而给新的稀疏数组赋值.
                    chessyArr2[count][0] = i;
                    chessyArr2[count][1] = j;
                    chessyArr2[count][2] = sourceArray1[i][j];
                }
            }
        }

        //遍历稀疏数组
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < chessyArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", chessyArr2[i][0], chessyArr2[i][1], chessyArr2[i][2]);
        }
        System.out.println();

        //2.稀疏数组转换成原先的数组
        /**
         * 思路:
         * 1.根据第一行的信息创建对应的数组的大小
         * 2.在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */
        int[][] sourceArray2 = new int[chessyArr2[0][0]][chessyArr2[0][1]];

        for (int i = 1; i <chessyArr2.length ; i++) {
            sourceArray2[chessyArr2[i][0]][chessyArr2[i][1]]=chessyArr2[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : sourceArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
