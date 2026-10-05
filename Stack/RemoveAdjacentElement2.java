/*You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:
1 <= s.length <= 105
2 <= k <= 104
s only contains lowercase English letters.*/

package Stack;

import java.util.ArrayDeque;

public class RemoveAdjacentElement2 {
    static record Pair<K, V>(K key, V value){}
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "deeedbbcccbdaa";
        String str3 = "pbbcggttciiippooaais";

        System.out.println(removeAdjacentElement2(str1, 2));
        System.out.println(removeAdjacentElement2(str2, 3));
        System.out.println(removeAdjacentElement2(str3, 2));
    }

    public static String removeAdjacentElement2(String str, int k) {
        ArrayDeque<Pair<Character, Integer>> st = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(st.isEmpty()) {
                st.push(new Pair(ch, 1));
                continue;
            }
            if(st.peek().key != ch) {
                st.push(new Pair(ch, 1));
                continue;
            }
            if(st.peek().value < k - 1) {
                Pair<Character, Integer> top = st.pop();
                st.push(new Pair(top.key, top.value + 1));
                continue;
            }
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            Pair<Character, Integer> top = st.pop();
            int value = top.value;
            while(value > 0) {
                sb.append(top.key);
                value--;
            }
        }
        return sb.reverse().toString();
    }
}
