package org.parthvnp.Array;

public class StockBuySell {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int i = 0, j = 1;
        while (i < prices.length && j < prices.length) {
            if (prices[i] >= prices[j]) {
                i = j;
            } else {
                maxDiff = Math.max(prices[j] - prices[i], maxDiff);
            }
            j++;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        var s = new StockBuySell();
        System.out.println(s.maxProfit(new int[]{2,2}));
    }
}
