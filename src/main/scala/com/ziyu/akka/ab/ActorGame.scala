package com.ziyu.akka.ab

import akka.actor.{ActorRef, ActorSystem, Props}

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 11:59
 *
 */
object ActorGame extends App {

  //1.ActorSystem
  val actorFactory = ActorSystem("actorFactory")

  //引用对象也就是邮箱口
  val bActorActorRef: ActorRef = actorFactory.actorOf(Props[BActor], "BActor")
  val aActorActorRef: ActorRef = actorFactory.actorOf(Props(new AActor(bActorActorRef)), "AActor")

  aActorActorRef ! "start"


}
