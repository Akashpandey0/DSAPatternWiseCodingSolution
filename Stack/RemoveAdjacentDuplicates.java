// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
// We repeatedly make duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

// Example 1:
// Input: str = "abbaca"
// Output: "ca"
// Explanation:
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

// Example 2:
// Input: str = "azxxzy"
// Output: "ay"

// Constraints:
// 1 <= s.length <= 105
// s consists of lowercase English letters.

package Stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String str = "abbaca";
        String str1 = "azxxzy";

        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicates(str1));
    }

    public static String removeDuplicates(String str) {
        Stack<Character> st = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(st.size() > 0 && st.peek() == ch) st.pop();
            else st.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
}