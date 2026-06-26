// Problem: Richest Customer Wealth (LeetCode 1672)
// Difficulty: Easy
// Approach: So here I first made a variable maxwealth to keep track of the richest customer.
// Then for each customer, I calculated their total wealth by summing all their accounts into currentwealth.
// Finally, I compared it with maxwealth and updated it if the current one was bigger — so in the end,
// maxwealth holds the maximum wealth among all customers.

class Solution {
    public int maximumWealth(int[][] accounts) {

        // Variable to store maximum wealth among all customers
        int maxwealth = 0;

        // Loop through each customer (each row in 2D array)
        for (int i = 0; i < accounts.length; i++) {

            // Variable to store current customer's total wealth
            int currentwealth = 0;

            // Loop through all bank accounts of current customer
            for (int j = 0; j < accounts[i].length; j++) {

                // Adding money from each account to current wealth
                currentwealth += accounts[i][j];
            }

            // Checking if current customer's wealth is greater than max
            if (currentwealth > maxwealth) {

                // Updating maximum wealth
                maxwealth = currentwealth;
            }
        }

        // Returning the richest customer's wealth
        return maxwealth;
    }
}