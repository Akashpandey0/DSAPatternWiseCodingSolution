// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

// Constraints:

// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length

package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(longestRepeatingCharacterReplacement(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int left = 0, right;
        int maxLen = 0;
        int freq[] = new int [26];

        for(right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            int diff = (right - left + 1) - maxFreq(freq);
            while(diff > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                diff = (right - left + 1) - maxFreq(freq);
            }
            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            }
        }
        return maxLen;
    }

    private static int maxFreq(int [] freq) {
        int max = 0;
        for(int i = 0; i < freq.length; i++) {
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}
