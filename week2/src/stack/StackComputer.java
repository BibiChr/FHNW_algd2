package stack;

import java.io.IOException;

public class StackComputer {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.print("Enter your sequence:");

        try {
            boolean run = true;
            String inputString = "";
            while (run) {
                int inputByte = System.in.read();

                if (inputByte == 32 || inputByte == 10) {
                    if (isNumber(inputString)) {
                        stack.push(Integer.parseInt(inputString));
                    } else {
                        var elementLast = stack.pop();
                        var elementBefore = stack.pop();
                        if (inputString.equals("+")) {
                            stack.push(elementBefore + elementLast);
                        }
                        if (inputString.equals("-")) {
                            stack.push(elementBefore - elementLast);
                        }
                        if (inputString.equals("/")) {
                            stack.push(elementBefore / elementLast);
                        }
                        if (inputString.equals("*")) {
                            stack.push(elementBefore * elementLast);
                        }
                    }
                    inputString = "";
                    if (inputByte == 10) {
                        run = false;
                    }
                } else {
                    if (isNumberOrMathSign((char) inputByte)) {
                        inputString += (char) inputByte;
                    }
                }
            }
            System.out.println("The result is " + stack.pop());
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
            e.printStackTrace();
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isNumberOrMathSign(char c) {
        return switch (c) {
            case '+', '-', '*', '/' -> true;
            default -> Character.isDigit(c);
        };

    }

}
