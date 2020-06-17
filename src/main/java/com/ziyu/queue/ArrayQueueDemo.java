package com.ziyu.queue;

import java.util.Scanner;

/**
 * @author wangziyu1
 * @date 2020-06-17 19:31
 * 队列: 先入先出即为队列.
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");

    }
}

/**
 * 使用数组模拟一个队列,编写一个 ArrayQueue
 */
class ArrayQueue {
    //表示数组的最大容量
    private int maxSize;
    //队列头 .  front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //队列尾 rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    private int rear;
    //该数据用于存储数据,模拟队列
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满了 当队列满时，条件是  (rear  + 1) % maxSize == front 【满】
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断对列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列里面
    public void addQueue(int n) {
        //先判断队列是否是满的
        if (isFull()) {
            System.out.println("队列已经满了~");
            return;
        }

        rear++; //让队尾后移
        arr[rear] = n;
    }

    //获取队列的数据,出队列
    public int getQueue() {
        //判断队列是不是空队列
        if (isEmpty()) {
            //抛异常告诉用户,队列为null
            throw new RuntimeException("队列是空的,无法取到值");
        }
        front++; //队头后移
        return arr[front];
    }

    //显示队列所有的数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            //抛异常告诉用户,队列为null
            throw new RuntimeException("队列是空的,无法取到值");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示头数据,但是不是取出来头数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列是空的,无法取到值");
        }
        return arr[front + 1];
    }


}
