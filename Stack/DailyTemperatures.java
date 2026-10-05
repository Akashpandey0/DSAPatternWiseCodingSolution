/*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100*/

package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int [] temperatures = {73,74,75,71,69,72,76,73};

        for(int num : dailyTemperatures(temperatures)) {
            System.out.print(num + " ");
        }
    }
    public static int [] dailyTemperatures(int [] temperatures) {
        int [] days = new int [temperatures.length];
        Stack<Integer> st = new Stack<>();
        days[temperatures.length - 1] = 0;
        st.push(temperatures.length - 1);

        for(int i = temperatures.length - 2; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) st.pop();

            if(st.isEmpty()) days[i] = 0;
            else days[i] = st.peek() - i;

            st.push(i);
        }
        return days;
    }
}
