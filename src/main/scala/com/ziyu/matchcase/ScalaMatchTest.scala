package com.ziyu.matchcase

/**
 *
 * @author wangziyu1
 * @date 2020-12-03 18:05
 *
 */
object ScalaMatchTest {
  def main(args: Array[String]): Unit = {

    var a: Int = 10
    var b: Int = 20
    var operator: Char = 'd'

    var result = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegal"
    }

    println(result)

    //匹配样例类
    val user = User("ziyu", 23)
    val userResult = user match {
      case User("ziyu", 23) => "yes"
      case _ => "No"
    }
    println(userResult)

    //变量声明
    val (x, y) = (1, 2)
    println(s"x=$x,y=$y")


  }

  //匹配常量
  def describle(x: Any) = x match {
    case i: Int => "Int five"
    case "hello" => "String hello"
    case true => "Boolean true"
    case '+' => "Char +"
  }
}

//样例类提供的了 并且伴生对象中自动提供了一些常用的方法，如apply、unapply、toString、equals、hashCode和copy。
case class User(name: String, age: Int)
