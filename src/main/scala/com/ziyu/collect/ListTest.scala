package com.ziyu.collect

import scala.collection.Seq
import scala.collection.mutable.ListBuffer

/**
 *
 * @author wangziyu1
 * @date 2020-12-02 17:15
 *
 */
object ListTest {
  def main(args: Array[String]): Unit = {

    //Seq集合. 不可变list
    val list = List(1, 2, 3, 4)
    val list1 = list :+ 1 //加到后面
    val list2 = 1 +: list //加到前面.
    println(list1.foreach(println))
    println(list2.foreach(println))
    println(list1 eq list) //false

    val list3 = list.updated(1, 5)
    println(list3.foreach(println))
    println(list3.map(_ * 2).foreach(println))

    val list4 = 1 :: 2 :: 3 :: Nil
    val nil = Nil
    println(list4 eq nil)

    val buffer1 =ListBuffer(1,2,3,4)
    val buffer2 = ListBuffer(5,6,7,8)

    //增加数据.



  }

}
