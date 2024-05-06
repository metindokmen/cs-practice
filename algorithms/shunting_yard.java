// The Shunting Yard algorithm is used to convert infix expressions (where operators are placed between operands) into postfix notation (operators follow their operands).
// It uses a stack to temporarily hold operators and performs a series of operations based on the precedence and associativity of operators.

// Imagine you're designing a calculator application where users can input mathematical expressions containing operators like `+`, `-`, `*`, `/`, and parantheses `(`,`)`.
// The Shunting Yard algorithm can be used to convert these infix expressions into postfix (Reverse Polish notation - RPN) format, which is easier to evaluate using a stack-based approach.

import java.util.*;

public class ShuntingYard {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> operators = new ArrayDeque<>();

        Map<Character, Integer> precedence = Map.of("+", 1, "-", 1, "*", 2, "/", 2);

        for (char c : infixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c); // Operand directly added to output
            } else if (c == "(") {
                operators.push(c); // Left paranthesis pushed onto stack
            } else if (c == ")") {
                // Pop operators from stack to output until '(' is encountered
                while (!operators.isEmpty() && operators.peek() != "(") {
                    postfix.append(operators.pop());
                }
                operators.pop(); // Remove "(" from stack
            } else {
                // Token is an operator
                while (!operators.isEmpty() && precedence.getOrDefault(c, 0) <= precedence.getOrDefault(operators.peek(), 0)) {
                    postfix.append(operators.pop());
                }
                operators.push(c); // Push current operator onto stack
            }
        }

        // Pop remaining operators from stack to output
        while (!operators.isEmpty()) {
            postfix.append(operators.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "3 + 4 * (2 - 1)";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix: " + infixExpression);
        System.out.println("Postfix: " + postfixExpression);
    }
}
