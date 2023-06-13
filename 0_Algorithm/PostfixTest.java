package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixTest {
    public String InfixToPostfix(String input) {
        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 연산자 Stack
        Stack<Character> operStack = new Stack<>();
        // TODO 문자 단위로 순회
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // 연산자 (+, -, *, /, '(' ) 일 때
            if(token == '(') {
                operStack.push(token);
            }
            // TODO 스택의 제일 위 연산자가 나보다 우선순위가 낮은 연산자가 올 때까지 pop
            else if(token == '*' || token == '/') {
                while(!operStack.empty() && (operStack.peek() == '*' || operStack.peek() == '/'))
                    answerBuilder.append(operStack.pop());
                operStack.push(token);
            }
            else if(token == '+' || token == '-'){
                while(!operStack.empty() && operStack.peek() != '(')
                    answerBuilder.append(operStack.pop());
                operStack.push(token);
            }
            else if(token == ')'){
                char top = operStack.pop();
                while(!operStack.empty() && top != '('){
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            else answerBuilder.append(token);
        }
        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }
//        System.out.println(answerBuilder);
        return answerBuilder.toString();
    }

    public int PostfixCalculation(String input) {
        Stack<Integer> digitStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // TODO 1. 숫자면, 스택에 push
            // Character.isDigit(token) -> token 이 숫자가 표현된 글자인지 판단하는 메소드
            if(Character.isDigit(token)){
                // token을 int로 변환 -> token - '0'
//                digitStack.push(token - '0');
                digitStack.push(Character.digit(token, 10));
            }
            else { // TODO 2. 연산자면, 스택에서 두 번 pop 하여 계산
                int b = digitStack.pop();
                int a = digitStack.pop();

                switch (token){
                    case '+' -> digitStack.push(a+b);
                    case '-' -> digitStack.push(a-b);
                    case '*' -> digitStack.push(a*b);
                    case '/' -> digitStack.push(a/b);
                    default -> throw new IllegalArgumentException("Invalid Operator");
                }
            }
        }
        return digitStack.pop();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("중위 표기법 : " + input);
        String postfix = new PostfixTest().InfixToPostfix(input);
        System.out.println("후위 표기법 : " + postfix);
        int result = new PostfixTest().PostfixCalculation(postfix);
        System.out.println("수식 계산 결과 : " + result);
    }
}
