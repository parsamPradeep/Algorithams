package com.algorithams.one.week4;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Runnable
{ 
    public void run() 
    {
    	
        try
        { 
            // Displaying the thread that is running 
            System.out.println ( 
                  Thread.currentThread().getName() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<n; i++) 
        { 
        	Thread object = new Thread(new Solution()); 
            object.start(); 
        } 
    } 
} 