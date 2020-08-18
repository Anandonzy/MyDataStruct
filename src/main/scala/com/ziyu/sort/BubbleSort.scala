package com.ziyu.sort

import java.text.SimpleDateFormat
import java.util.Date

/**
 *
 * @author wangziyu1
 * @date 2020-08-18 17:05
 *       冒泡排序
 */
object BubbleSort {

  def bubbleSort(arr: Array[Int]): Unit = {
    for (i <- 0 until arr.length - 1) {
      for (j <- 0 until arr.length - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    //数组
    val arr = Array(3, 9, -1, 10, 20)

    println("排序前")
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间=" + date) //输出时间

    println(arr.mkString(" "))
    println("排序后")
    bubbleSort(arr)
    println(arr.mkString(" "))
    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2) //输出时间
  }

}
