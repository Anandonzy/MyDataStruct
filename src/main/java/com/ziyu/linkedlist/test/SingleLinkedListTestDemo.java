package com.ziyu.linkedlist.test;


import java.util.Stack;

public class SingleLinkedListTestDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");
        Node hero5 = new Node(4, "林冲2", "豹子头2");

        //创建链表
        SingleList singleLinkedList = new SingleList();
        //加入 √
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList.addByNumber(hero1);
        singleLinkedList.addByNumber(hero4);
        singleLinkedList.addByNumber(hero2);
        singleLinkedList.addByNumber(hero3);

        //展示链表 √
        System.out.println("--------------------------原始的链表--------------------------");
        singleLinkedList.update(hero5);
        singleLinkedList.delete(4); //删除节点测试。
        singleLinkedList.list();


        System.out.println("该链表的长度为：" + singleLinkedList.getLinkNodeCount(singleLinkedList.getHead()));
        System.out.println("倒数第二个：" + singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 2));
        System.out.println("反转之后的链表：");
        singleLinkedList.reverList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println("--------------");
        singleLinkedList.reverPrint(singleLinkedList.getHead());

    }


}

//定义单链表
class SingleList {

    //定一个头节点
    Node head = new Node(0, "", "");

    //返回头节点
    public Node getHead() {
        return head;
    }

    //添加节点
    public void add(Node node) {

        //引入一个辅助节点
        Node temp = head;

        while (true) {

            //当temp的下一个节点为空的时候，则退出
            if (temp.next == null) {
                break;
            }
            temp = temp.next;//链表后移动
        }
        //循环结束，将新节点放到尾部即可
        temp.next = node;
    }

    //按照编号添加,如果有这个排名，则是失败，没有的话，则找到合适的位置添加即可。
    public void addByNumber(Node node) {

        //由于头节点不能动，我们需要引入一个哨兵节点
        Node temp = head;
        boolean flag = false; //标示这个节点是否存在，如果存在，则为true，默认为flase
        while (true) {

            if (temp.next == null) { //到达了链表的尾部
                break;
            }

            //找到了，位置，添加即可。
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                System.out.println("编号已经存在了！");
                break;
            }
            temp = temp.next; //移动到下一个
        }
        if (flag) { //编号已经存在，则不需要添加了。
            System.out.println("编号已经存在了！，编号是：" + node.no);
            return;
        } else {
            //编号不存在，则需要添加即可 必须要新的节点指向我们temp.next 否则就会指向自己了。
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改节点，除编号之外的内容
    public void update(Node node) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        if (node == null) {
            System.out.println("新节点内容为空！");
            return;
        }

        Node temp = head;
        boolean flag = false;
        while (true) {

            //到达链表的尾部，退出即可。
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == node.no) {
                //找到了该节点的内容
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //找到该节点修改内容即可
            temp.next.name = node.name;
            temp.next.nickname = node.nickname;
        } else {
            //没找到要修改的节点
            System.out.println("没有找到要修改的节点的内容。");
            return;
        }
    }


    public void list() {


        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //添加一个辅助变量，遍历链表
        Node temp = head;


        while (true) {

            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     * 根据传递来的no删除该节点
     *
     * @param no
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("该链表为空！");
            return;
        }
        Node temp = head; //哨兵
        boolean flag = false; //默认没找到

        while (true) {

            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //找到了要删除的节点，删除即可
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该节点！");
            return;
        }

    }


    /**
     * 面试题01，求出来有效个数(不算头节点)
     *
     * @param head
     * @return
     */
    public int getLinkNodeCount(Node head) {
        if (head.next == null) {

            return 0;
        }

        int length = 0;
        Node current = head.next;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }


    /**
     * 返回链表第k个节点,即是index
     * 遍历链表得到链表的长度，然后length-index，就是第k个节点
     */
    public Node findLastIndexNode(Node head, int index) {
        if (head.next == null) {
            System.out.println("空链表！");
            return null;
        }

        Node cur = head.next;
        boolean flag = false;
        //第一次遍历得到长度
        int length = getLinkNodeCount(head);

        //第二次遍历，得到该节点，校验index
        if (index > length || index <= 0) {
            return null;
        }
        //长度为3， 找倒数第2个
        for (int i = 0; i < length - index; i++) {

            cur = cur.next;

        }
        return cur;

    }

    /**
     * 腾讯面试题，反转链表
     * 思路：
     * 1.定一个新的节点，newHead 初始化为新节点。
     * 2.从头到尾遍历原来的链表，每遍历一个节点，取出，放到新的链表的最前端。
     * 3.将原来的头节点next指向newHead的next即可。
     *
     * @param head
     */
    public void reverList(Node head) {

        if (head.next == null || head.next.next == null) {
            System.out.println("链表为空，不处理！");
            return;
        }

        Node curr = head.next; //哨兵节点
        Node newHead = new Node(0, "", ""); //新节点，存放
        Node next = null; //用于记录当前节点的下一个
        while (curr != null) {

            // head->1->2->3->4
            // cur = head.next =1
            // reverseHead-> -> ->
            next = curr.next; //记录当前节点的下一个 2
            curr.next = newHead.next; // 1next 区域执行新节点的头
            newHead.next = curr; //头指针指向当前的节点
            curr = next; //下移
        }
        //原来的head的next域指向newHead next域就完成了反转
        head.next = newHead.next;
    }

    /**
     * 逆序打印链表
     * 1.方式一：反转链表，打印，破坏原有的结构不可取
     * 2.方式二：利用栈进行打印，先进后出即可
     */


    public void reverPrint(Node head) {

        if (head == null || head.next == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();

        Node curr = head.next;
        while(curr!=null){
            nodeStack.push(curr); //入栈
            curr = curr.next;
        }

        while(!nodeStack.empty()){
            System.out.println(nodeStack.pop());
        }
    }

}


//定义每一个节点的属性 每一个node都是一个对象
class Node {


    public int no;
    public String name;
    public String nickname;
    public Node next;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}