package stack;

public class StackBahnhof {

    private Stack<String> s1;
    private Stack<String> s2;
    private Stack<String> s3;

    public StackBahnhof(Stack<String> s1, Stack<String> s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = new Stack<>();
    }

    public void sortBahnhof() {
        var nextElement = s1.top();
        while (!s1.isEmpty()) {
            while (nextElement != null && nextElement.equals("A")) {
                s3.push(s1.pop());
                nextElement = s1.top();
            }
            while (nextElement != null && nextElement.equals("B")) {
                s2.push(s1.pop());
                nextElement = s1.top();
            }
        }

        while (!s3.isEmpty()) {
            s1.push(s3.pop());
        }

        nextElement = s2.top();
        while (!s2.isEmpty()) {
            while (nextElement != null && nextElement.equals("A")) {
                s1.push(s2.pop());
                nextElement = s2.top();
            }
            while (nextElement != null && nextElement.equals("B")) {
                s3.push(s2.pop());
                nextElement = s2.top();
            }
        }

        while (!s3.isEmpty()) {
            s2.push(s3.pop());
        }

    }

    public Stack<String> getS1() {
        return s1;
    }

    public Stack<String> getS2() {
        return s2;
    }

    public Stack<String> getS3() {
        return s3;
    }

}
