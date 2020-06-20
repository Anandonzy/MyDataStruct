package com.ziyu.sparsearray

import scala.io.StdIn

/**
 *
 * @author wangziyu1
 * @date 2020-06-20 11:07
 * scala:环形对队列的实现方式.可以复用存储过的空间.
 */
object CircleArrayQueueScala {

  def main(args: Array[String]): Unit = {
    println("~~~环形队列的案例~~~")
    //初始化一个队列
    val queue = new CircleArrayScala(4)
    var key = ""
    while (true) {
      println("show: 表示显示队列")
      println("exit: 表示退出程序")
      println("add: 表示添加队列数据")
      println("get: 表示取出队列数据")
      println("head: 查看队列头的数据(不改变队列)")

      key = StdIn.readLine()
      key match {
        case "show" => queue.showQueue()
        case "add" => {
          println("请输入一个数")
          val value = StdIn.readInt()
          queue.addQueue(value)
        }
        case "get" => {
          val res = queue.getQueue()
          if (res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            println(s"取出数据是 $res")
          }
        }
        case "head" => {
          val res = queue.headQueue()
          if (res.isInstanceOf[Exception]) {
            //显示错误信息
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            println("队列头元素值为=" + res)
          }
        }
        case "exit" => System.exit(0)
      }
    }


  }
}

class CircleArrayScala(arrMaxSize: Int) {

  var maxsize = arrMaxSize
  var front = 0 //指向队列的头部
  var rear = 0 //指向队列的尾部 ,队尾空闲出来一个位置作为约定.
  var arr = new Array[Int](maxsize) //用于存储数据

  //判断队列是否为空 队头队尾指向了同一个地方才是为空队列.
  def isEmpty(): Boolean = {
    rear == front
  }

  //判断队列是否满了 约定的一个空闲的位置取模最大长度刚好等于队头,就是满队列.
  def isFull(): Boolean = {
    (rear + 1) % maxsize == front
  }

  //队列里面有效的数据
  def size(): Int = {
    (rear + maxsize - front) % maxsize
  }

  //队列头
  def getQueue(): Any = {
    if (isEmpty()) {
      throw new RuntimeException("队列为空,不能取出来值")
    }

    val value = arr(front)
    front = (front + 1) % maxsize
    value
  }

  //添加数据到队列里面.
  def addQueue(n: Int): Unit = {
    if (isFull()) {
      println("队列满了~")
      return
    }
    arr(rear) = n
    rear = (rear + 1) % maxsize
  }


  //显示队列里面所有的数据
  def showQueue(): Unit = {
    if (isEmpty()) throw new RuntimeException("队列为空,不能取出来值")

    for (i <- front until front + size()) {
      printf("add[%d]=%d\n", i % maxsize, arr(i % maxsize))
    }
  }

  def headQueue(): Any = {
    if (isEmpty())
      return new Exception("队列为空,不能取出来值")
    arr(front)
  }

}
