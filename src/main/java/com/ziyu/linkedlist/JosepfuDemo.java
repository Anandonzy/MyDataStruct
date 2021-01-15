package com.ziyu.linkedlist;

public class JosepfuDemo {

    public static void main(String[] args) {


        //测试一把，看看环形链表是否正确
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println();
        //小孩子出圈是否正确
        circleSingleLinkedList.countBoy2(1, 2, 5);


    }
}

class CircleSingleLinkedList {

    //创建一个First节点
    private Boy first = null;


    //添加小孩，构建环形链表
    public void addBoy(int nums) {
        //nums 校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        Boy currBoy = null; //辅助变量，帮助构建环形链表
        //for循环创建一个链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩，要特殊处理
            if (i == 1) {
                first = boy;
                first.next = first; //自己指向自己
                currBoy = first; //辅助变量指向第一个小孩子
            } else {
                currBoy.next = boy;
                boy.next = first;
                currBoy = boy;//curr 指向下一个新节点
            }
        }
    }


    public void showBoy() {
        //判断是不是为空
        if (first == null || first.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //first指针不能动记录第一个，需要一个辅助指针遍历
        Boy currBoy = first;

        while (true) {
            System.out.printf("小孩子的编号%d \n", currBoy.no);
            if (currBoy.next == first) {
                break;
            } else {
                currBoy = currBoy.next;
            }
        }
    }

    //根据用户的输入，计算出小孩子出圈的顺序

    /**
     * @param startNo  表示从第几个小孩子开始
     * @param countNum 表示数几下
     * @param nums     几个小孩子
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入有误");
            return;
        }

        //创建需要的辅助节点
        Boy helper = first;
        //确定第一个节点和最后一个节点
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        //小哈子报数前，先让first 和 helper 移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.next;
            helper = helper.next;
        }

        //出圈
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            //移动 m-1 次 first and helper 移动 countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            //此时的first节点就是要出圈的节点
            System.out.printf("小孩子的%d出圈\n", first.no);
            first = first.next;
            //指针移动跳过去出圈的小孩子
            helper.next = first;
        }

        System.out.printf("最终留在圈中的小孩子是%d\n", first.no);
    }

    /**
     * @param startNo  起始数字
     * @param countNum 步长 喊道几，几出圈
     * @param num      总共几个
     */
    public void countBoy2(int startNo, int countNum, int num) {

        if (first == null || startNo < 1 || startNo > num) {
            System.out.println("输入有误！");
            return;
        }

        //定义辅助节点helper
        Boy helper = first;

        //第一次遍历，找到helper的位置 helper 放到first之前。
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        //第一次helper和 first 都要移动 startNo-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.next;
            helper = helper.next;
        }

        //出圈，first 走在前面，helper走后面记录下次报数的位置
        while (true) {

            if (helper == first) {
                break; //最后一个
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println("这次出圈的数字为：" + first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.println("最后的幸运儿为：" + first.no);
    }

}

//创建boy类，表示节点
class Boy {
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}


