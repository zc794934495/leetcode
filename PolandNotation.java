import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(suffixExpression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List=" + parseSuffixExpressionList);
        System.out.printf("expression=%d",calculate(parseSuffixExpressionList));
    }
    //将中缀表达式转后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>(); //符号栈
        List<String> s2 = new ArrayList<>();  //存放结果
        for(String item : ls) {
            if (item.matches("\\d+")) { //如果是数字直接加入结果
                s2.add(item);
            } else if (item.equals("(")) { //如果是左括号压入符号栈
                s1.push(item);
            } else if (item.equals(")")) { //如果是有括号，出栈顶元素加入结果直到遇到左括号，并让左括号出栈
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //左括号出栈
            } else {
                //符号栈不为空，并且当前操作符的优先级小于符号栈顶操作符的优先级时，出栈顶操作符加入结果，最后把当前操作符压入符号栈
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);//当前操作符压入符号栈
            }
        }
        //当符号栈不为空时，出栈顶操作符加入结果
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //将字符串表达式存入res
    public static List<String> toInfixExpressionList(String s){
        List<String> res = new ArrayList<>();
        int i = 0;
        String str;
        do{
            if((s.charAt(i) < 48) || (s.charAt(i) > 57)){ //当前字符不是数字时，加入res
                res.add(s.charAt(i) + "");
                i++;
            }else{
                str = "";
                //当前字符是数字，就拼接到str上，直到遇见操作符将str加入res
                while (i < s.length() && (s.charAt(i) >= 48) && (s.charAt(i) <= 57)){
                    str += s.charAt(i);
                    i++;
                }
                res.add(str);
            }
        }while (i < s.length());
        return res;
    }
    //计算后缀表达式
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for(String item : ls){
            if(item.matches("\\d+")){ //如果当前字符是数字，压入栈中
                stack.push(item);
            }else{//如果是操作符，出数字栈顶的两个数字进行运算，并将结果压入栈中
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                stack.push((res + ""));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
//返回操作符优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation) {
            case "+" : result = ADD;break;
            case "-" : result = SUB;break;
            case "*" : result = MUL;break;
            case "/" : result = DIV;break;
            default:
                break;
        }
        return result;
    }
}
