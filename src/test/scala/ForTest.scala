/**
 *
 * @author wangziyu1
 * @date 2020-09-02 14:49
 *
 */
object ForTest {
  def main(args: Array[String]): Unit = {


    //集合进行遍历，使用循环守卫
    val list = List("bj", "tj", "sz")
    for (item <- list if item.startsWith("b")) {
      println("item=" + item)
    }

    for (i <- Range(1, 10, 3)) { //until
      println("i=" + i)
    }

    //灵活的使用守卫 [推荐]
    println("==========使用守卫控制步长==============")
    for (i <- 1 to 10 if i % 3 == 1) {
      println("i=" + i)
    }

    //斐波那契递归调用
    println(fin(4))

    //
    println(peach(1))

    println("*" * 20)
    var topic = "aa"

    topic match {
      case "aa" => "AA"
      case "bb" => "bb"
    }
    println(topic)
  }


  def fin(n: Int): Int = {
    if (n == 1) {
      3
    } else {
      var value = 2 * fin(n - 1) + 1 //7 +5 + 3
      value
    }
  }

  def peach(day: Int): Int = {

    if (day == 10) {
      1
    } else {
      (peach(day + 1) + 1) * 2
    }
  }


}
