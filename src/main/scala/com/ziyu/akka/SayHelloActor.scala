package com.ziyu.akka

import akka.actor.{Actor, ActorSystem, Props}
/**
 *
 * @author wangziyu1
 * @date 2020-08-13 19:23
 *       当继承Actor之后,就有一个receive核心的方法重写即可.
 */
class SayHelloActor extends Actor {

  override def receive: Receive = {
    case "start" => println("actor 开始运行...")
    case "hello" => println("hello too:)")
    case "fish" => println("<・)))><< 鱼")
    case "cat" => println("(>^ω^<)喵..")
    //如何让actor停掉
    case "exit" => {
      println("准备退出~")
      context.stop(self) //停止当前的actor
      context.system.terminate() //停止ActorSystem
    }
  }
}
