package com.ziyu.test

/**
 *
 * @author wangziyu1
 * @date 2020-11-04 16:41
 *       高级函数测试
 */
object ScalaFunctionTest {

  def main(args: Array[String]): Unit = {

    def fun1(): String = {
      "zhangsan"
    }

    val a = fun1()
    val b = fun1()
    //函数作为值传递
    println(a)
    println(b)

    //函数作为参数传递
    def fun2(i: Int): Int = {
      i * 2
    }

    // Int => Int就是传递的函数.
    def fun22(f: Int => Int): Int = {
      f(10)
    }

    println(fun22(fun2))

    //函数作为返回值传递
    def fun3(i: Int): Int = {
      i * 2
    }

    def fun33() = {
      fun3 _
    }

    println(fun33()(10))

    //匿名函数
    def fun4(f: Int => Int): Int = {
      f(10)
    }

    println(fun4((x: Int) => {
      x * 20
    }))
    println(fun4(x => x * 20))
    println(fun4(_ * 20))


    //闭包
    def fun5() = {
      val i = 20

      def fun55() = {
        i * 20
      }

      fun55 _
    }
    println(fun5())

    //函数柯里化
    def fun6(i: Int)(j: Int) = {
      i * j
    }

    println(fun6(3)(2))

  }


}
