package com.ziyu.akka.ab

import akka.actor.Actor

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 11:54
 *
 */
class BActor extends Actor {
  var count = 0

  override def receive: Receive = {
    case "我打" => {
      count += 1
      println(s"BActor(乔峰) 厉害 看我降龙十八掌 第${count}掌")
      Thread.sleep(1000)
      sender() ! "我打"
    }
  }
}
