package com.ziyu.linkedlist;

import java.util.Stack;

/**
 * @author wangziyu1
 * @date 2020-06-20 15:31
 */
public class SingleLinkedListDemo {


    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入 √
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //展示链表 √
        singleLinkedList.list();

        //修改 √
        System.out.println("--------------------------修改之后的--------------------------");
        HeroNode newNode = new HeroNode(1, "aa", "aa");
        singleLinkedList.update(newNode);
        singleLinkedList.list();


        //删除 节点1
        System.out.println("--------------------------删除之后的--------------------------");
        singleLinkedList.delete(1);
        singleLinkedList.list();

        //头结点
        System.out.println("当前的头结点是:" + singleLinkedList.getHead());

        //根据加入的节点进行排序.
        //创建可以排序的链表
        System.out.println("--------------------------排序之后的链表--------------------------");
        HeroNode hero5 = new HeroNode(1, "55", "55");
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.list();

        //翻转链表
        System.out.println("--------------------------翻转之后的链表--------------------------");
        singleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();

        //利用栈的数据结构反转链表
        System.out.println("--------------------------利用栈的数据结构反转链表之后的链表--------------------------");

        singleLinkedList.reversePrint(singleLinkedList.getHead());

    }
}

//定义单链表.
class SingleLinkedList {

    //初始化头结点,不存数据
    HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //添加结点
    public void add(HeroNode node) {
        //由于我们的head结点不能动,我们需要引入一个辅助结点temp
        HeroNode temp = head;

        //遍历链表
        while (true) {
            //找到链表的尾部,加上即可
            if (temp.next == null) {
                break;
            }
            //后移temp结点直到找到最后一个.
            temp = temp.next;
        }
        //找到最后一个节点之后,将node接上即可.
        temp.next = node;
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        //判断链表是不是空链表
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        HeroNode temp = head.next; //就代表改节点
        boolean flag = false; //默认没有找到

        while (true) {

            //满足条件则找到该节点
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;//找到该节点,退出
            }
            //没找到则向后走一步
            temp = temp.next;
        }

        //修改节点信息
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //根据编号删除节点信息
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        //节点本身
        HeroNode temp = head;
        boolean flag = false;//默认没有找到

        while (true) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //找到了删除即可.
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", no);
        }

    }

    //遍历链表的节点的信息
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        //节点本身
        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode newNode) {

        //临时头结点 因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {//已经到了链表的尾部
                break;
            }

            //从小到大排序
            if (temp.next.no > newNode.no) {
                //找到了temp 的位置
                break;
            } else if (temp.next.no == newNode.no) {
                flag = true;//期望添加的节点已经存在了.
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("想要添加的节点编号: %d已经存在\n", newNode.no);

        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    //将单链表反转
    //思路: 借助一个新的节点,和一个next节点,
    public void reversetList(HeroNode head) {

        //判断是否为空
        if (head.next == null || head.next.next == null) {
            System.out.printf("链表为空,不用反转~");
            return;
        }

        //创建一个新的头结点,用于存老链表的节点数据.
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null; //用于记录cur的下一个节点.

        //遍历原先的链表,取出来每一个,放到新的newHead前面即可.
        while (cur != null) {
            // head->1->2->3->4
            // cur = head.next =1
            // reverseHead-> -> ->
            next = cur.next;//暂时保存当前节点的cur 的下一个. next = 2
            cur.next = reverseHead.next; // 1的next -> reverseHead.next 存数据的第一个
            reverseHead.next = cur; //将新的头结点指向当前节点 reverseHead第一个存数据的的节点放cur =1 节点
            cur = next; //cur向后移即可.
        }

        //最后将head.next 指向reverseHeadn.next就实现了翻转
        head.next = reverseHead.next;
    }

    //方式2,链表反转,利用栈的数据结构进行操作.由于栈是先进后出的特性,可以完成我们的预期操作.
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.printf("链表为空,无需反转~");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode cur = head.next; //当前节点
        while (cur != null) {
            stack.push(cur);//入栈
            cur = cur.next; //后移
        }

        //将栈中的内容打印出来即可
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


}


//定义Node 属性信息
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
