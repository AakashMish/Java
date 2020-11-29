/* Program to check maximum profit that could have been made with 
given stock price values corresponding to minutes */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class StockPrice
{
    public static void main(String a[])
    {
        int arr[] = {10,3,8,2,10,12,1,20,5,30,1};
        System.out.println("Max Profit = "+calculateMaxProfit(arr));
    }
    private static int calculateMaxProfit(int arr[])
    {
        List<Integer> profitList = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
        {
          for(int j=1;j<arr.length;j++)
          {
              if(arr[i]<arr[j])
                profitList.add(arr[j]-arr[i]);
          }
        }
        Collections.sort(profitList);
        return profitList.get(profitList.size()-1);
    }
}