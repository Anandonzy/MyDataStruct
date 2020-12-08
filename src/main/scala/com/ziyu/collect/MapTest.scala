package com.ziyu.collect

/**
 *
 * @author wangziyu1
 * @date 2020-12-03 15:25
 *
 */
object MapTest {

  def main(args: Array[String]): Unit = {

    val map1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = Map("d" -> 4, "e" -> 5, "f" -> 6)

    val map3 = map1 + ("d" -> 4)
    map1.foreach(println)
    map3.foreach(println)
    val map5: Map[String, Int] = map1 ++ map2 ++ map3
    println(map5 eq map1)
    println(map5.mkString(","))


    //基本操作

    val empty = Map.empty
    println(empty)

    //根据key取出来值
    println(map1.get("c"))
    println(map1.apply("c"))
    println(map1("c"))

    //获取可能存在的值
    val maybeInt = map1.get("c")
    if (!maybeInt.isEmpty) {
      //获取值
      println(maybeInt.get)
    } else {
      //如果不存在,获取默认值
      println(maybeInt.getOrElse(0))
    }
    //存在则获取,不存在,则使用默认值
    println(map1.getOrElse("3", 7))

    //to Set
    val set = map1.toSet
    set.foreach(println)

    //to List
    val list = map1.toList
    list.foreach(println)

    //to seq
    val seq = map1.toSeq
    seq.foreach(println)

    println("-" * 30)
    //to array
    val array = map1.toArray
    println(array.mkString(","))
  }

}
