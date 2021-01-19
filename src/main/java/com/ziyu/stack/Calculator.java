package com.ziyu.stack;

/**
 * 用栈模拟计算器
 */
public class Calculator {
    public static void main(String[] args) {

        //模拟表达式的运算
        String exprition = "700+2*6-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义相关的变量
        int index = 0; //扫描我们的表达式
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' '; //扫描的oper
        String keepNum = ""; //用于拼接 多位数

        while (true) {
            //扫描exprition
            ch = exprition.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    //调整优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //弹栈，运算，入优先级小的，也就是当前的ch，保证栈顶是优先级高的先计算即可
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1, num2, oper);
                        //计算的新的放进去数字栈
                        numStack.push(res);

                        //当前的放进去
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //首次为空，直接入栈即可
                    operStack.push(ch);
                }
            } else {
//                numStack.push(ch - 48);//根据字符表来看，相差48

                //上面的只能处理各位数字，下面我们要处理多位数
                keepNum += ch; //拼接下一位

                if (index == exprition.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{

                    //判断keepNum下一位是不是数字
                    if (operStack.isOper(exprition.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //!!!!清空keepNum
                        keepNum = "";
                    }
                }


            }
            index++;
            if (index >= exprition.length()) {
                break;
            }
        }

        //入栈完成，开始计算
        while (true) {
            //如果符号栈为空，则就只有一个值了
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1, num2, oper);
            //计算的新的放进去数字栈
            numStack.push(res);
        }
        System.out.println("表达式为：" + exprition + "=" + numStack.pop());
    }
}

/**
 * 拓展一下当前栈的功能
 */
class ArrayStack2 {
    private int maxSize; //最大值
    private int[] stack; // 数组模拟栈，数据放到数组里面
    private int top = -1; //栈顶

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize]; //初始化我们的数组
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //判断是否满了，
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            throw new RuntimeException("栈空了");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈 必须从栈顶显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }

    }


    //返回运算符的优先级
    //我们约定数字越大，优先级越高

    public int priority(int oper) {

        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //满足就为true
    public boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public int calc(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) { //注意计算的顺序
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    /*

    返回栈顶元素
     */
    public int peek() {
        return stack[top];
    }

}