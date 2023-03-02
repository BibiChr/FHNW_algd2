package stack;

import org.junit.Assert;
import org.junit.Test;

public class StackBahnhofTest {

    @Test
    public void testSortBahnhof() {
        Stack<String> stack1 = setUpStack1();
        Stack<String> stack2 = setUpStack2();
        StackBahnhof bahnhof = new StackBahnhof(stack1, stack2);
        bahnhof.sortBahnhof();
        Stack<String> s1 = bahnhof.getS1();
        Stack<String> s2 = bahnhof.getS2();
        Stack<String> s3 = bahnhof.getS3();

        Assert.assertTrue(s3.isEmpty());
        Assert.assertFalse(s1.isEmpty());
        Assert.assertFalse(s2.isEmpty());

        String firstElementOfS2 = s2.top();
        String currentElementOfS2 = s2.pop();


        while (currentElementOfS2 != null) {
            Assert.assertEquals(currentElementOfS2, firstElementOfS2);
            currentElementOfS2 = s2.pop();
        }

        String firstElementOfS3 = s3.pop();
        String currentElementOfS3 = s3.pop();

        while (currentElementOfS3 != null) {
            Assert.assertEquals(currentElementOfS3, firstElementOfS3);
            currentElementOfS3 = s2.pop();
        }
    }

    private Stack<String> setUpStack1() {
        Stack<String> stack2 = new Stack<>();
        stack2.push("A");
        stack2.push("B");
        stack2.push("A");
        return stack2;
    }

    private Stack<String> setUpStack2() {
        Stack<String> stack2 = new Stack<>();
        stack2.push("B");
        stack2.push("A");
        stack2.push("B");
        return stack2;
    }

}