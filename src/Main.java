import com.sun.jdi.IntegerValue;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(longestValidParenthesis(str));
    }

    public static int longestValidParenthesis(String str) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] arr = str.toCharArray();
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            char ch = arr[i];

            if(ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i-stack.peek());
                }
            }
        }

        return max;

    }
}