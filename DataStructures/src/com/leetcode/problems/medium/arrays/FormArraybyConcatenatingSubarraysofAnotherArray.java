package com.leetcode.problems.medium.arrays;

public class FormArraybyConcatenatingSubarraysofAnotherArray {
	public static int binarySearch(int arr[], int key){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(arr[mid]==key)
                return mid;
            if(key<arr[mid])
                r=mid-1;
            else 
                l=mid+1;
        }
        return -1;
    }
    public static boolean canChoose(int[][] groups, int[] nums) {
        int tmp[]=new int[groups.length*2];
        int inx=0;
        for(int i=0;i<groups.length;i++){
            tmp[inx++]=binarySearch(nums,groups[i][0]);
            tmp[inx++]=binarySearch(nums,groups[i][groups[i].length-1]);
        }
        for(int j=0;j<tmp.length-1;j++){
            if(tmp[j]<tmp[j+1])
                return false;
        }
        return true;
    }
	public static void main(String[] args) {
	int groups[][]= {{1,-1,-1},{3,-2,0}};
	int nums[]= {1,-1,0,1,-1,-1,3,-2,0};
System.out.println(canChoose(groups, nums));

	}

}
