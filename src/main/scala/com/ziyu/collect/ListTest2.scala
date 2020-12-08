package com.ziyu.collect

/**
 *
 * @author wangziyu1
 * @date 2020-12-03 16:53
 *
 */
object ListTest2 {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4)
    val list1 = List(3, 4, 5, 6)
    //集合长度
    println("list size is : " + list.size)

    // 判断集合是否为空
    println("是否为空:" + list.isEmpty)

    // 集合迭代器
    println("iterator is" + list.iterator)
    // 循环遍历集合
    list.foreach(println)

    // 将集合转换为字符串
    println("转换为字符串:" + list.mkString(","))
    // 判断集合中是否包含某个元素
    println("是否包含2:" + list.contains(2))
    // 取集合的前几个元素
    println("前几个元素:" + list.take(3))
    // 取集合的后几个元素
    println("后几个元素:" + list.takeRight(3))

    // 查找元素
    println("查找元素:" + list.find(_ % 2 == 0))
    // 丢弃前几个元素
    println("丢弃前几个元素:" + list.drop(2))
    // 丢弃后几个元素
    println("丢弃后几个元素:" + list.dropRight(2))

    // 反转集合
    println("反转集合:" + list.reverse)

    // 去重
    println("去重:" + list.distinct)

    // 集合头
    println("head => " + list.head)
    // 集合尾
    println("tail => " + list.tail)
    // 集合尾迭代
    println("tails => " + list.tails)
    // 集合初始化
    println("init => " + list.init)
    // 集合初始化迭代
    println("inits => " + list.inits)
    // 集合最后元素
    println("last => " + list.last)
    // 集合并集
    println("union => " + list.union(list1))
    // 集合交集
    println("intersect => " + list.intersect(list1))
    // 集合差集
    println("diff => " + list.diff(list1))
    // 切分集合
    println("splitAt => " + list.splitAt(2))
    // 滚动
    println("sliding => " + list.sliding(2))
    // 滑动
    println("sliding => " + list.sliding(2, 2))
    // 拉链
    println("zip => " + list.zip(list1))
    // 数据索引拉链
    println("zipWithIndex => " + list.zipWithIndex)

    // 集合最小值
    println("min => " + list.min)
    // 集合最大值
    println("max => " + list.max)
    // 集合求和
    println("sum => " + list.sum)
    // 集合乘积
    println("product => " + list.product)
    // 集合简化规约
    println("reduce => " + list.reduce((x: Int, y: Int) => {
      x + y
    }))
    println("reduce => " + list.reduce((x, y) => {
      x + y
    }))
    println("reduce => " + list.reduce((x, y) => x + y))
    println("reduce => " + list.reduce(_ + _))
    //    // 集合简化规约(左)
    println("reduceLeft => " + list.reduceLeft(_ + _))
    //    // 集合简化规约(右)
    println("reduceRight => " + list.reduceRight(_ + _))
    //    // 集合折叠
    println("fold => " + list.fold(0)(_ + _))
    //    // 集合折叠(左)
    println("foldLeft => " + list.foldLeft(0)(_ + _))
    //    // 集合折叠(右)
    println("foldRight => " + list.foldRight(0)(_ + _))
    //    // 集合扫描
    println("scan => " + list.scan(0)(_ + _))
    //    // 集合扫描(左)
    println("scanLeft => " + list.scanLeft(0)(_ + _))
    //    // 集合扫描(右)
    println("scanRight => " + list.scanRight(0)(_ + _))

    //功能函数
    println("map=>" + list.map(_ * 2))

    //集合扁平化
    val flatList = List(List(1, 2), List(3, 4))
    println("flatten->" + flatList.flatten.foreach(println))

    //集合扁平映射
    println("flatMap->" + flatList.flatMap(list => list))

    //filter
    println("filter ->" + list.filter(_ % 2 == 0))

    //分组
    println("groupBy ->" + list.groupBy(_ % 2))


    //集合排序 (Ordering.Int.reverse) 倒序排序.
    println("sortBy ->" + list.sortBy(num => num)(Ordering.Int.reverse))

    println("sortWith ->" + list.sortWith((l, r) => {
      l > r
    }))

  }

}
