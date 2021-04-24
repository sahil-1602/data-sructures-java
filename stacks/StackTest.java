package stacks;

public class StackTest {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(8);
        stack.push(9);
        stack.push(10);

        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());

    }
}