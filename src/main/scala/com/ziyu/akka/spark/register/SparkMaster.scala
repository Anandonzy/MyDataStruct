package com.ziyu.akka.spark.register

import akka.actor.Actor

import scala.collection.mutable

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 15:56
 *
 */
class SparkMaster extends Actor {

  //定义一个hashMap存放workers的信息
  val workers = mutable.HashMap[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => {
      println("spark master 启动, 在监听10000端口.")
    }

    case RegisterWorkerInfo(id, cpu, ram) => {
      //注册
      //先判断是否已经存在id
      if (!workers.contains(id)) {
        //创建WorkerInfo
        val workerInfo = new WorkerInfo(id, cpu, ram)
        workers += (id -> workerInfo)

        //回复成功.
        sender() ! RegisteredWorkerInfo
        println(s"workerId = $id 完成注册了~")
      }


    }


  }
}
