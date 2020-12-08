package com.ziyu.collect

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @author wangziyu1
 * @date 2020-12-02 16:52
 *
 */
object ArrayBufferTest {

  def main(args: Array[String]): Unit = {

    //可变数组
    val buffer = new ArrayBuffer[Int]
    buffer.append(1, 2, 3, 4)

    //修改
    //    buffer.update(0, 5)
    //
    //    //赋值
    //    buffer(1) = 6
    //
    //    //删除
    //    val i = buffer.remove(2)
    //    println(buffer(2))

    //循环集合
    for (i <- 0 to buffer.size - 1) {
      println(buffer(i))
    }

    for (i <- buffer) {
      println(i)
    }

    val buffer1 = ArrayBuffer(1, 2, 3, 4)
    val buffer2 = ArrayBuffer(5, 6, 7, 8)
    val buffer3: ArrayBuffer[Int] = buffer1 += 5 //由于是可变数组,原先的数组也改变了,改变之后赋值的.
    println(buffer1 eq buffer3) // true

    //使用++ 运算符产生新的集合数组
    val buffer4 = buffer1 ++ buffer2
    println( buffer1 eq buffer4 ) // false

    // 使用 ++= 运算符会更新之前的集合，不会产生新的数组
    val buffer5= buffer1 ++= buffer2

    println( buffer1 eq buffer4 ) // false
    println( buffer1 eq buffer5 ) // true



  }

}
