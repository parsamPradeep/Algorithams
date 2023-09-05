package com.stivers.dp;

import java.util.Arrays;

public class GNinjasTraining {
//Recursion
	//Recursion-1
	public int trainRecur1(int day, int last, int arr[][]) {
		if(day==0) {
			int maxi=0;
			for(int i=0;i<=2;i++) {
				if(i!=last) maxi=Math.max(arr[0][i], maxi);
			}
			return maxi;
		}
		int maxi=0;
		for(int i=0;i<=2;i++) {
			if(i!=last) {
				int activity=arr[day][i]+trainRecur1(day-1, i, arr);
				maxi=Math.max(maxi, activity);
			}
		}
		return maxi;
	}
	//Recursion-2
	public int trainRecur2(int day, int last, int arr[][]) {
		if(day==arr.length-1) {
			int maxi=0;
			for(int i=0;i<=2;i++) {
				if(i!=last) maxi=Math.max(arr[arr.length-1][i], maxi);
			}
			return maxi;
		}
		int maxi=0;
		for(int i=0;i<=2;i++) {
			if(i!=last) {
				int activity=arr[day][i]+trainRecur2(day+1, i, arr);
				maxi=Math.max(maxi, activity);
			}
		}
		return maxi;
	}

//Memoization
	public int trainMemo(int day, int last, int arr[][], int dp[][]) {
		if(dp[day][last]!=-1) return dp[day][last];
		if(day==0) {
			int maxi=0;
			for(int i=0;i<=2;i++) {
				if(i!=last) maxi=Math.max(arr[0][i], maxi);
			}
			return maxi;
		}
		int maxi=0;
		for(int i=0;i<=2;i++) {
			if(i!=last) {
				int activity=arr[day][i]+trainRecur1(day-1, i, arr);
				maxi=Math.max(maxi, activity);
			}
		}
		return dp[day][last]=maxi;
	}
//Tabulation
	public int trainTab(int n, int[][] points) {

        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }
	
//Space optimization
	public int trainingSpace(int n, int[][] points) {


        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GNinjasTraining obj=new GNinjasTraining();
		int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};
		 int dp[][] = new int[points.length][4];
	        for (int[] row: dp)
	            Arrays.fill(row, -1); 
		System.out.println(obj.trainRecur1(points.length-1, 3, points));
		System.out.println(obj.trainRecur2(0, 3, points));
		System.out.println(obj.trainTab(points.length, points));
		System.out.println(obj.trainingSpace(points.length, points));
	}

}
