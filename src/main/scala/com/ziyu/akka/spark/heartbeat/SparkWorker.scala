package com.ziyu.akka.spark.heartbeat

import java.util.UUID

import akka.actor.{Actor, ActorSelection}
import com.ziyu.akka.spark.register.{RegisterWorkerInfo, RegisteredWorkerInfo}

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 17:10
 *
 */
class SparkWorker extends Actor {
  var masterProxy: ActorSelection = _
  val id = UUID.randomUUID().toString

  override def receive: Receive = {

    case "start" => {
      println("spark worker 启动..")
      //发出注册的请求
      masterProxy ! RegisterWorkerInfo(id, 8, 8 * 1024)
    }
    case RegisteredWorkerInfo => {
      println(s"收到master 回复消息 workerid= $id 注册成功")
      //启动一个定时器.
      import context.dispatcher
      //说明
      //1.schedule 创建一个定时器
      //2.0 millis, 延时多久才执行, 0 表示不延时，立即执行
      //3. 3000 millis 表示每隔多长时间执行 3秒
      //4. self 给自己发送 消息
      //5. SendHeartBeat 消息
//      context.system.scheduler.schedule(0 millis, 3000 millis, self, SendHeartBeat)
    }
    case SendHeartBeat => {
      println(s"workerid= $id 发出心跳~")
      masterProxy ! SendHeartBeat(id)
    }

  }
}


