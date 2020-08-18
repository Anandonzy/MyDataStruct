package com.ziyu.recursion

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 17:37
 *       最简单的递归使用.
 *       递归的重要原则:
 *       1)	执行一个函数时，就创建一个新的受保护的独立空间(新函数栈)
 *       2)	函数的局部变量是独立的，不会相互影响
 *       3)	递归必须向退出递归的条件逼近，否则就是无限递归，死龟了:)
 *       4)	当一个函数执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当函数执行完毕或者返回时，该函数本身也会被系统销毁
 */
object RecursionDemo {

  def main(args: Array[String]): Unit = {
    test(4) //4
  }

  def test(i: Int): Unit = {
    if (i > 2) { // 4>2  3>2 2输出
      test(i - 1)
    } else {
      println("i=" + i)
    }
  }

}
