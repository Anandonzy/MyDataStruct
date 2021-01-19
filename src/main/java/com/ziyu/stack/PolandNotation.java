package com.ziyu.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {

        //(30+4)*5-6
        String suffixExpresstion = "30 4 + 5 * 6 - "; //后缀表达式

        //1.扫描放到ArrayList里面
        List<String> list = getListString(suffixExpresstion);


        //2.将ArrayList传入方法里面，然后放入栈完成
        System.out.println(calc(list));


        /**
         * 中缀表达式转换后缀表达式
         * eg:
         * 1+((2+3)*4) -5 --> 后缀表达式
         * 思路：
         *  1.初始化两个栈，运算符栈s1，和中间结果（数字）的栈s2
         *  2.从左至有开始扫描中缀表达式
         *  3.遇到操作数的时候将其压入s2
         *  4.碰到运算符，比较s1的栈顶的运算符额优先级；
         *   4.1 如果s1为空，或者栈顶运算符为'（'，直接入栈
         *
         *  5.遇到括号
         *   5.1遇到左括号，直接入栈s1。。。。
         *
         *   1+（（2+3）*4）-5 --> 1 2 3 + 4 * + 5 1
         *   由于对str直接处理不方便，我们将其放到List里面
         */

        String middleExpresstion = "1+((2+3)*4)-5";
        List<String> list2 = middle2List(middleExpresstion); //中缀表达式 转成每一个字符处理
        System.out.println(list2);

        //3,中缀表达式转换后缀
        List<String> list3 = infix2shuffixExpresstion(list2);
        System.out.println(list3);
        System.out.println(middleExpresstion + "=" + calc(list3));

    }

    public static List<String> infix2shuffixExpresstion(List<String> infixList) {

        //定义两个栈
        Stack<String> s1 = new Stack<>(); //符号栈

        //因为s2 在整个栈中没有pop操作，所以，就将s2用list替代
//        Stack<String> s2 = new Stack<>();

        ArrayList<String> s2 = new ArrayList<>();

        //取出来每一个item
        for (String item : infixList) {
            if (item.matches("\\d+")) { //如果是数字
                s2.add(item);

            } else if (item.equals("(")) {
                //左括号直接入栈
                s1.push(item);
            } else if (item.equals(")")) {
                //右括号 去匹配找 左括号 依此弹出s1 压入s2中 ，只到遇到右括号
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //等于的时候就弹出右括号，就在符号栈里面消除一对儿括号了
            } else {
                //当item的优先级<= 符号栈s1栈顶的元素的优先级，这里需要一个比较优先级的方法
                while (s1.size() != 0 && Operation.getOperation(s1.peek()) >= Operation.getOperation(item)) {
                    s2.add(s1.pop());
                }
                //还需要将Item压入栈中
                s1.push(item);
            }

        }

        //将s1的元素加入到s2中即可
        while (s1.size() != 0) {

            s2.add(s1.pop());
        }

        return s2; //逆序输出的就是逆波兰表达式
    }

    public static List<String> middle2List(String middle) {
        ArrayList<String> ls = new ArrayList<>();

        int i = 0;
        String str = "";//对多位数进行拼接使用
        char c; //每遍历一个字符都放入c中
        do {
            if ((c = middle.charAt(i)) < 48 || (c = middle.charAt(i)) > 57) { //c是一个非数字
                ls.add("" + c);
                i++;
            } else { //考虑是多位数
                str = "";
                while (i < middle.length() && (c = middle.charAt(i)) >= 48 && (c = middle.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < middle.length());
        return ls;
    }

    public static List<String> getListString(String expression) {
        String[] split = expression.split(" ");

        ArrayList<String> list = new ArrayList();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calc(List<String> list) {
        Stack<String> stack = new Stack<String>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;

                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！");
                }
                stack.push("" + res);
            }

        }
        //最终留在栈里面的就是结果
        return Integer.parseInt(stack.pop());
    }
}

//返回运算符号的优先级 Operation返回对应符号的优先级！
class Operation {

    private static int ADD = 1;//+
    private static int SUB = 1;//-
    private static int MUL = 2;//*
    private static int DIV = 2;// chu

    public static int getOperation(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符！");
                break;
        }

        return result;
    }

}