// Problem: Find Numbers with Even Number of Digits (LeetCode 1295)
// Difficulty: Easy
// Approach:Here I made a counter count to track how many numbers have even digits. For each number in the array,
// I converted it to a string, checked its length, and if the length was even, I increased the counter. In the end,
// count gives the total numbers with an even number of digits.

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}