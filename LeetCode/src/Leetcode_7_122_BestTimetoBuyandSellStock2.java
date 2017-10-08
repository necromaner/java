/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-08
 * Time: 下午9:17
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Leetcode_7_122_BestTimetoBuyandSellStock2 {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] prices={1,4,2};
        System.out.println("max. difference "+solution.maxProfit1(prices));
    }
}
