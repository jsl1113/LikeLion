package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixCalculation {
    public void Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
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
        int result = digitStack.pop();
        if(digitStack.empty()) System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new PostfixCalculation().Solution();
    }

}
