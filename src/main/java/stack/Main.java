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
    }
}
