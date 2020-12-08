package com.ziyu.test

/**
 *
 * @author wangziyu1
 * @date 2020-12-02 14:24
 *
 */
object ForTest {


  def main(args: Array[String]): Unit = {


    for (i <- Range(1, 5, 2)) {
      println("i = " + i)
    }
    println("-" * 20)
    for (i <- 1 to 5 by 2) {
      println("i = " + i)
    }
  }

}
