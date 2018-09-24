package test3;

import java.util.Random;

public class NthSmallestRandomNumber {

	public static void main(String[] args) 
	{
		
		//Generate 500 random numbers and print the nth smallest number in a programming language of your choice.
		Random objGenerator = new Random();
		int total=500;
		int[] randomInt = new int[total];
		
		System.out.println("============Random Number==========");
        for (int iCount = 0; iCount< total; iCount++){
          randomInt[iCount] = objGenerator.nextInt(1000);
          System.out.print(randomInt[iCount]+" "); 
         }
        
        bubbleSort(randomInt);
        
        System.out.println("\n============Sorted Number==========");
        for (int iCount = 0; iCount< total; iCount++){
            System.out.print(randomInt[iCount]+" "); 
           }	
        
        int nSmall=3;
        System.out.println("\n============No."+nSmall+" Small Number==========");
        System.out.println("============"+randomInt[nSmall-1]+"==========");
        
	}

	
	static void bubbleSort(int[] array)
	{  
		int n = array.length;  
		int temp = 0;  
		for(int i=0; i < n; i++) // Looping through the array length
		{  
			//System.out.println("Sort Pass Number "+(i+1)); 
			for(int j=1; j < (n-i); j++)
			{  
			    //System.out.println("Comparing "+ array[j-1]+ " and " + array[j]);    
				if(array[j-1] > array[j])
				{   
				    
					//swap elements  
					temp = array[j-1];  
					array[j-1] = array[j];  
					array[j] = temp;  
				    //System.out.println(array[j]  + " is greater than " + array[j-1]);
				    //System.out.println("Swapping Elements: New Array After Swap");
				}  
			}  
		}
	}
		
	
}
