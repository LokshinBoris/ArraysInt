package bbl.util;

import java.util.Arrays;

public class ArraysInt {
public static int[] addNumber(int[] array,int number)
{
	// apply method copyOf of class Arrays
	int [] arrayNew=new int[array.length+1];
	arrayNew=Arrays.copyOf(array,arrayNew.length);
	arrayNew[arrayNew.length-1]=number;
	return arrayNew;
}

public static int[] insertNumber(int[] array,int index, int number)
{
	
	// apply method arraycopy of class System
	
	// There should be a check index<0 and an exception here
	
	int newLength=Math.max(array.length+1,index+1);
	int []arrayNew=new int[newLength];
	int minimumOfCopy=Math.min(index,array.length);
	int maximumOfCopy=Math.max(0, array.length-index);
	System.arraycopy(array, 0, arrayNew, 0, minimumOfCopy);
	System.arraycopy(array, Math.min(array.length-1,index), arrayNew,Math.min(index+1,arrayNew.length-1), maximumOfCopy);
	arrayNew[index]=number;
	return arrayNew;
}

public static int[] removeNumber(int[] array,int index)
{
	
	// apply method arraycopy of class System
	
	// There should be a check (index < 0 || index > array.length) and an exception here
	
	int newLength=array.length-1;
	int []arrayNew=new int[newLength];
	System.arraycopy(array, 0, arrayNew, 0, index);
	System.arraycopy(array, Math.min(index+1,array.length-1), arrayNew, index, array.length-index-1);
	return arrayNew;
}

public static int[] insertSorted(int[] array,int number)
{
	
	// Insert number into array with keeping the sorted order
	// applay method binarySearch of class Arrays
	int newLength=array.length;
	int []arrayTemp=new int[newLength];
	
	arrayTemp=Arrays.copyOf(array,array.length);
	Arrays.sort(arrayTemp);
	int index=Arrays.binarySearch(arrayTemp, number);
	if(index<0) index=-(index+1);

	int [] arrayNew=insertNumber(arrayTemp,index,number);
		
	return arrayNew; 
}
}
