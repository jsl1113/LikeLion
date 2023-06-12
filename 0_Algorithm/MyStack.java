public class MyStack {
    // 스택에 실제 데이터가 저장되는 곳
    private final int[] arr = new int[16];
    // 현재 스택의 최고점을 파악하기 위한 top
    private int top = -1;

    public MyStack() {
    }

    // push : 데이터를 스택의 제일 위에 넣는 메소드
    public void push(int data){
        if(arr.length-1 == top) throw new RuntimeException("stack is full");
        arr[++top] = data;
    }

    // pop : 데이터를 스택의 제일 위에서 회수하는 메소드
    public int pop(){
        if(top == -1) throw new RuntimeException("stack is empty");
        return arr[top--];
    }

    // peek : 제거 없이 스택의 제일 위 데이터를 리턴하는 메소드
    public int peek(){
        if(this.empty()) throw new RuntimeException("stack is empty");
        return arr[top];
    }

    public boolean empty(){
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack intStack = new MyStack();
        intStack.push(3);
        intStack.push(5);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.empty());
        System.out.println(intStack.peek());
        System.out.println(intStack.pop());
        System.out.println(intStack.empty());
    }
}
