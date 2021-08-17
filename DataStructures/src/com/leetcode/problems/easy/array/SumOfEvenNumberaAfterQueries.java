package com.leetcode.problems.easy.array;
/*
Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 */
public class SumOfEvenNumberaAfterQueries {
	 public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
	        int res[]=new int[queries.length];
	        int sum=0;
	        for(int j=0;j<A.length;j++)
	                if(A[j]%2==0)
	                    sum+=A[j];
	        for(int i=0;i<queries.length;i++){
	            int index=queries[i][1];
	            int val=queries[i][0];
	            
	            if(A[index]%2==0)
	                sum-=A[index];
	            A[index]+=val;
	            
	            if(A[index]%2==0)
	                sum+=A[index];
	           
	                res[i]=sum;
	        }
	        return res;
	    }
	public static void main(String[] args) {
	int A[]= {1,2,3,4};
	int queries[][]= {{1,0},{-3,1},{-4,0},{2,3}};
	int res[]=sumEvenAfterQueries(A, queries);
	for(int i:res)
		System.out.print(i+" ");
	}

}
