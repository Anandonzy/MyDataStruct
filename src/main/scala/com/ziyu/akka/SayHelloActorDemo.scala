package com.ziyu.akka

import akka.actor.{ActorSystem, Props}

/**
 *
 * @author wangziyu1
 * @date 2020-08-13 19:42
 *
 */
object SayHelloActorDemo {

  def main(args: Array[String]): Unit = {
    //1.创建一个ActorSystem
    val actorFactory = ActorSystem("actorFactory")

    //2.通过actorFactory 创建需要的actor

    //说明
    //1.SayHelloActor 这个名字是actor的名字,有程序员指定
    //2.Props[SqyHelloActor] 是使用了反射机制创建SayHelloActor的实例.
    //3.sayHelloActorRef :是创建的SayHelloActor 的引用,代理Proxy

    val sayHelloActorRef = actorFactory.actorOf(Props[SayHelloActor], "SayHelloActor")
    sayHelloActorRef ! "start"
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "fish"
    sayHelloActorRef ! "cat"
    sayHelloActorRef ! "exit"

  }

}
