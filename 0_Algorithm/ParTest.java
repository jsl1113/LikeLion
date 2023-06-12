import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest {
    public boolean Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);
            // 1. 여는 괄호 시 push
            if(next == '('){
                charStack.push(next);
            }
            // 2. 닫는 괄호인 경우
            else if(next == ')'){
                // a. pop할 게 없으면 실패
                if(charStack.empty()) return false;
                // b. 아니라면 pop
                char top = charStack.pop();
                // c. pop의 결과로 나온 값이 여는 괄호인 지 확인
                if(top != '(') return false;
            }
        }
        // 3. 순회가 끝났을 때 스택이 비었는지 확인
        return charStack.empty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println((new ParTest()).Solution());
    }
}
