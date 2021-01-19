package com.ziyu.recursion;

class MiGong2 {


    public static void main(String[] args) {

        //模拟地图,二维数组
        int[][] map = new int[8][7];

        //约定 1 是墙,0是可以走的路

        //地图的上下都初始化为 1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部初始化为 1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }

        //设置挡板 (3,1)(3,2)
        map[3][1] = 1;
        map[3][2] = 1;

        //新增挡板
//        map[1][2]=1;
//        map[2][2]=1;


        System.out.println("地图如下~");
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        //使用递归回溯找到小球找路
        System.out.println(setWay2(map, 1, 1));

        //输出新的地图
        System.out.println("新地图如下~");
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 如果能找到(6,5)就是右下角的位置就是通路
     * 0 表示这个位置还没走过,1是墙,2是可以走,3表示已经走过,但是走不通.
     * 制定一个走迷宫的策略 下->右->上->左,入过该点走不通在回溯.
     *
     * @param map 地图
     * @param i   从哪个位置开始出发
     * @param j
     * @return 找到路就是 true,找不到就是false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //右下角的位置就是终点,说明找到了.
            return true;
        } else {

            //按照策略找路
            if (map[i][j] == 0) {
                //走迷宫的策略 下->右->上->左,入过该点走不通在回溯
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) { //下
                    return true;
                } else if (setWay(map, i, j + 1)) { //右
                    return true;
                } else if (setWay(map, i - 1, j)) { //上
                    return true;
                } else if (setWay(map, i, j - 1)) { //左¬
                    return true;
                } else { //不通
                    map[i][j] = 3;
                    return false;
                }
            } else { //非0 的其他情况
                return false;
            }
        }

    }

    /**
     * 修改策略,观察路径的情况
     * 如果能找到(6,5)就是右下角的位置就是通路
     * 0 表示这个位置还没走过,1是墙,2是可以走,3表示已经走过,但是走不通.
     * 制定一个走迷宫的策略 上->右->下->左,入过该点走不通在回溯.
     *
     * @param map 地图
     * @param i   从哪个位置开始出发
     * @param j
     * @return 找到路就是 true,找不到就是false
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //右下角的位置就是终点,说明找到了.
            return true;
        } else {

            //按照策略找路
            if (map[i][j] == 0) {
                //走迷宫的策略 下->右->上->左,入过该点走不通在回溯
                map[i][j] = 2;
                if (setWay(map, i - 1, j)) { //上
                    return true;
                } else if (setWay(map, i, j + 1)) { //右
                    return true;
                } else if (setWay(map, i + 1, j)) { //下
                    return true;
                } else if (setWay(map, i, j - 1)) { //左
                    return true;
                } else { //不通
                    map[i][j] = 3;
                    return false;
                }
            } else { //非0 的其他情况
                return false;
            }
        }

    }
}
