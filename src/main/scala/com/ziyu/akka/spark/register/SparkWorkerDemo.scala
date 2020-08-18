package com.ziyu.akka.spark.register

import akka.actor.{ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 16:56
 *
 */
object SparkWorkerDemo extends App {

  val (masterHost, masterPort, workerHost, workerPort) =
    ("127.0.0.1", 10000, "127.0.0.1", 10001)
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$workerHost
       |akka.remote.netty.tcp.port=$workerPort
       """.stripMargin)

  val sparkWorkerSystem = ActorSystem("SparkWorker", config)
  val sparkWorkerActorRef: ActorRef = sparkWorkerSystem.actorOf(Props(new SparkWorker(masterHost, masterPort)), "SparkWorker-01")

  sparkWorkerActorRef ! "start"

}
