package com.ziyu.akka.ab

import akka.actor.{Actor, ActorRef}

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 11:50
 *
 */
class AActor(iBActor: ActorRef) extends Actor {

  val bActorRef = iBActor
  var count = 0

  override def receive: Receive = {
    case "start" => {
      println("AActor 启动!")
      println("start ok")
      println("I come")

      //发送给BActor
      bActorRef ! "我打"
    }
    case "我打" => {
      count += 1
      println(s"AActor(黄飞鸿) 挺猛 看我佛山无影脚 第${count}脚")
      Thread.sleep(1000)
      bActorRef ! "我打"
    }
  }
}
