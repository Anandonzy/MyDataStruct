package com.ziyu.sort

import java.text.SimpleDateFormat
import java.util.Date

import com.ziyu.sort.BubbleSort.bubbleSort

/**
 *
 * @author wangziyu1
 * @date 2020-08-18 17:45
 *       选择排序
 */
object SelectSort {

  def selectSort(arr: Array[Int]): Unit = {

    for (i <- 0 until arr.length - 1) {
      //取出来小的
      var min = arr(i)
      var minIndex = i

      for (j <- (i + 1) until arr.length) {
        if (min > arr(j)) { //如果有小的,赋值给新的小的值,并且记录新的minIndex值
          min = arr(j)
          minIndex = j
        }
      }
      //判断是否需要交换
      if (minIndex != i) {
        arr(minIndex) = arr(i)
        arr(i) = min
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
    selectSort(arr)
    println(arr.mkString(" "))
    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2) //输出时间

  }

}
