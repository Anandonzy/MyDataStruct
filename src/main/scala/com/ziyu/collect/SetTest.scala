package com.ziyu.collect

import scala.collection.mutable

/**
 *
 * @author wangziyu1
 * @date 2020-12-03 14:29
 *
 */
object SetTest {

  def main(args: Array[String]): Unit = {

    val set1 = Set(1, 2, 3, 9)
    println(set1.foreach(println))

    val set2 = Set(5, 6, 7, 8)
    val set3 = set1 + 5 + 6
    val set4 = set1 + (5, 6, 7)

    println(set1 eq (set3))
    println(set2 eq (set4))
    val set5 = set1 - 1 - 9
    set5.foreach(println)

    //可变集合
    val mset1 = mutable.Set(1, 2, 3, 4)
    val mset2 = mutable.Set(5, 6, 7, 8)
    val value = mset1.add(8)
    println("'" * 40)
    mset1.foreach(println)


  }

}
