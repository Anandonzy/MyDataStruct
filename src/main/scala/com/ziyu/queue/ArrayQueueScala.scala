package com.ziyu.queue

/**
 *
 * @author wangziyu1
 * @date 2020-06-19 15:54
 *       队列的一些常用的方法
 */


class ArrayQueueScala(arrMaxSize: Int) {
  var maxSize = arrMaxSize
  var arr = new Array[Int](maxSize)
  var front = -1 //队列头 ,指向队列的前一个位置,不含队列头.
  var rear = -1 //队列尾 ,指向队列的最后一个数据,包含队列尾


  //判断队列是否为空
  def isEmpty(): Boolean = front == rear

  //判断队列是否满了
  def isFull(): Boolean = rear + 1 == maxSize

  //添加数据到队列
  def addQueue(n: Int): Unit = {
    if (isFull()) {
      println("队列为满了,不能插入了.退出~")
      return
    }

    //不满,则添加数据
    rear += 1
    arr(rear) = n
  }


  //显示队列的所有数据
  def showQueue(): Unit = {
    //判断队列是不是空的
    if (isEmpty()) {
      println("队列为空,退出~")
      return
    }

    for (i <- front + 1 to rear) {
      printf("arr[%d]=%d\n", i, arr(i))
    }
  }

  //出队
  def getQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列空~")
    }
    front += 1
    arr(front)
  }

  //查看当前的队列头
  def headQueue(): Any = {

    if (isEmpty()) {
      return new Exception("队列空~")
    }

    //这里要注意一下,不要改变队列的值,取出来即可.
    arr(front + 1)
  }

}
