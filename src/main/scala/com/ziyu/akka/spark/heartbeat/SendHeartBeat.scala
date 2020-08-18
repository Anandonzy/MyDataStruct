package com.ziyu.akka.spark.heartbeat

/**
 *
 * @author wangziyu1
 * @date 2020-08-14 17:08
 *
 */
//worker 在注册成功之后,通过定时器,每隔3s发送一个消息给自己
case object SendHeartBeat

//给master的HeartBeat
case class SendHeartBeat(id: String)

