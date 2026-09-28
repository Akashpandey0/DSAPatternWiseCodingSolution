/*
You have a string and reverse the string
Input: Hello
Output: olleH
 */

package Stack;

import java.util.Stack;

public class ReverseString {
public static void main(String[] args) {
        String str = "hello";
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        while(!st.isEmpty()) System.out.print(st.pop());
    }
}
