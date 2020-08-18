package com.ziyu.akka.spark.register

import akka.actor.{ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 16:37
 *
 */
object SparkMasterDemo extends App {
  val masterHost = "127.0.0.1"
  val masterPort = 10000

  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$masterHost
       |akka.remote.netty.tcp.port=$masterPort
       """.stripMargin)

  //创建ActorSystem
  //"SparkMaster"actorFactory 名字程序指定
  val sparkMasterActorSystem = ActorSystem("SparkMaster", config)

  //创建SparkMaster和引用
  val sparkMaster01Ref: ActorRef = sparkMasterActorSystem.actorOf(Props[SparkMaster], "SparkMaster01")

  sparkMaster01Ref ! "start"


}
