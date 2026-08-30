// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest
//  substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1.

// Examples:

// Input: s = "aabacbebebe", k = 3
// Output: 7
// Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
// Input: s = "aaaa", k = 2
// Output: -1
// Explanation: There's no substring with 2 distinct characters.
// Input: s = "aabaaab", k = 2
// Output: 7
// Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

package SlidingWindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringwithKUniques {
    public static void main(String[] args) {
        String s = "aaaa";
        int k = 2;

        System.out.println(longestSubString(s, k));
    }

    public static int longestSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right;

        int maxLen = -1;

        for(right = 0; right < s.length(); right++) {
            char rCh = s.charAt(right);
            map.put(rCh, map.getOrDefault(rCh, 0) + 1);

            while(map.size() > k) {
                char lCh = s.charAt(left);
                map.put(lCh, map.get(lCh) - 1);
                if(map.get(lCh) == 0) {
                    map.remove(lCh);
                }
                left++;
            }
            if(map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
