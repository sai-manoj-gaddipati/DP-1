// Time complexity: O(m*n) where m is the number of coins and n is the amount
// Space Complexity: O(m*n)
// Algorithm summary: dynamic programming to calculate minimum number of coins, coins as row and amount as column values. 
class Solution {
    public int coinChange(int[] coins, int amount) {
        //loop through m*n m-->coins, n--> amount

        int[][] matrix = new int[coins.length+1][amount+1];    
        for (int k = 1; k <= amount; k++){
            matrix[0][k] = amount+1;
        }

        for(int i=1; i <= coins.length; i++){
            for (int j=1; j<= amount; j++){
                //base case?
                
                if (j-coins[i-1] >= 0){ //chose case
                    
                    matrix[i][j] = Math.min(matrix[i-1][j], 1+matrix[i][j-coins[i-1]]);
                }
                else{ //no choose case
                    matrix[i][j] = matrix[i-1][j];
                }

            }
        } 
        if (matrix[coins.length][amount] > amount) return -1; //ie answer is not possible and we cant have coins more than amount
        return matrix[coins.length][amount];
    }
}
