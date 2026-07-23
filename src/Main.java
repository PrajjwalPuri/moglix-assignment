/*
   Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
Example 1:Input: s = "(()"Output: 2Explanation: The longest valid parentheses substring is "()".
Example 2:Input: s = ")()())"Output: 4Explanation: The longest valid parentheses substring is "()()".
Example 3:Input: s = ""Output: 0
Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/

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