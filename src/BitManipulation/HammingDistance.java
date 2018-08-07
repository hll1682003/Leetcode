// 461. Hamming Distance
// https://leetcode.com/problems/hamming-distance/
// Naive solution:
// import java.util.ArrayList;
// class HammingDistance {
//     public int hammingDistance(int x, int y) {
//         int count=0;
//         ArrayList<Integer> xCode=genBinary(x);
//         ArrayList<Integer> yCode=genBinary(y);
//         for (int i=0;i<Math.min(xCode.size(),yCode.size());i++)
//         {
//             if(xCode.get(i)!=yCode.get(i))
//             {
//                 count++;
//             }
//         }
        
//         for (int j=Math.min(xCode.size(),yCode.size());j<Math.max(xCode.size(),yCode.size());j++)
//         {
//             if(xCode.size()>yCode.size())
//             {
//                 if (xCode.get(j)==1)
//                 {
//                     count++;
//                 }
//             }
//             else
//             {
//                 if(yCode.get(j)==1)
//                 {
//                     count++;
//                 }
//             }
//         }
//        return count;
        
        
//     }
    
//     public ArrayList<Integer> genBinary(int num)
//     {
//         ArrayList<Integer> binary=new ArrayList<Integer>();
//          while(num>0)
//         {
//             if(num%2!=0)
//             {
//                 binary.add(1);
//             }
//             else
//             {
//                 binary.add(0);
//             }
//             num/=2;
//         }
//         return binary;
//     }
// }


// Optimal Solution:

public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
        // This is how bitCount() works:
        // n=x^y;
        // while (n > 0) {
        //     if ((n & 1) == 1) {
        //         c++;  
        //     }
        //     n >>= 1;
        // }
    }
}