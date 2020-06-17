package com.ziyu.sparsearray

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @author wangziyu1
 * @date 2020-06-17 17:23
 *       scala版本的二维数组转换成稀疏数组
 *       二维数组 转 稀疏数组的思路
 *       主要思想就是将多余的0不进行记录,将有值的地方记录行竖坐标即可.
 *  1. 遍历原始的二维数组，得到有效数据的个数 sum
 *  2. 根据 sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
 *  3. 将二维数组的有效数据数据存入到 稀疏数组
 *
 *       原先的数组
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 1 0 0 0 0 0 0 0 0
 *       0 0 0 2 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       0 0 0 0 0 0 0 0 0 0 0
 *       稀疏数组: 第一行记录原先的数组有多少行有多少列.
 *       row   col   val
 *       0     11      11    2
 *       1      1       2     1
 *       2      2       3     2
 *
 */
object SparseArrayScala {

  def main(args: Array[String]): Unit = {
    val rowSize = 11
    val colSize = 11

    //稀疏矩阵的使用
    val chessMap = Array.ofDim[Int](rowSize, colSize)
    chessMap(1)(2) = 1
    chessMap(2)(3) = 2
    chessMap(4)(5) = 2

    println("原始数组~~")
    //输出原始数组
    for (items <- chessMap) {
      for (item <- items) {
        printf("%d\t", item)
      }
      println()
    }

    //转换稀疏数组
    //1.获取有用的值
    var sum: Int = 0
    for (items <- chessMap) {
      for (item <- items) {
        if (item != 0)
          sum += 1
      }
      println()
    }

    //由于要保留第一行,所以行数要+1
    /* val sparseArray = Array.ofDim[Int](sum + 1, 3)
     sparseArray(0)(0) = chessMap.length
     sparseArray(0)(1) = chessMap.length
     sparseArray(0)(2) = sum*/

    val arrayBuffer = ArrayBuffer[Node]()
    val head = new Node(rowSize, colSize, sum)
    arrayBuffer.append(head)
    //遍历之前的数组,放到稀疏数组里面
    //ArrayBuffer
    for (i <- 0 until chessMap.length) {
      for (j <- 0 until chessMap(i).length) {
        if (chessMap(i)(j) != 0) {
          val node = new Node(i, j, chessMap(i)(j))
          arrayBuffer.append(node) //加入到稀疏矩阵里面.
        }
      }
    }

    println("输出稀疏矩阵:")
    for (node <- arrayBuffer) {
      printf("%d\t%d\t%d\n", node.row, node.col, node.value)
    }
  }

}

class Node(val row: Int, val col: Int, val value: Int)
