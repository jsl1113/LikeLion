import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest2 {
    public boolean Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);
            // 1. 여는 괄호 시, push
            if(next == '(' || next == '[' ||next == '{') {
                charStack.push(next);
            }
            else { // 2. 닫는 괄호 만날 경우
                // a. pop 할 게 없으면 스택이 비어있음 -> 검사 실패, false 리턴
                if(charStack.empty()) {
                    return false;
                }
                // b. 아니라면 pop
                char top = charStack.pop();
                // c. pop의 결과로 나온 값이 올바른 여는 괄호인지 확인
                if(next == ')' && top != '(') return false;
                if(next == ']' && top != '[') return false;
                if(next == '}' && top != '{') return false;
            }
        }
        // 3. 순회가 끝났을 때 스택이 비었는지 확인
        return charStack.empty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println((new ParTest2()).Solution());
    }
}
