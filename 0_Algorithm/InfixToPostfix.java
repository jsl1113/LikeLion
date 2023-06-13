package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfix {
    // 연산자인지 검증하는 메소드
    private boolean isOperator(char token){
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    // 스택 내부에서의 우선순위
    private int inStackPriority(char operator){
        if(operator == '+' || operator == '-') return 1;
        else if(operator == '*' || operator == '/') return 2;
        else if(operator == '(') return 0; // 닫는 괄호가 나올 때까지 pop 되면 안됨
        else throw new IllegalArgumentException("Not Allowed Operator");
    }

    // 스택 외부에서의 우선순위
    private int inComingPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 3;
        else throw new IllegalArgumentException("not allowed argument");
    }

    public void Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 연산자 Stack
        Stack<Character> operStack = new Stack<>();

        // TODO 문자 단위로 순회
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // 연산자 (+, -, *, /, '(' ) 일 때
            if(isOperator(token)){
                // TODO 스택이 비어있다면 push
                if(operStack.empty()) operStack.push(token);
                else { // TODO 스택이 비어있지 않았다면,
                    // TODO 스택의 제일 위 연산자가 나보다 우선순위가 낮은 연산자가 올 때까지 pop
                    while(inStackPriority(operStack.peek()) >= inComingPriority(token)){
                        answerBuilder.append(operStack.pop());
                        // 순회 중, 스택이 빌 경우 반복 중단
                        if(operStack.empty()) break;
                    }
                    // TODO whilie 종료 후, push
                    operStack.push(token);
                }
            } else if(token == ')'){
                // TODO 스택에서 여는 괄호가 나올 때까지 pop
                char top = operStack.pop();
                while (top != '(') {
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            else answerBuilder.append(token);
        }
        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }
        System.out.println(answerBuilder);
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
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
    public static void main(String[] args) throws IOException {
        // 5+3*1+(4-9)*3 -> 531*+49-3*+
        new InfixToPostfix().solution();
    }
}
