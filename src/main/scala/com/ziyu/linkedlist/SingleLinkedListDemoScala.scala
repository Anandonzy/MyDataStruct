package com.ziyu.linkedlist

/**
 *
 * @author wangziyu1
 * @date 2020-07-08 19:39
 *
 */

import util.control.Breaks._

object SingleLinkedListDemoScala {


  def main(args: Array[String]): Unit = {


  }

}

//创建一个链表.
class HeroNodeListScala {
  //创建一个头结点
  private val head = new HeroNodeScala(0, "", "")

  //返回头结点
  def getHead: HeroNodeScala = head

  //删除节点
  /**
   * 思路:
   * 1.head 节点不能动
   * 2.使用变量temp,我们要删除的应该是temp 的下一个节点,也就是说我们在比较的时候应嘎是temp.next才对.
   *
   * @param no
   */
  def del(no: Int): Unit = {
    var temp = head
    var flag = false //标志变量用于判断是否有要删除的节点.
    breakable {
      while (true) {
        if (head == null) {
          break()
        }
        if (temp.next.no == no) {
          //找到了
          flag = true
          break()
        }
        temp = temp.next //往后移动
      }
    }

    if (flag) {
      //找到了,可以删除.
      temp.next = temp.next.next
    } else {
      printf("要删除的%d 不存在.\n ", no)
    }
  }

  //添加
  def add(node: HeroNodeScala): Unit = {



  }

}

//创建HeroNode 节点的类存储节点的信息.
class HeroNodeScala(hNo: Int, hName: String, hNickname: String) {
  var no: Int = hNo
  var name: String = hName
  var nickName: String = hNickname
  var next: HeroNodeScala = null //next 默认为null
}
