package com.ziyu.queue

/**
 *
 * @author wangziyu1
 * @date 2020-06-19 15:48
 *       队列的特点: front(队列头,不含) rear(队列尾,含队尾) maxSize(队列最大的长度.)
 *  1.先进先出
 *  2.满队列 rear+1 =maxSize
 *  3.空队列 front == rear
 *  4.添加数据的时候 rear+1 向后移.
 *
 */

import scala.io.StdIn

object ArrayQueueDemoScala {

  def main(args: Array[String]): Unit = {

    //初始化队列
    //初始化一个队列
    val queue = new ArrayQueueScala(3)
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
