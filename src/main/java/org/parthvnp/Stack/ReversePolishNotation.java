package org.parthvnp.Stack;

import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens){
        Stack<String> operands = new Stack<>();
        Set<String> operators = Set.of("*", "-", "+", "/");
        for(var s: tokens){
            if (operators.contains(s)){
                var op1 = operands.pop();
                var op2 = operands.pop();
                operands.push(String.valueOf(applyOperation(op1, op2, s)));
            }else{
               operands.push(s);
            }
        }
        return Integer.parseInt(operands.peek());
    }

    public int applyOperation(String op1, String op2, String operator){
        if(operator == "*"){
            return Integer.parseInt(op1) * Integer.parseInt(op2);
        }else if(operator == "-"){
            return Integer.parseInt(op2) - Integer.parseInt(op1);
        }else if(operator == "+"){
            return Integer.parseInt(op1) + Integer.parseInt(op2);
        }else{
            return Integer.parseInt(op2) / Integer.parseInt(op1);
        }
    }

    public static void main(String[] args) {
        var rpn = new ReversePolishNotation();
        System.out.println(rpn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
