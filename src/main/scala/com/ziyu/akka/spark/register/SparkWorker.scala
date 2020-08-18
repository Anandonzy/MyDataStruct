package com.ziyu.akka.spark.register

import java.util.UUID

import akka.actor.{Actor, ActorSelection}

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 16:50
 *
 */
class SparkWorker(masterHost: String, masterPort: Int) extends Actor {
  var masterProxy: ActorSelection = _
  val id = UUID.randomUUID().toString

  override def preStart(): Unit = {
    masterProxy = context.actorSelection(s"akka.tcp://SparkMaster@${masterHost}:${masterPort}/user/SparkMaster01")
  }

  override def receive: Receive = {
    case "start" => {
      println("spark worker 启动..")
      //发出注册表请求
      masterProxy ! RegisterWorkerInfo(id, 8, 8 * 1024)
    }
    case RegisteredWorkerInfo =>{
      println(s"收到master 回复消息 workerid= $id 注册成功")
    }

  }
}
