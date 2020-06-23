package com.ziyu.recursion

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 17:42
 *       1 1 1 1 1 1 1
 *       1 0 1 0 0 0 1
 *       1 0 1 0 0 0 1
 *       1 1 1 0 0 0 1
 *       1 0 0 0 0 0 1
 *       1 0 0 0 0 0 1
 *       1 0 0 0 0 0 1
 *       1 1 1 1 1 1 1
 *
 */
object MiGong {

  def main(args: Array[String]): Unit = {
    //地图
    val map = Array.ofDim[Int](8, 7)

    //上下全部置换成1
    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }

    //左右全部置1
    for (i <- 0 until 8) {
      map(i)(0) = 1
      map(i)(6) = 1
    }

    //设置挡板
    map(3)(1) = 1
    map(3)(2) = 1
    map(1)(2) = 1
    map(2)(2) = 1

    //打印地图
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + " ")
      }
      println()
    }
    //测试方法
    setWay(map, 1, 1)

    println("新地图如下--:")
    //打印新地图
    println()
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + " ")
      }
      println()


    }

  }

  /**
   * 使用递归回溯来找路
   *
   * @param map 地图
   * @param i   指定从哪儿出发的横坐标
   * @param j   指定从哪儿出发的纵坐标
   *            约定:元素的值
   *            0: 可以走还没有走
   *            1 : 墙
   *            2: 表示可以走
   *            3 : 表示已经走过，但是是死路
   */
  def setWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
    if (map(6)(5) == 2) { //表示已经找到了.
      return true
    } else {
      if (map(i)(j) == 0) { //0 可以走还没走
        //这里开始递归回溯
        map(i)(j) = 2 //认为该点是可以走通的,但是不一定.
        if (setWay(map, i - 1, j)) { //上走
          return true
        } else if (setWay(map, i, j + 1)) { //右走
          return true
        } else if (setWay(map, i + 1, j)) { //下走
          return true
        } else if (setWay(map, i, j - 1)) { //左走
          return true
        } else { //走不通
          map(i)(j) = 3
          return false
        }
      } else { //不等于0 怎么算? 则 1,2,3
        return false
      }
    }
  }
}
