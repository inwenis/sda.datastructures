package stack;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        Optional<Integer> pop = stack.pop();
        System.out.println(pop.get());

        stack.push(5);
        System.out.println(stack.pop().get());

        stack.push(5);
        stack.push(10);
        System.out.println(stack.pop().get());
        System.out.println(stack.pop().get());
        Optional<Integer> num = stack.pop();
        Optional<Integer> num1 = stack.pop();
        System.out.println(num.isPresent() ? num.get() : "empty");
        System.out.println(num1.isPresent() ? num1.get() : "empty");

        stack.push(1);
        stack.push(10);
        stack.push(109);
        System.out.println(stack.pop().get());
        System.out.println(stack.pop().get());
        System.out.println(stack.pop().get());
        Optional<Integer> pop1 = stack.pop();
        System.out.println(pop1.isPresent() ? pop1.get() : "empty");

        // this is how we use Optional "functional way"
        System.out.println(stack.peek().orElse(-1));
        stack.push(5);
        System.out.println(stack.peek().orElse(-1));
        stack.push(10);
        System.out.println(stack.peek().orElse(-1));
        System.out.println(stack.pop().orElse(-1));
        System.out.println(stack.pop().orElse(-1));
        System.out.println(stack.pop().orElse(-1));
    }
}
