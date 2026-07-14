class Solution {
    public int totalFruit(int[] fruits) {
        int[] counts = new int[fruits.length];
        int distinctFruits = 0;
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++){
            int rightFruit = fruits[right];

            if (counts[rightFruit] == 0){
                distinctFruits++;
            }
            counts[rightFruit]++;

            while (distinctFruits > 2){
            int leftFruit = fruits[left];

            counts[leftFruit]--;

            if (counts[leftFruit] == 0){
                distinctFruits--;
            }

            left++;
        }
             maxFruits = Math.max(maxFruits, right - left + 1);

        }
        return maxFruits;
    }
}