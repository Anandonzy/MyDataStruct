package com.ziyu.linkedlist;

public class DoubleLinkedListDemo {


    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(4, "林冲2", "豹子头2");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        System.out.println("-----");
        doubleLinkedList.update(hero5);
        doubleLinkedList.list();

        doubleLinkedList.delete(4);
        System.out.println("-----");
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {
    //初始化头结点,不存数据
    HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }


    //遍历链表的节点的信息
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        //节点本身
        HeroNode2 temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            temp = temp.next;
        }
    }


    //添加节点 双向链表的尾部
    public void add(HeroNode2 node) {

        //引入一个辅助节点
        HeroNode2 temp = head;

        while (true) {

            //当temp的下一个节点为空的时候，则退出
            if (temp.next == null) {
                break;
            }
            temp = temp.next;//链表后移动
        }
        //循环结束，将新节点放到尾部即可
        temp.next = node;
        node.pre = temp;
    }


    //修改节点，除编号之外的内容
    public void update(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        if (node == null) {
            System.out.println("新节点内容为空！");
            return;
        }

        HeroNode2 temp = head;
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
            temp.next.nikename = node.nikename;
        } else {
            //没找到要修改的节点
            System.out.println("没有找到要修改的节点的内容。");
            return;
        }
    }

    /**
     * 双链表可以找到自己的这个节点，然后删除即可。
     *
     * @param no
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("该链表为空！，无法删除");
            return;
        }

        HeroNode2 curr = head.next; //哨兵
        boolean flag = false; //默认没找到

        while (true) {
            if (curr == null) {
                break;
            }
            if (curr.no == no) {
                flag = true;
                break;
            }
            curr = curr.next;
        }

        if (flag) {
            //找到了要删除的节点，删除即可
            curr.pre.next = curr.next;

            //代码有风险，如果删除的是最后一个节点就是 curr.next = null
            if (curr.next != null) {
                curr.next.pre = curr.pre;
            }
        } else {
            System.out.println("没有找到该节点！");
            return;
        }

    }


}

class HeroNode2 {

    public int no;
    public String name;
    public String nikename;
    public HeroNode2 next; //默认为null
    public HeroNode2 pre; //默认为null

    public HeroNode2(int no, String name, String nikename) {
        this.no = no;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }

}