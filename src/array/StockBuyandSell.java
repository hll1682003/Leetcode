//121. Best Time to Buy and Sell Stock
//difficulty: easy
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class StockBuyandSell {
    public static void main(String[] args)
    {
        int[] input={5,1,2,3,4};
        System.out.println(solution(input));
    }

    public static int solution(int[] prices)
    {  int minprice=prices[0];
       int maxprofit=0;
       for (int i=1;i<prices.length;i++)
       {
           if (prices[i]<minprice)
           {
               minprice=prices[i];
           }
           if (prices[i]-minprice>maxprofit)
           {
               maxprofit=prices[i]-minprice;
           }
       }
       return maxprofit;
    }
}
