package com.ziyu.queue;

import java.util.Scanner;

/**
 * @author wangziyu1
 * @date 2020-06-20 10:09
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
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


class CircleArrayQueue {

    //最大容量
    private int maxSize;

    //队列头
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    private int front; //初始值为0

    //队列尾
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    private int rear;//初始值也为0

    //存储数据的数组
    private int arr[];

    //初始化队列.
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否满了 这里用了取模的一个小算法,当等于fron 的时候刚好队列满.
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已经满了,无法添加.");
            return;
        }
        //直接将数据加入
        arr[rear] = n;

        //将rear后移,这里一定要考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列,出队
    public int getQueue() {
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }

        //这里要分析 出front是指向队列的第一个元素.
        //1.先把front 的值保留到 一个临时变量里面
        //2.将front 向后移
        //3.将临时保留的值向后移即可.
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }

        //从front开始遍历,但是长度如何确定,这个需要考虑一下.

        for (int i = 0; i < front + size(); i++) {
            //有可能超过一圈,取模的话能找到下一圈的这个位置.
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列里面有效的个数
    public int size() {
        //rear = 2
        // front =1
        //maxSize =3
        return (rear + maxSize - front) % maxSize;
    }


    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }


}
