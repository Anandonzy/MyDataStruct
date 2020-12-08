package com.ziyu.collect

/**
 *
 * @author wangziyu1
 * @date 2020-12-02 15:29
 *
 */
object ScalaCollection {

  def main(args: Array[String]): Unit = {

    //定义数组
    val arr01 = new Array[Int](4)
    println(arr01.length)

    //数组赋值
    arr01(3) = 10
    val i = 10
    arr01(i / 3) = 20

    //（2.2）采用方法的形式修改数组的值
    arr01.update(0, 1)
    arr01.update(1, 2)

    println(arr01(0))
    println(arr01.mkString(","))
    var aa = arr01.mkString(",")
    println(aa)

    //普通遍历
    println()
    for (i <- arr01) {
      println(i)
    }

    //（3.3）简化遍历
    //    def printx(elem: Int): Unit = {
    //      println(elem)
    //    }
    //
    //    arr01.foreach(printx(_))

    //创建数组的另外一种方式
    val arr1 = Array(1, 2, 3, 4)
    val arr2 = Array(5, 6, 7, 8)
    val arr3 = arr1 :+ 5
    println(arr1 == arr3)

    val arr4: Array[Int] = arr1 ++: arr2
    val arr5: Array[Int] = arr1 ++ arr2
    println(arr4.foreach(println))
    println(arr5.foreach(println))


  }

}
