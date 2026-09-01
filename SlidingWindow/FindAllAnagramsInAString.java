// Given two strings s and p, return an array of all the start indices of p's anagrams in s.
// You may return the answer in any order.

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

// Constraints:
// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.

package SlidingWindow;

import java.util.*;
import java.util.ArrayList;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

        System.out.println(findAllAnagramsInAString(s, p));
    }
    public static List<Integer> findAllAnagramsInAString(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        int k = p.length(), right = k;

        int sFreq[] = new int[26];
        int pFreq[] = new int[26];

        for(int i = 0; i < k; i++) {
            sFreq[s.charAt(i) - 'a']++;
            pFreq[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sFreq, pFreq)) result.add(0);

        for(right = k; right < s.length(); right++ ) {
            sFreq[s.charAt(right) - 'a']++;
            sFreq[s.charAt(right - k) - 'a']--;

            if(Arrays.equals(sFreq, pFreq)) result.add(right - k + 1);
        }

        return result;
    }
}
