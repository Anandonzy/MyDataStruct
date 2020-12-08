package com.ziyu.collect

import scala.collection.mutable

/**
 *
 * @author wangziyu1
 * @date 2020-12-03 15:58
 *
 */
object OtherTest {

  def main(args: Array[String]): Unit = {


    //元组
    val tup = (1, "zhangsan", 30)
    println(tup._1)
    println(tup._2)
    println(tup._3)

    //元组迭代器
    val it = tup.productIterator

    //根据索引访问元素
    println(tup.productElement(1))

    //如果元组只有两个元素,我们称之为对偶元组,也称之为键值对
    val kv: (String, Int) = ("a", 1)
    val kv1: (String, Int) = "a" -> 1
    println(kv eq kv1)

    //队列
    val queue = new mutable.Queue[String]()
    //添加元素
    queue.enqueue("a", "b", "c")

    val queue1 = queue += "d"
    println(queue eq queue1)

    //获取元素
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    //并行
    val result1 = (0 to 100).map { x => Thread.currentThread().getName }
    val result2 = (0 to 100).par.map { x => Thread.currentThread().getName }
    println(result1)
    println(result2)

  }

}
